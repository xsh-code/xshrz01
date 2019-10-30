package study.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ---  2019/10/29 --- 11:07
 * --天神佑我：写代码，无BUG
 * CREATE TABLE `sys_user` (
 * `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
 * `username` varchar(50) NOT NULL COMMENT '用户名',
 * `password` varchar(100) DEFAULT NULL COMMENT '密码',
 * `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
 * `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
 * `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
 * `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
 * `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 * `dept_id` int(11) DEFAULT NULL COMMENT '部门编号',
 * `sex` varchar(255) DEFAULT NULL COMMENT '性别',
 * `lockdate` datetime DEFAULT NULL,
 * PRIMARY KEY (`user_id`),
 * UNIQUE KEY `username` (`username`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统用户';
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Integer status;
    private Integer createUserId;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private Integer deptId;
    private String sex;
    private Date locaDate;
}
