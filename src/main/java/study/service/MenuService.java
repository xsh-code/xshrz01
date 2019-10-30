package study.service;

import org.apache.ibatis.annotations.Param;
import study.vo.MenuVo;

import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 14:31
 * --天神佑我：写代码，无BUG
 */
public interface MenuService {
    Set<String> queryAllMenuByUsername(@Param("username") String username);

    List<MenuVo> queryAllMenByUsernameAndParentid(@Param("userName") String userName, @Param("parentId") Integer parentId);

}
