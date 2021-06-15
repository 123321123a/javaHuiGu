package jin.yuan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
   //基本类型直接使用
   // <property name="lastName" value="张三"></property> 会自动进行类型转换
   private String lastName;
   private Integer age;
   private String gender;
   private Car car;
   private List<Book> books;
   private Map<String,Object> maps;
   private Properties properties;
}
