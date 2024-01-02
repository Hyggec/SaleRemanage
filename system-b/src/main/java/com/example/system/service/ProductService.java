package com.example.system.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.dao.ProductDao;
import com.example.system.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public void addProduct(String number,String pname){
        productDao.insert(new ProductPojo(number,pname));
    }
    public void delProduct(String number){
        productDao.deleteById(number);
    }
    public Object findProduct(String pname){
        List<ProductPojo> pojo = productDao.selectList(new QueryWrapper<ProductPojo>().like("pname",pname));
        pojo.forEach(item->{
            System.out.println(item);
        });
        return pojo;
    }
    public void  updateProduct(String number,String pname){
        ProductPojo pojo  = productDao.selectById(number);
        pojo.setPname(pname);
        productDao.update(pojo,new QueryWrapper<ProductPojo>().eq("number",number));
    }
    public List<ProductPojo> getProductBySalesAmount() {
        QueryWrapper<ProductPojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc ("number");
        return productDao.selectList(queryWrapper);
    }

}
