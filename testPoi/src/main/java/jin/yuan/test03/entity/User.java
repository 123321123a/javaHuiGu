package jin.yuan.test03.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("user")
public class User implements Serializable {
   @Excel(name = "编号" ,orderNum = "1")
   private String id;
   @Excel(name = "头像",orderNum = "2",width = 20,height = 20,type = 2)
   private String photo;
}
