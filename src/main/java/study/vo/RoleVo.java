package study.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ---  2019/10/30 --- 10:48
 * --天神佑我：写代码，无BUG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo {
    private Integer roleId;
    private String roleName;
    private String remark;
    private Integer createUserId;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private Integer[] menus;

}
