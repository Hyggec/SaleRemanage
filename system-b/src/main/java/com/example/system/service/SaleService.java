package com.example.system.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.dao.SaleDao;
import com.example.system.pojo.SalePojo;
import com.example.system.pojo.SalemanPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaleService {
    @Autowired
    SaleDao saleDao;
    int sum = 0;
    public void addSale(String transactionId,String name,String  salespersonId,String pname,String productId,String days,String salesTime,int salesQuantity,int salesAmount){

        saleDao.insert(new SalePojo(transactionId,name, salespersonId,pname,productId,days,salesTime,salesQuantity,salesAmount));
    }

    public void delSale(String transactionId){
        saleDao.deleteById(transactionId);
    }

    public Object findSale(String transactionId){
        List<SalePojo> pojo = saleDao.selectList(new QueryWrapper<SalePojo>().like("transactionId",transactionId));
        pojo.forEach(item->{
            System.out.println(item);
        });
        return pojo;
    }
    public void  updateSale(String transactionId,String name,String  salespersonId,String pname,String productId,String days,String salesTime,int salesQuantity,int salesAmount){
        SalePojo pojo  = saleDao.selectById(transactionId);
        pojo.setName(name);
        pojo.setSalespersonId( salespersonId);
        pojo.setPname(pname);
        pojo.setProductId(productId);
        pojo.setDays(days);
        pojo.setSalesTime(salesTime);
        pojo.setSalesQuantity(salesQuantity);
        pojo.setSalesAmount(salesAmount);
        saleDao.update(pojo,new QueryWrapper<SalePojo>().eq("transactionId",transactionId));
    }



    public Object saleMonth(String days){
        List<SalePojo> pojo = saleDao.selectList(new QueryWrapper<>());
        // 创建一个Map，用来存储销售员的id，姓名和月销售额
        Map<String, Object> map = new HashMap<String, Object>();
        for (SalePojo item : pojo){
            // 获取销售员的id和姓名
            String id = item.getSalespersonId();
            String name = item.getName();
            // 判断销售日期是否是指定的月份
            String month = item.getDays().substring(0,7);
            if(month.equals(days)){
                // 如果是，累加销售额
                double sum = item.getSalesAmount();
                // 如果Map中已经有该销售员的信息，更新月销售额
                if(map.containsKey(id)){
                    Map<String, Object> info = (Map<String, Object>) map.get(id);
                    double oldSum = (double) info.get("sum");
                    info.put("sum", oldSum + sum);
                }else{
                    // 如果Map中没有该销售员的信息，创建一个新的Map，存储id，姓名和月销售额
                    Map<String, Object> info = new HashMap<String, Object>();
                    info.put("id", id);
                    info.put("name", name);
                    info.put("sum", sum);
                    // 将新的Map放入Map中，以id为键
                    map.put(id, info);
                }
            }
        }
//        printMap(map);
        // 返回Map，包含每个销售员的id，姓名和月销售额
        return map;
    }
//    public void printMap(Map<String, Object> map) {
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            String id = entry.getKey();
//            Map<String, Object> info = (Map<String, Object>) entry.getValue();
//            String name = (String) info.get("name");
//            double sum = (double) info.get("sum");
//            System.out.println("ID: " + id + ", Name: " + name + ", Sales Amount: " + sum);
//        }
//    }
    public  Object productMonth(String days){
        List<SalePojo> pojo = saleDao.selectList(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<String, Object>();
        for (SalePojo item : pojo){
            String id = item.getProductId();
            String month = item.getDays().substring(0,7);
            if(month.equals(days)){
                // 如果是，累加销售额
                double sum = item.getSalesAmount();
                if(map.containsKey(id)){
                    Map<String, Object> info = (Map<String, Object>) map.get(id);
                    double oldSum = (double) info.get("sum");
                    info.put("sum", oldSum + sum);
                }else{
                    // 如果Map中没有该销售员的信息，创建一个新的Map，存储id，姓名和月销售额
                    Map<String, Object> info = new HashMap<String, Object>();
                    info.put("productid", id);
                    info.put("sum", sum);
                    // 将新的Map放入Map中，以id为键
                    map.put(id, info);
                }

            }
        }
        return map;
    }
    public List<SalePojo> getSaleBySalesAmount() {
        QueryWrapper<SalePojo> queryWrapper = new QueryWrapper<>();
        return saleDao.selectList(queryWrapper);
    }

}
