package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mapper.RoleMapper;
import study.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 14:30
 * --天神佑我：写代码，无BUG
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Set<String> queryAllRoleNameByUSername(String username) {
        return roleMapper.queryAllRoleNameByUSername(username);
    }

    @Override
    public List<Role> queryAllRoles() {
        return roleMapper.queryAllRoles();
    }

    @Override
    public void addRoles(Integer userid, Integer roleid) {
        roleMapper.addRoles(userid, roleid);
    }

    @Override
    public List<Integer> queryAllRoleidByUserId(Integer userid) {
       return  roleMapper.queryAllRoleidByUserId(userid);
    }

    @Override
    public void deleteRolesByUserid(Integer userid) {
        roleMapper.deleteRolesByUserid(userid);
    }
}
