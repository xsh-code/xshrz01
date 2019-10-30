package study.resolve;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import study.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * ---  2019/10/25 --- 8:12
 * --天神佑我：写代码，无BUG
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    private Map<Class, String> evMapping = new HashMap();
    private final String DEFAULT_ERROR = "error";
    public MyExceptionResolver() {
        evMapping.put(UnauthenticatedException.class, "redirect:/login.html");
        evMapping.put(UnauthorizedException.class, "redirect:/login.html");//未授权
        evMapping.put(IncorrectCredentialsException.class,"json:用户名或密码错误······");//不正确的数据凭证异常
        evMapping.put(UnknownAccountException.class, "json:用户名或密码错误······");//未知账户异常
    }

    @Override

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("异常的类型：" + ex.getClass());
        ex.printStackTrace();
        ModelAndView mv  = new ModelAndView();
        String view = evMapping.get(ex.getClass());
        if (view == null) {
            view=DEFAULT_ERROR;
        }
        mv.setViewName(view);
        if (view.startsWith("json:")) {
            writeJson(response,view);
            mv=null;
        }
        return mv;
    }

    private void writeJson(HttpServletResponse response, String view) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = null;
        try {

            writer = response.getWriter();

        } catch (IOException e) {

            e.printStackTrace();
        }
        writer.print(JSON.toJSON(R.error(view.substring(5))));

        writer.close();

    }
}
