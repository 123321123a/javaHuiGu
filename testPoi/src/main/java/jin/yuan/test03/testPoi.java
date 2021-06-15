package jin.yuan.test03;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import jin.yuan.test04.entity.Emp;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testPoi {
   public List<Emp> getUsers(){
      List<Emp> users = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         Emp user = new Emp();
         user.setId(String.valueOf(i));
         //user.setPhoto("/Users/jinyanping/Desktop/一堆破烂/01.jpg");
         users.add(user);
      }
      return users;
   }

   @Test
   public void testExport() throws IOException {
      List<Emp> users = getUsers();
      // 参数1：exportParams 导出配置对象    参数2：导出的类型    参数3：导出的数据集合
      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), Emp.class, users);
      FileOutputStream fileOutputStream = new FileOutputStream("/Users/jinyanping/Desktop/aa.xls");
      workbook.write(fileOutputStream);
      fileOutputStream.close();
      workbook.close();
   }

   @Test
   public void testExportBIG() throws IOException {
      List<Emp> users = getUsers();
      // 参数1：exportParams 导出配置对象    参数2：导出的类型    参数3：导出的数据集合
      Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("用户信息列表", "用户信息"), Emp.class, users);
      FileOutputStream fileOutputStream = new FileOutputStream("/Users/jinyanping/Desktop/big.xls");
      workbook.write(fileOutputStream);
      fileOutputStream.close();
      workbook.close();
   }
}
