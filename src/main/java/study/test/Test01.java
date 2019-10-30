package study.test;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.mapper.MenuMapper;
import study.mapper.UserMapper;
import study.pojo.User;
import study.service.UserService;
import study.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * ---  2019/10/29 --- 15:10
 * --天神佑我：写代码，无BUG
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
        User user = new User();
        String s = new Sha256Hash("123", "666", 10000).toBase64();
        user.setUsername("xsh");
        user.setPassword(s);
        System.out.println(user);
    }

    @Test
    public void test02(){
        List<MenuVo> voList = menuMapper.queryAllMenByUsernameAndParentid("admin", 0);
        for (MenuVo menuVo : voList) {
            List<MenuVo> voList1 = menuMapper.queryAllMenByUsernameAndParentid("admin", menuVo.getMenuId());
            menuVo.setList(voList1);
        }
        voList.forEach(n -> System.out.println(n));
    }

    @Test
    public void test03(){
        List<User> asc = userMapper.queryUserBylimit("asc", 3, 0);
        asc.forEach(n -> System.out.println(n));
    }
    @Test
    public void test04(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
//        list.toArray()
    }


}
