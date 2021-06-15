package jin.yuan.redis;

import com.sun.crypto.provider.JceKeyStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Redis02 {

   private Jedis jedis;

   @Before
   public void before() {
      this.jedis = new Jedis("120.78.162.172", 6379);
   }

   @After
   public void after() {
      this.jedis.close();
   }

   // 测试 key 相关
   @Test
   public void testKeys(){
      //删除多个 key
      jedis.del("name","age");

      //判断 key 是否存在
      Boolean name = jedis.exists("name");

      // 设置一个 key 的超时时间
      long age = jedis.expire("age",100); // 返回值 0 和 1 代表是否设置成功
   }
}

















