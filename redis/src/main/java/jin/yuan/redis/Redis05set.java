package jin.yuan.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Redis05set {

   private Jedis jedis;

   @Before
   public void before() {
      this.jedis = new Jedis("120.78.162.172", 6379);
   }

   @After
   public void after() {
      this.jedis.close();
   }

   // 测试 set 相关
   @Test
   public void testKeys(){
      jedis.sadd("china","广州","武汉","哈尔滨","广州");
      System.out.println(jedis.smembers("china"));
   }
}







