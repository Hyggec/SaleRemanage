package com.example.system.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.system.pojo.SalemanPojo;
import com.example.system.service.SalemanService;
import com.example.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SalemanController {
    @Autowired
    SalemanService salemanService;

    @RequestMapping(value = "/addSaleman",method = RequestMethod.POST)
    public String addSaleman(
            @RequestParam("salemanid") String id,
            @RequestParam("name")String name){
        salemanService.addSaleman(name, id);
        return Result.okGetString("增加成功");
    }

    @RequestMapping(value = "/delSaleman",method = RequestMethod.DELETE)
    public String delSaleman(@RequestParam("salemanid")String id){
        salemanService.delSaleman(id);
        return Result.okGetString("删除成功");
    }

    @RequestMapping(value = "/findSaleman/{name}")
    public String findSaleman(@PathVariable("name")String name){
        Object list = salemanService.findSaleman(name);
        return Result.okGetString2("查找成功",list);
    }

    @RequestMapping(value = "/updateSaleman",method = RequestMethod.PUT)
    public String updateSaleman(
                                @RequestParam("salemanid")String salemanid,
                                @RequestParam("name")String name){
        salemanService.updateSaleman(name,salemanid);
        return Result.okGetString("更新成功");
    }

    @RequestMapping(value = "/getSalemanBySalesAmount")
    public String getSalemanBySalesAmount(){
        List<SalemanPojo>  list = salemanService.getSalemanBySalesAmount();
       return Result.okGetString2("获取成功",list);

    }


}
