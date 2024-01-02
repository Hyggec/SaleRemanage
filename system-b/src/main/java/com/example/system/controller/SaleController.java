package com.example.system.controller;


import com.example.system.service.SaleService;
import com.example.system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleController {
    @Autowired
    SaleService saleService;

    @RequestMapping(value = "/addSale",method = RequestMethod.POST)
    public String addSale(@RequestParam("transactionId")String transactionId,
                          @RequestParam("name")String name,
                          @RequestParam("salespersonId")String  salespersonId,
                          @RequestParam("pname")String pname,
                          @RequestParam("productId")String productId,
                          @RequestParam("days")String days,
                          @RequestParam("salesTime")String salesTime,
                          @RequestParam("salesQuantity")int salesQuantity,
                          @RequestParam("salesAmount")int salesAmount){
        saleService.addSale(transactionId, name,  salespersonId, pname,productId, days, salesTime, salesQuantity, salesAmount);
        return Result.okGetString("增加成功");
    }

    @RequestMapping(value = "/delSale",method = RequestMethod.DELETE)
    public String delSale(@RequestParam("transactionId")String transactionId){
        saleService.delSale(transactionId);
        return Result.okGetString("删除成功");
    }

    @RequestMapping(value = "/findSale/{transactionId}")
    public String findSale(@PathVariable("transactionId")String transactionId){
        Object list = saleService.findSale(transactionId);
        return Result.okGetString2("查找成功",list);
    }

    @RequestMapping(value = "/updateSale",method = RequestMethod.PUT)
    public String updateSale(
                             @RequestParam("name")String name,
                             @RequestParam("transactionId")String transactionId,
                             @RequestParam("salespersonId")String  salespersonId,
                             @RequestParam("pname")String pname,
                             @RequestParam("productId")String productId,
                             @RequestParam("days")String days,
                             @RequestParam("salesTime")String salesTime,
                             @RequestParam("salesQuantity")int salesQuantity,
                             @RequestParam("salesAmount")int salesAmount){
        saleService.updateSale(transactionId ,name, salespersonId, pname, productId, days,salesTime, salesQuantity, salesAmount);
        System.out.println("更新成功");
        return Result.okGetString("更新成功");
    }

    @RequestMapping(value = "/leMonth/{days}")
    public Object saleMonth(@PathVariable("days")String days) {
        Object list = saleService.saleMonth(days);

        return Result.okGetString2("更新成功", list);
    }
    @RequestMapping(value = "/ProductMonth/{days}")
    public String ProductMonth(@PathVariable("days")String days){
        Object list = saleService.productMonth(days);
        return Result.okGetString2("查找成功",list);
    }
    @RequestMapping(value = "/getSale")
    public String getSaleBySalesAmount() {
        Object list = saleService.getSaleBySalesAmount();
        return Result.okGetString2("获取成功", list);
    }
}