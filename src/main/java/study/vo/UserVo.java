package study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ---  2019/10/29 --- 21:32
 * --天神佑我：写代码，无BUG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String sex;
    private String status;
    private Integer[] roles;
}
