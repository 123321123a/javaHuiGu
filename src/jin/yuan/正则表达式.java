package jin.yuan;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式 {



   public static void main(String[] args) {
      String content = "39vtu3";
      String regStr = "\\w+";
      boolean matches = Pattern.matches(regStr, content);
      System.out.println(matches);
   }

   @Test
   public void test01(){
      //例：在 39vtu3 字符串中，是否符合指定的正则表达式：\w+
      // 创建表达式对象
      Pattern p = Pattern.compile("\\w+");
      // 创建 Matcher 匹配器
      Matcher m = p.matcher("39vtu3&&haha");
      while (m.find()){  // m.find()：该方法扫描输入的序列，查找与该模式匹配的下一个子序列
         System.out.println(m.group()); // group() 和 group(0) 匹配整个表达式的字符串
         System.out.println(m.group(0));
      }
   }

   //group 分组的使用
   @Test
   public void test02(){
      Pattern p = Pattern.compile("([a-z]+)([0-9]+)",Pattern.CASE_INSENSITIVE);
      Matcher m = p.matcher("aa2233**rr55*rr0r");
      /**
       * m.find()：
       *    1.根据指定的规则定位满足规则的子字符串
       *    2.找到后将子字符串的索引记录到 matcher 对象属性中 int[] groups;
       *       2.1 groups[0] = 0，把该子字符串的结束位置的索引 +1 的值记录到 groups[1] = 4
       *       2.2 将第一组() 匹配到的字符串记录到 groups[2]=? groups[3]=?
       *       2.3 将第二组() 匹配到的字符串记录到 groups[4]=? groups[5]=?
       *       2.4 如果有更多的分组以此类推...
       *
       *    3.同时记录 oldLast 的值为 字符串的结束位置的索引+1，即4，即下次执行 find 方法时，就从4 开始匹配
       *
       * m.group(0)
       *    1.根据 group(0) 和 group(1) 记录的位置，从 content 开始截取字符串开始返回
       *
       * 如果再次指向 find 方法，仍然按照上面的来执行
       */
      while (m.find()){
         System.out.println(m.group());  // aa2233 - rr55 - rr0
         System.out.println(m.group(1)); // aa - rr - rr
         System.out.println(m.group(2)); // 2233 - 55 - 0
      }
   }

   //正则 替换 和 分割
   @Test
   public void test03() {
      Pattern p = Pattern.compile("[0-9]");
      Matcher m = p.matcher("aa2233**rr55*rr0r");
      //替换
      System.out.println(m.replaceAll("#")); // aa####**rr##*rr#r

      // 分割
      String s = "aa2233rr55rr0r";
      String[] arrs = s.split("\\d+");// 按照数字进行切割
      System.out.println(Arrays.toString(arrs)); // [aa, rr, rr, r]
   }

   @Test
   public void test04(){
      String content = "我...我要....学学学学....编程java！";
      //第一步：去掉所有的 .
      Pattern pattern = Pattern.compile("\\.");
      Matcher matcher = pattern.matcher(content);
      content = matcher.replaceAll("");
      System.out.println(content);

      //第二步：去掉重复的字
      /* 思路：
         1.使用 (.)\\1+
         2.使用反向引用 $1 来替换匹配到的内容
       */
//      pattern = Pattern.compile("(.)\\1+");
//      matcher = pattern.matcher(content);
//      while (matcher.find()){
//         System.out.println("找到="+matcher.group(0));
//      }
//      content = matcher.replaceAll("$1");
//      System.out.println(content);

      //第三步：使用一条语句解决
      content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
      System.out.println(content);
   }

   @Test
   public void test05(){
      // 题1：使用正则 将 z 和 b 替换为 j
      String content = "jyp zxbcc";
      content = content.replaceAll("z|b","j");
      System.out.println(content);

      // 题2：验证手机号，必须是 138 和 139 开头的
      content = "13655555555";
      if (content.matches("1(38|39)\\d{8}")){
         System.out.println("验证成功");
      }else {
         System.out.println("验证失败");
      }

      // 题3：要求按照#或者-或者~或者数字来分割 字符串
      content = "hello#abc-jack12smith~北京";
      String[] split = content.split("#|-|~|\\d+");
      System.out.println(Arrays.toString(split));
   }

}











