package jin.yuan.网络编程.多用户通讯系统.共有的;

public interface MessageType{
   // 在接口中定义了一些常量，不同的常量的值，表示不同的消息对象
   String  MESSAGE_LOGIN_SUCCEED = "1";//登录成功
   String  MESSAGE_LOGIN_FAIL = "2";//登录失败
   String MESSAGE_COMM_MES = "3";//普通的信息包
   String MESSAGE_GET_ONLINE_FRIEND = "4";//要求返回在线用户列表
   String MESSAGE_RETURN_ONLINE_FRIEND = "5";//返回在线用户列表
   String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出

}
