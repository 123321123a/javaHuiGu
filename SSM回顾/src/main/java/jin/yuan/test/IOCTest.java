package jin.yuan.test;

import jin.yuan.bean.Car;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


public class IOCTest {
   @Test
   public void test01(){
      //ApplicationContext 代表 IOC 容器
      // ClassPathXml：意思就是当前应用的xml配置文件在类路径（ClassPath）下
      ApplicationContext context = new ClassPathXmlApplicationContext("ioc2.xml");
      //容器帮我们创建好了对象；并且容器只要一启动，容器中所有的对象都会创建出来
      Car car = (Car) context.getBean("myFactoryBean");
      System.out.println(car);
   }

   @Test
   public void test02() throws SQLException {
      //从容器中拿到连接池
      ApplicationContext context = new ClassPathXmlApplicationContext("ioc2.xml");
      //如果按照类型获取组件，可以获取到这个类型下的所有实现类，子类等等
      DataSource dataSource = context.getBean(DataSource.class);
      System.out.println(dataSource.getConnection());
   }
}











