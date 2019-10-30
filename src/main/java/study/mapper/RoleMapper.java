package study.mapper;

import org.apache.ibatis.annotations.Param;
import study.pojo.Role;
import study.vo.RoleVo;

import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 11:34
 * --天神佑我：写代码，无BUG
 */
public interface RoleMapper {
    Set<String> queryAllRoleNameByUSername(@Param("username") String username);

    List<Role> queryAllRoles();

    void addRoles(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

    List<Integer> queryAllRoleidByUserId(@Param("userid") Integer userid);

    void deleteRolesByUserid(@Param("userid") Integer userid);

    List<Role> queryAllrolesByxxx(@Param("order") String order, @Param("limit") Integer limit, @Param("offset") Integer offset);

    Integer getCount();

    void insertRoleMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    void insertRole(RoleVo roleVo);

    RoleVo queryRoleByRoleId(@Param("roleId") Integer roleId);

    void updateRole(RoleVo roleVo);

    void deleteRoleByRoleId(@Param("roleId") Integer roleId);
}
