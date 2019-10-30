package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mapper.RoleMapper;
import study.pojo.Role;
import study.vo.RoleVo;

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

    @Override
    public List<Role> queryAllrolesByxxx(String order, Integer limit, Integer offset) {
        return roleMapper.queryAllrolesByxxx(order,  limit, offset);
    }

    @Override
    public Integer getCount() {
        return roleMapper.getCount();
    }

    @Override
    public void insertRoleMenu(Integer roleId, Integer menuId) {
        roleMapper.insertRoleMenu(roleId, menuId);
    }

    @Override
    public void insertRole(RoleVo roleVo) {
        roleMapper.insertRole(roleVo);
    }

    @Override
    public RoleVo queryRoleByRoleId(Integer roleId) {
        return roleMapper.queryRoleByRoleId(roleId);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleMapper.updateRole(roleVo);
    }

    @Override
    public void deleteRoleByRoleId(Integer roleId) {
        roleMapper.deleteRoleByRoleId(roleId);
    }
}
