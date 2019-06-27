package com.itheima.dao;

import com.itheima.domain.Items;

public interface ItemsDao {
    //根据id查询商品
    public Items findById(Integer id);
}
