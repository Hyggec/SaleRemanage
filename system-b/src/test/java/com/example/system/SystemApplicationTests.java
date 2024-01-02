package com.example.system;

import com.example.system.service.SalemanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemApplicationTests {

    @Autowired
    SalemanService salemanService;
    @Test
    void contextLoads() {
        salemanService.addSaleman("20","猫雷");
//        salemanService.removeSaleman("20");
//        salemanService.updateSalemanByName("20","猫雷2");
    }

}
