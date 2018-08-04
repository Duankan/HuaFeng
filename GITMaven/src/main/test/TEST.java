import com.github.Duankan.base.BaseTest;
import com.github.Duankan.dao.UsersPoMapper;
import com.github.Duankan.dao.rolePoMapper;
import com.github.Duankan.po.UsersPo;
import com.github.Duankan.po.rolePo;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class TEST extends BaseTest{

    @Resource
    UsersPoMapper usersPoMapper;
    @Resource
    rolePoMapper rolePoMapper;
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
}
