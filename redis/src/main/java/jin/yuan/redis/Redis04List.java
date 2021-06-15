package jin.yuan.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Redis04List {

   private Jedis jedis;

   @Before
   public void before() {
      this.jedis = new Jedis("120.78.162.172", 6379);
   }

   @After
   public void after() {
      this.jedis.close();
   }

   // 测试 List 相关
   @Test
   public void testKeys(){
      jedis.lpush("address","北京","上海","深圳");
      System.out.println(jedis.llen("address"));
      System.out.println(jedis.lrange("address", 0, -1));
   }
}

















