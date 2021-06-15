package jin.yuan.网络编程.多用户通讯系统.共有的;

import java.io.Serializable;

// 用户信息
public class User implements Serializable {
   private String userId;
   private String passWord;

   @Override
   public String toString() {
      return "User{" +
              "userId='" + userId + '\'' +
              ", passWord='" + passWord + '\'' +
              '}';
   }

   public User() {
   }

   public User(String userId, String passWord) {
      this.userId = userId;
      this.passWord = passWord;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getPassWord() {
      return passWord;
   }

   public void setPassWord(String passWord) {
      this.passWord = passWord;
   }
}
