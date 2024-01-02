package com.example.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.system.pojo.ProductPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<ProductPojo> {
}
