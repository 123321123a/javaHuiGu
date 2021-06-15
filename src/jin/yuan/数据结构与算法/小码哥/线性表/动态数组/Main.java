package jin.yuan.数据结构与算法.小码哥.线性表.动态数组;

import org.junit.Test;

public class Main {
   public static void main(String[] args) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      arrayList.add(1);
      arrayList.add(2);
      arrayList.add(3);
      arrayList.add(4);
      System.out.println(arrayList.toString());
   }

   @Test
   public void test01(){
      ArrayList<Person> arrayList = new ArrayList<>();
      arrayList.add(new Person(12,"金源"));
      arrayList.add(new Person(11,"金源"));
      arrayList.add(new Person(10,"金源"));
      System.out.println(arrayList.toString());
   }
}
