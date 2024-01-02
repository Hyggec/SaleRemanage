package com.example.system.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sale")
public class SalePojo {
    @TableId(value = "transactionId",type = IdType.ASSIGN_ID)
    private String transactionId;
    @TableField(value = "name")
    private String name;
    @TableField(value = " salespersonId")
    private String  salespersonId;
    @TableField(value = "pname")
    private String pname;
    @TableField(value = "productId")
    private String productId;
    @TableField(value = "days")
    private String days;
    @TableField(value = "salesTime")
    private String salesTime;
    @TableField(value = "salesQuantity")
    private int salesQuantity;
    @TableField(value = "salesAmount")
    private int salesAmount;


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(String salespersonId) {
        this.salespersonId = salespersonId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getSalesTime() {
        return salesTime;
    }

    public void setSalesTime(String salesTime) {
        this.salesTime = salesTime;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }


}
