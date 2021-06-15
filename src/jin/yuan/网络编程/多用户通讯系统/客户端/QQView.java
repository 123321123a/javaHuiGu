package jin.yuan.网络编程.多用户通讯系统.客户端;

import jin.yuan.网络编程.多用户通讯系统.客户端.service.MessageClient;
import jin.yuan.网络编程.多用户通讯系统.客户端.service.UserClientService;

import java.util.Scanner;

// QQ 菜单的登录界面
public class QQView {
   private boolean loop = true;
   private String key = "";//接受用户的键盘输入
   private UserClientService userClientService = new UserClientService(); // 用于登录服务器和注册用户
   private MessageClient messageClient = new MessageClient();

   Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
      new QQView().mainMenu();
   }

   //显示总菜单
   private void mainMenu(){
      while (loop){
         System.out.println("=======欢迎登录网络通讯系统=======");
         System.out.println("\t\t 1.登录系统");
         System.out.println("\t\t 9.退出登录");
         System.out.println("请输入你的选择");
         key = scanner.next();
         switch (key){
            case "1":
               System.out.print("请输入用户号：");
               String userId = scanner.next();
               System.out.print("请输入密 码：");
               String pwd = scanner.next();
               // 封装对象，到服务端去验证是否合法
               if (userClientService.checkUser(userId,pwd)){
                  System.out.println("======欢迎  "+ userId +" 登录成功======");
                  while (loop){
                     System.out.println("=======网络通信二级菜单 ( "+userId+" )=======");
                     System.out.println("\t\t 1.显示在线用户列表");
                     System.out.println("\t\t 2.群发消息");
                     System.out.println("\t\t 3.私聊消息");
                     System.out.println("\t\t 4.发送文件");
                     System.out.println("\t\t 9.退出系统");
                     System.out.println("请输入你的选择");
                     key = scanner.next();
                     switch (key){
                        case "1":
                           userClientService.onLineFriend();
                           break;
                        case "2":
                           System.out.println("群发信息");
                           break;
                        case "3":
                           System.out.println("请输入想聊天的用户号(在线)：");
                           int getterId = scanner.nextInt();
                           System.out.println("请输入想说的话：");
                           String content = scanner.next();
                           messageClient.sendMessageToOne(content,userId, String.valueOf(getterId));
                           break;
                        case "4":
                           System.out.println("发送文件");
                           break;
                        case "9":
                           //调用方法给服务器发送一个退出系统的 Message
                           userClientService.logout();
                           loop = false;
                           break;
                     }
                  }
               }else{
                  System.out.println("登录失败");
               }
               break;
            case "2":
               System.out.println("退出系统");
               loop = false;
               break;
         }
      }
   }
}
























