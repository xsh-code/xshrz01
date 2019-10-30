package study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ---  2019/10/29 --- 17:15
 * --天神佑我：写代码，无BUG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
    private Integer menuId;
    private Integer parentId;
    private String name;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private List<MenuVo> list;
}
