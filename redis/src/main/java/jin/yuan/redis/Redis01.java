package jin.yuan.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

// 测试 与 redis 的连接
public class Redis01 {
   public static void main(String[] args) {
      // 创建 jredis 对象
      Jedis jedis = new Jedis("120.78.162.172",6379);
      // 选择一个库，默认使用的是 0 号库
      jedis.select(0);

      //获取 reids 中的所有 key 信息
      Set<String> keys = jedis.keys("*");
      keys.forEach(key -> System.out.println(key));

      //操作库相关的
      jedis.flushDB();
      jedis.flushAll();

      //释放资源
      jedis.close();
   }
}
