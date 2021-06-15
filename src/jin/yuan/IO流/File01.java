package jin.yuan.IO流;

import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIUserConversion;
import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;

public class File01 {

   @Test
   public void FileInputStream01(){
      String filePath = "/Users/jinyanping/Desktop/今日内容.txt";
      int length = 0;
      FileInputStream fileInputStream = null;
      byte[] bytes = new byte[1024];
      try {
         fileInputStream = new FileInputStream(filePath);
         // 从该输入流中读取一个字节的数据，如果没有输入可用，此方法将会终止
         // 返回为-1 则表示读取完毕，如果读取正常，返回实际读取的字节数
         while ((length = fileInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,length));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         //关闭文件流，释放资源
         try {
            fileInputStream.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   //写入数据到文件，如果文件不存在，创建该文件
   @Test
   public void FileOutPutStream01(){
      String filePath = "/Users/jinyanping/Desktop/a.txt";
      FileOutputStream fileOutputStream = null;
      try {
         //fileOutputStream = new FileOutputStream(filePath,true); //追加到文件的末尾
         fileOutputStream = new FileOutputStream(filePath);
         fileOutputStream.write("HHHH".getBytes());
      } catch (Exception e) {
         e.printStackTrace();
      }finally{
         try {
            fileOutputStream.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Test
   public void FileReader01(){
      String filePath = "/Users/jinyanping/Desktop/今日内容.txt";
      FileReader fileReader  = null;
      int readLen = 0;
      char[] chars = new char[10];
      try {
         fileReader = new FileReader(filePath);
         //循环读取，返回的是实际读取到的字符数
         while ((readLen = fileReader.read(chars)) != -1){
            System.out.print(new String(chars,0,readLen));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            fileReader.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Test
   public void FileWriter01(){
      FileWriter fileWriter = null;
      String filePath = "/Users/jinyanping/Desktop/a.txt";
      try {
         fileWriter = new FileWriter(filePath,true);
         /*
         public void write(int c)：写单个字符
         public void write(char[] cbuf)：写字符数组
         public abstract void write(char[] cbuf, int off,  int len)：写字符数组的一部分
         public void write(String str)：写字符串
         public void write(String str,int off, int len)：写字符串的某一部分
          */
         String content = "我是写入到的文件中的内容";
         fileWriter.write(content);
      } catch (IOException e) {
         e.printStackTrace();
      }finally {
         try {
            fileWriter.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Test
   public void BufferReaderTest() throws Exception{
      String filePath = "/Users/jinyanping/Desktop/今日内容.txt";
      BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
      String readLine = " ";
      while ((readLine = bufferedReader.readLine()) != null){ //按行读取
         System.out.println(readLine);
      }
      //只需要关闭 bufferedReader ，因为底层会自动关闭节点流
      bufferedReader.close();
   }

   @Test
   public void BufferWriterTest() throws Exception{
      String filePath = "/Users/jinyanping/Desktop/b.txt";
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
      bufferedWriter.write("我是谁");
      bufferedWriter.newLine(); //插入一个换行
      bufferedWriter.write("谁是我");
      bufferedWriter.close();
   }


   // BufferedInputStream 和 BufferedOutputStream 实现文件的复制
   @Test
   public void BufferedInputStreamTest() throws Exception{
      String src = "/Users/jinyanping/Desktop/一堆破烂/01.jpg";//源文件的路径
      String des = "/Users/jinyanping/Desktop/b.jpg";//目标文件的路径
      BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(src));
      BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(des));
      int readLen = 0;
      byte[] bytes = new byte[1024];
      while ((readLen = inputStream.read(bytes)) != -1){
         outputStream.write(bytes,0,readLen);
      }
      inputStream.close();
      outputStream.close();
   }

   //
   @Test
   public void ObjectOutputStreamTest() throws Exception{
      //序列化后，保存的文件格式不是文本，而是按照程序来指定的格式来保存
      String des = "/Users/jinyanping/Desktop/data.dat";
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(des));
      //序列化数据到文件中
      outputStream.writeInt(100); // int 类型实现了序列化接口
      outputStream.writeBoolean(true);
      outputStream.writeChar('a');
      outputStream.writeUTF("放的是字符串");
      outputStream.writeObject(new Dog("旺财",12));
      outputStream.close();
   }

   //反序列化
   @Test
   public void ObjectInputStreamTest() throws Exception{
      String des = "/Users/jinyanping/Desktop/data.dat";
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(des));
      System.out.println(inputStream.readInt());
      System.out.println(inputStream.readBoolean());
      System.out.println(inputStream.readChar());
      System.out.println(inputStream.readUTF());
      System.out.println((Dog)inputStream.readObject());
      /*
         100
         true
         a
         放的是字符串
         Dog{name='旺财', age=12}
       */
      inputStream.close();
   }


   @Test
   public void InputStreamReaderTest() throws Exception {
      Properties properties = new Properties();
      properties.load(new FileReader("..../文件路径"));
      // 把 k-v 显示到控制台
      properties.list(System.out);
      //根据 key 获取对应的值
      String user = properties.getProperty("user");
      System.out.println("用户名为" + user);
   }

}

class Dog implements Serializable{
   private String name;
   private int age;


   public Dog(String name, int age) {
      this.name = name;
      this.age = age;
   }

   @Override
   public String toString() {
      return "Dog{" +
              "name='" + name + '\'' +
              ", age=" + age +
              '}';
   }
}





















