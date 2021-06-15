package jin.yuan.多线程;

import java.time.Year;

public class Test多线程02 {

   public static void main(String[] args) throws InterruptedException {
      T t = new T();
      t.start();

      Thread.sleep(10 * 1000);
      t.setFlag(false);
      t.interrupt();
   }
}


class T extends Thread{

   private boolean flag = true;
   private int num = 0;
   @Override
   public void run() {
      while (flag){
         System.out.println(Thread.currentThread().getName() + "-->" + (++num));
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   public void setFlag(boolean flag) {
      this.flag = flag;
   }
}





















