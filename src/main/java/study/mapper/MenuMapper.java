package study.mapper;

import org.apache.ibatis.annotations.Param;
import study.vo.MenuVo;

import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 12:43
 * --天神佑我：写代码，无BUG
 */
public interface MenuMapper {
    Set<String> queryAllMenuByUsername(@Param("userName") String userName);

    List<MenuVo> queryAllMenByUsernameAndParentid(@Param("userName") String userName, @Param("parentId") Integer parentId);


}
