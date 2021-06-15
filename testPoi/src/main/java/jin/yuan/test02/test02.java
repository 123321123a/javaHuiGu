package jin.yuan.test02;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import jin.yuan.test02.entity.DEP;
import jin.yuan.test02.entity.EMP;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test02 {

   public List<DEP> getList(){
      List<DEP> deps = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         DEP dep = new DEP();
         dep.setDepNo(i + "");
         List<EMP> emps = new ArrayList<>();
         emps.add(new EMP("" + i,"金源"  + i));
         emps.add(new EMP("" + i + 1,"韶光"  + i + 1));
         emps.add(new EMP("" + i + 2,"元稹"  + i + 2));
         dep.setEmps(emps);
         deps.add(dep);
      }
      return deps;
   }


   @Test
   public void test01() throws IOException {
      List<DEP> list = getList();
      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), DEP.class, list);
      FileOutputStream fileOutputStream = new FileOutputStream("/Users/jinyanping/Desktop/b.xls");
      workbook.write(fileOutputStream);
      fileOutputStream.close();
      workbook.close();
   }
}


















