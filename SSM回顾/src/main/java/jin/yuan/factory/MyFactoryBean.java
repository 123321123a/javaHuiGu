package jin.yuan.factory;

import jin.yuan.bean.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现了 FactoryBean 接口的类是 spring 可以认识的工厂类；
 * spring 会自动调用工厂方法创建实例
 */
public class MyFactoryBean implements FactoryBean<Car> {
   // 工厂方法：spring 自动调用，返回我们需要的对象
   @Override
   public Car getObject() throws Exception {
      Car car = new Car("宝马",120,"黑色");
      return car;
   }

   // 返回创建的对象类型，spring 会自动调用这个方法来确认创建的对象是什么类型
   @Override
   public Class<?> getObjectType() {
      return null;
   }

   //是单例吗？
   @Override
   public boolean isSingleton() {
      return false;
   }
}
