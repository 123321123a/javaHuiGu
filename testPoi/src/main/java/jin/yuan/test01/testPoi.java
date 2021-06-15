package jin.yuan.test01;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import jin.yuan.test01.entity.Order;
import jin.yuan.test01.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testPoi {
   //模拟数据库查出来的数据
   public List<User> getUsers(){
      List<User> users = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         User user = new User();
//         Card card = new Card();
//         card.setAddress("四川省成都市");
//         card.setNo("23");
         user.setId(String.valueOf(i));
//         user.setName("金金" + i);
//         user.setAge(10+i);
//         user.setBir(new Date());
//         user.setHobby(Arrays.asList("打篮球","睡觉"));
//         user.setCard(card);
         List<Order> orders = new ArrayList<>();
         orders.add(new Order("12","上衣"));
         orders.add(new Order("13","外衣"));
         orders.add(new Order("14","鞋"));
         user.setOrders(orders);
         users.add(user);
      }
      return users;
   }

   // 导出 Excel
   @Test
   public void testExport() throws IOException {
      List<User> users = getUsers();
      // 参数1：exportParams 导出配置对象    参数2：导出的类型    参数3：导出的数据集合
      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
      FileOutputStream fileOutputStream = new FileOutputStream("/Users/jinyanping/Desktop/aa.xls");
      workbook.write(fileOutputStream);
      fileOutputStream.close();
      workbook.close();
   }
}




















