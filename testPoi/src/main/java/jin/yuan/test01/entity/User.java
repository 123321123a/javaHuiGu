package jin.yuan.test01.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;


import java.io.Serializable;
import java.util.List;

@Data
@ExcelTarget(value = "users") // value 是唯一标识
public class User implements Serializable {
//   @ExcelIgnore
   @Excel(name = "编号",orderNum = "0")
   private String id;
//   @Excel(name = "姓名",orderNum ="1")
//   private String name;
//   @Excel(name = "年龄",orderNum = "2")
//   private Integer age;
//   @Excel(name = "生日",width = 30.0,format = "yyyy-MM-dd",orderNum = "3")
//   private Date bir;
//
//   @ExcelIgnore
//   private List<String> hobby;
//
//   @Excel(name = "爱好",width = 20.0,orderNum = "4")
//   private String hobbyStr;
//
//   @ExcelEntity // 标志一对一关系
//   private Card card;
//   public String getHobbyStr() {
//      StringBuilder sb = new StringBuilder();
//      hobby.forEach(s -> {
//         sb.append(s).append("、");
//      });
//      return sb.toString();
//   }

   @ExcelCollection(name = "订单列表", orderNum = "2")
//   @ExcelCollection(name = "订单列表")
   private List<Order> orders;
}





















