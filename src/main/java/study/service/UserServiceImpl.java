package study.service;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mapper.UserMapper;
import study.pojo.User;
import study.vo.UserVo;

import java.util.List;

/**
 * ---  2019/10/29 --- 14:26
 * --天神佑我：写代码，无BUG
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public UserVo queryUserByUserid(Integer userid) {
        return userMapper.queryUserByUserid(userid);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public Integer insertUser(UserVo userVo) {
        String password = userVo.getPassword();
        String s = new Sha256Hash(password, "666", 10000).toBase64();
        userVo.setPassword(s);
        return userMapper.insertUser(userVo);
    }

    @Override
    public List<User> queryUserBylimit(String sort, Integer limit, Integer offset) {
        return userMapper.queryUserBylimit(sort, limit, offset);
    }

    @Override
    public Integer getCount() {
        return userMapper.getCount();
    }

    @Override
    public void updateUserByUserid(UserVo userVo) {
        userMapper.updateUserByUserid(userVo);
    }

    @Override
    public void deleteUserByUserid(Integer userid) {
        deleteUserByUserid(userid);
    }
}
