package jin.yuan.test02.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ExcelTarget("dep")
public class DEP implements Serializable {
   @Excel(name = "职员表的id" ,orderNum = "1")
   private String depNo;
   @ExcelCollection(name = "职员",orderNum = "2")
   private List<EMP> emps;
}
