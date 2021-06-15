package jin.yuan.网络编程.多用户通讯系统.客户端.service;

import jin.yuan.网络编程.多用户通讯系统.共有的.Message;
import jin.yuan.网络编程.多用户通讯系统.共有的.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;

//该对象和服务端提供和消息相关的方法
public class MessageClient {
   /**
    * @param content：内容
    * @param senderId：发送者
    * @param getterId：接受用户的id
    */
   public void sendMessageToOne(String content,String senderId,String getterId){
      //构建 Message
      Message message = new Message();
      message.setSender(senderId);
      message.setGetter(getterId);
      message.setMesType(MessageType.MESSAGE_COMM_MES);
      message.setContent(content);
      message.setSendTime(new java.util.Date().toString());
      System.out.println(senderId + " 对 " + getterId + " 说 " + content);

      try {
         ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
         oos.writeObject(message);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
