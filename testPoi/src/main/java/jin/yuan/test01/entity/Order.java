package jin.yuan.test01.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ExcelTarget("orders")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {
   @Excel( name="订单编号" , orderNum = "8" , width = 20.0)
   private  String no;
   @Excel (name="订单名称" , orderNum = "9 " , width =15.0)
   private String  name;
}
