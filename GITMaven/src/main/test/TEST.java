import com.github.Duankan.base.BaseTest;
import com.github.Duankan.dao.UsersPoMapper;
import com.github.Duankan.dao.rolePoMapper;
import com.github.Duankan.po.UsersPo;
import com.github.Duankan.po.rolePo;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

public class TEST extends BaseTest{

    @Resource
    UsersPoMapper usersPoMapper;
    @Resource
    rolePoMapper rolePoMapper;
    private Jedis jedis;
    @Test
    public void test(){
        System.out.println("my first git");
    }

    //测试Mapper能不能正常查询数据库
    @Test
    public void test2(){
//        UsersPo usersPo = usersPoMapper.getUserByUserName("java");
//        System.out.println(usersPo.getUsername()+"=="+usersPo.getPassword());
        List<rolePo> rolePo =rolePoMapper.getRolesByUserid(1);
        System.out.println(rolePo.get(0).getRolename());
    }

    //测试redis链接
    @Before
    public void test3(){
        //连接本地的 Redis 服务
        jedis = new Jedis("127.0.0.1",6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
//         增加一个Key检测是否连接成功
//         jedis.set("foo", "bar");
//         String value = jedis.get("foo");
//         System.out.println("foo-->"+value);
    }
    //jedis存储字符串
    @Test
    public void jedisString(){
        // -----添加数据----------
        jedis.set("name", "qingqing");// 向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));// 执行结果：xinxin

        jedis.append("name", " is my lover"); // 拼接 。
        // 如果用redis命令输入key对应的值是不能有空格的哦
        System.out.println(jedis.get("name"));

        jedis.del("name"); // 删除某个键
        System.out.println(jedis.get("name"));
        // 设置多个键值对
        jedis.mset("name", "qingqing", "age", "23", "qq", "476777XXX");
        jedis.incr("age"); // 进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-"
                + jedis.get("qq"));

        jedis.set("china", "这是个中文值");
        System.out.println(jedis.get("china"));
        jedis.close();
    }
}
