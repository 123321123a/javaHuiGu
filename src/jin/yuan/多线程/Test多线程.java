package jin.yuan.多线程;

public class Test多线程 {
   public static void main(String[] args) throws InterruptedException {
      // 创建 cat 对象，可以当做线程使用
      Cat cat = new Cat();
      cat.start();// 启动线程

      for (int i = 0; i < 60; i++) {
         Thread.sleep(1000);
         System.out.println("执行了");
      }
   }
}

// extends Thread --> 该类就可以当线程使用
// 会重写 run 方法，--> Thread 实现了 Runnable 接口的 run 方法
class Cat extends Thread{
   @Override
   public void run() { // 重写 run 方法，写上自己的业务逻辑
      while (true){
         System.out.println("你好");
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
