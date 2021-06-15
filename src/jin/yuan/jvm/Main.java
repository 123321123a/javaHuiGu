package jin.yuan.jvm;

public class Main {
   public static void main(String[] args){

   }

   public void mA(){
      int i = 10;
      int j = 20;
      mB();
   }

   private void mB() {
      int k = 30;
      int m = 40;
   }

}
