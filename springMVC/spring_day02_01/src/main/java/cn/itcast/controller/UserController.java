package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload")
    public String fileupload(MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传...");
        //定义上传文件的服务器路径
        String path = "http://localhost:9090/uploads/";

        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置成唯一值
        String s = UUID.randomUUID().toString().replace("-", "");
        filename = s +"_"+filename;

        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource resource = client.resource(path + filename);

        //上传文件
        resource.put(upload.getBytes());

        return "success";
    }
}
