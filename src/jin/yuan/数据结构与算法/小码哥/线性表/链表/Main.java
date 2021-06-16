package jin.yuan.数据结构与算法.小码哥.线性表.链表;

public class Main {
   public static void main(String[] args) {
      LinkedList<Integer> linkedList = new LinkedList<>();
      linkedList.add(20);

      linkedList.add(10);
      linkedList.add(0);
      linkedList.set(0,100);
      linkedList.add(0,300);
      System.out.println(linkedList.toString());
      System.out.println("这是 hot-fix 分支的代码");

   }
}
