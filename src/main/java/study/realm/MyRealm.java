package study.realm;

import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import study.pojo.User;
import study.service.MenuService;
import study.service.RoleService;
import study.service.UserService;

import java.util.Set;

/**
 * ---  2019/10/29 --- 11:03
 * --天神佑我：写代码，无BUG
 */
@Setter
public class MyRealm extends AuthorizingRealm {
    private UserService userService;
    private RoleService roleService;
    private MenuService menuService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = roleService.queryAllRoleNameByUSername(username);
        Set<String> menus = menuService.queryAllMenuByUsername(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
        authorizationInfo.setStringPermissions(menus);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.queryUserByUsername(username);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes("666"), this.getName());
        return authenticationInfo;
    }
}
