package jin.yuan.jvm;

public class ClassLoaderTest {
   public static void main(String[] args) {
      // 获取系统类加载器
      ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); //sun.misc.Launcher$AppClassLoader@18b4aac2
      System.out.println(systemClassLoader);

      //获取其上层：扩展类加载器
      ClassLoader extClassLoader = systemClassLoader.getParent(); //sun.misc.Launcher$ExtClassLoader@1540e19d
      System.out.println(extClassLoader);

      //获取其上层：启动类加载器
      ClassLoader bootStrapClassLoader = extClassLoader.getParent(); //null  （获取不到引导类加载器）
      System.out.println(bootStrapClassLoader);

      //对于用户自定义的类来说：默认的是使用 系统类加载器进行加载
      ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
      System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

      // string 类是使用引导类加载器加载的 ---> java 的核心类库都是使用引导类加载器加载的
      ClassLoader classLoader1 = String.class.getClassLoader();
      System.out.println(classLoader1); //null
   }
}





















