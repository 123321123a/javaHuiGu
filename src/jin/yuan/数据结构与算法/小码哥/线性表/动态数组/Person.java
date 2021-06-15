package jin.yuan.数据结构与算法.小码哥.线性表.动态数组;

import java.util.Objects;

public class Person {
   private int age;
   private String name;

   public Person(int age, String name) {
      this.age = age;
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return age == person.age && Objects.equals(name, person.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(age, name);
   }

   @Override
   public String toString() {
      return "Person{" +
              "age=" + age +
              ", name='" + name + '\'' +
              '}';
   }
}
