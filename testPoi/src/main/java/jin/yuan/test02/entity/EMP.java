package jin.yuan.test02.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ExcelTarget("EMP")
@AllArgsConstructor
@NoArgsConstructor
public class EMP {
   @Excel(name = "员工id")
   private String empId;
   @Excel(name = "员工姓名")
   private String name;
}

