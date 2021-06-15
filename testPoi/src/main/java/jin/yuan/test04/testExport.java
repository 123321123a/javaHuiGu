package jin.yuan.test04;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import jin.yuan.test04.entity.Emp;
import org.junit.Test;


import java.io.FileInputStream;
import java.util.List;

public class testExport {

   @Test
   public void testImport() throws Exception {
      // 参数1：导入的 Excel 文件流，参数2：导入的类型，参数3：导入的配置对象
      ImportParams params = new ImportParams();
      params.setTitleRows(1); // 标题列占几行
      params.setHeadRows(2); // header 列占几行
      params.setStartSheetIndex(2);
      params.setSheetNum(3);
      params.setImportFields(new String[]{"编号","家庭住址"});
      List<Emp> emps = ExcelImportUtil.importExcel(new FileInputStream("/Users/jinyanping/Desktop/导入的数据.xlsx"), Emp.class, params);
      System.out.println(emps);
   }
}
