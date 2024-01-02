package com.example.system.controller;


import com.example.system.service.ProductService;
import com.example.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public String addProduct(@RequestParam("number")String number,
                             @RequestParam("pname")String pname){
        productService.addProduct(number, pname);
        return Result.okGetString("增加成功");
    }

    @RequestMapping(value = "/delProduct",method = RequestMethod.DELETE)
    public String delProduct(@RequestParam("number")String number){
        productService.delProduct(number);
        return Result.okGetString("删除成功");
    }

    @RequestMapping(value = "/findProduct/{pname}")
    public String findProduct(@PathVariable("pname")String pname){
        Object list = productService.findProduct(pname);
        return Result.okGetString2("查找成功",list);
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.PUT)
    public String updateProduct(@RequestParam("number")String number,
                                @RequestParam("pname")String pname){
        productService.updateProduct(number, pname);
        return Result.okGetString("更新成功");
    }
    @RequestMapping(value = "/getProductBySalesAmount")
    public String getProductBySalesAmount(){
        Object list = productService.getProductBySalesAmount();
        return Result.okGetString2("获取成功",list);
    }

}
