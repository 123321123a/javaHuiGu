package jin.yuan.test04.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("user")
public class Emp implements Serializable {
   @Excel(name = "编号")
   private String id;
   @Excel(name = "姓名")
   private String name;
   @Excel(name = "年龄")
   private Integer age;
   @Excel(name = "生日",format = "yyyy-MM-dd")
   private Date bir;
   @Excel(name = "状态",replace = {"激活_1","锁定_0"})
   private String status;
}
