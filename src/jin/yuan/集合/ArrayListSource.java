package jin.yuan.集合;

import org.junit.Test;

import java.util.*;

@SuppressWarnings({"all"})
public class ArrayListSource {

   public static void main(String[] args) {
      HashSet<String> strings = new HashSet<>();
      strings.add("java");
      strings.add("php");
      strings.add("java");
      strings.size();
   }

   @Test
   public void test01(){
      LinkedHashSet<Object> hashset = new LinkedHashSet<>();
      hashset.add(new String("AA"));
      hashset.add(456);
      hashset.add(456);
      hashset.add(123);
      hashset.add("jyp");
   }

   @Test
   public void test02(){
      new TreeMap<>(new Comparator<Object>() {
         @Override
         public int compare(Object o1, Object o2) {
            // 按照 key 进行排序
            return ((String)o1).compareTo((String)o1);
         }
      });
   }
}
