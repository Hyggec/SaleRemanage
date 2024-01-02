package com.example.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.dao.SalemanDao;
import com.example.system.pojo.SalemanPojo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalemanService  {
    @Autowired
    SalemanDao salemanDao;

    public void addSaleman(String name,String salemanid){
        salemanDao.insert(new SalemanPojo(name,salemanid));
    }
    public void delSaleman(String id){
        salemanDao.deleteById(id);
    }
    public Object findSaleman(String name){
        List<SalemanPojo> pojo = salemanDao.selectList(new QueryWrapper<SalemanPojo>().like("name",name));
        pojo.forEach(item->{
            System.out.println(item);
        });
        return pojo;
    }
    public void  updateSaleman(String name,String salemanid){
        SalemanPojo pojo  = salemanDao.selectById(salemanid);
        pojo.setName(name);
        salemanDao.update(pojo,new QueryWrapper<SalemanPojo>().eq("salemanid",salemanid));
    }

    public List<SalemanPojo> getSalemanBySalesAmount() {
        QueryWrapper<SalemanPojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc ("salemanid");
        return salemanDao.selectList(queryWrapper);
    }
}

