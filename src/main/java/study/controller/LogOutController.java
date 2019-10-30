package study.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.utils.R;

/**
 * ---  2019/10/29 --- 19:47
 * --天神佑我：写代码，无BUG
 */
@Controller
@CrossOrigin("http://localhost:8082")
public class LogOutController {
    @RequestMapping("/logout")
    @ResponseBody
    public R logout(){
        SecurityUtils.getSubject().logout();
        System.out.println("访问了退出");
        return R.ok();
    }
}
