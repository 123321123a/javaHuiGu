package jin.yuan.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Redis03String {

   private Jedis jedis;

   @Before
   public void before() {
      this.jedis = new Jedis("120.78.162.172", 6379);
   }

   @After
   public void after() {
      this.jedis.close();
   }

   // 测试 string 相关
   @Test
   public void testKeys(){
      jedis.set("name","金源");
      System.out.println(jedis.get("name"));
      jedis.set("icc",0+"");
      jedis.incr("icc");
      jedis.incr("icc");
      System.out.println(jedis.get("icc"));
   }
}

















