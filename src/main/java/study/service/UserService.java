package study.service;

import org.apache.ibatis.annotations.Param;
import study.pojo.User;
import study.vo.UserVo;

import java.util.List;

/**
 * ---  2019/10/29 --- 14:25
 * --天神佑我：写代码，无BUG
 */
public interface UserService {
    User queryUserByUsername(@Param("username") String username);

    UserVo queryUserByUserid(@Param("userid") Integer userid);


    List<User> queryAllUser();

    Integer insertUser(UserVo userVo);

    List<User> queryUserBylimit(@Param("sort") String sort, @Param("limit") Integer limit, @Param("offset") Integer offset);

    Integer getCount();

    void updateUserByUserid(UserVo userVo);

    void deleteUserByUserid(@Param("userid") Integer userid);



}
