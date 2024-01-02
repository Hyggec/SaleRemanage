package  com.example.system.pojo;


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
@TableName(value = "saleman" )
public class SalemanPojo {
    @TableField(value = "name")
    private String name;
    @TableId(value = "salemanid",type = IdType.ASSIGN_ID)
    private String salemanid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalemanid() {
        return salemanid;
    }

    public void setSalemanid(String salemanid) {
        this.salemanid = salemanid;
    }
}
