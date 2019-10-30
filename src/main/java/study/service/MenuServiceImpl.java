package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mapper.MenuMapper;
import study.vo.MenuVo;

import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 14:32
 * --天神佑我：写代码，无BUG
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Set<String> queryAllMenuByUsername(String username) {
        return menuMapper.queryAllMenuByUsername(username);
    }

    @Override
    public List<MenuVo> queryAllMenByUsernameAndParentid(String userName, Integer parentId) {
        return menuMapper.queryAllMenByUsernameAndParentid(userName, parentId);
    }

    @Override
    public List<MenuVo> queryAllMenu() {
        return menuMapper.queryAllMenu();
    }

    @Override
    public List<Integer> queryAllMenuByRoleId(Integer roleId) {
        return menuMapper.queryAllMenuByRoleId(roleId);
    }

    @Override
    public void deleteAllmenuByRoleId(Integer roleId) {
        menuMapper.deleteAllmenuByRoleId(roleId);
    }

    @Override
    public List<MenuVo> queryAllMenuByxxx(String order, Integer limit, Integer offset) {
        return menuMapper.queryAllMenuByxxx(order,limit,offset);
    }

    @Override
    public Integer getCount() {
        return menuMapper.getCount();
    }
}
