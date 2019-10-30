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
}
