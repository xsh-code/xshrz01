package study.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.pojo.Role;
import study.pojo.User;
import study.service.MenuService;
import study.service.RoleService;
import study.service.UserService;
import study.utils.R;
import study.vo.MenuVo;
import study.vo.RoleVo;
import study.vo.UserVo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ---  2019/10/29 --- 14:51
 * --天神佑我：写代码，无BUG
 */
@Controller
@RequestMapping("/sys")
@CrossOrigin("http://localhost:8082")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;
    @RequestMapping("/login")
    @ResponseBody
    public R login(@RequestBody User user) {
        System.out.println(user);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        SecurityUtils.getSubject().login(token);
        return R.ok();
    }

    @RequestMapping("/user/info")
    @ResponseBody
    public R userInfo() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
//        System.out.println("user====" + user);
//        System.out.println("访问了user/info" + username);
        return R.ok().put("user", user);
    }

    @RequestMapping("/menu/user")
    @ResponseBody
    public R menuuser() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        Set<String> perms = menuService.queryAllMenuByUsername(userName);

        List<MenuVo> menuList = menuService.queryAllMenByUsernameAndParentid(userName, 0);
        for (MenuVo menuVo : menuList) {
            List<MenuVo> menuVos = menuService.queryAllMenByUsernameAndParentid(userName, menuVo.getMenuId());
            menuVo.setList(menuVos);
        }
        /*System.out.println(menuList);*/
        HashSet<String> hashSet = new HashSet<>();
        for (String perm : perms) {
            if (perm != null && perm != "") {
                if (perm.contains(",")) {
                    String[] split = perm.split(",");
                    for (String s : split) {
                        hashSet.add(s);
                    }
                } else {

                    hashSet.add(perm);
                }
            }

        }
//     hashSet.forEach(n-> System.out.println("perms========>"+n));
        return R.ok().put("menuList", menuList).put("permissions", hashSet);
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public R userList(String order, Integer limit, Integer offset) {
        List<User> users = userService.queryUserBylimit(order, limit, offset);
        Integer count = userService.getCount();

        return R.ok().put("total", count).put("rows", users);
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public R userUpdate(@RequestBody UserVo userVo){
        userService.updateUserByUserid(userVo);
        roleService.deleteRolesByUserid(userVo.getUserId());
        for (Integer role : userVo.getRoles()) {
            roleService.addRoles(userVo.getUserId(),role);
        }
        return R.ok();
    }

    @RequestMapping("/roles")
    @ResponseBody
    public R sysRoles(){
        List<Role> roles = roleService.queryAllRoles();
        return R.ok().put("roles", roles);
    }
    @RequestMapping("/user/save")
    @ResponseBody
    public R userSave(@RequestBody UserVo userVo){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUsername(username);
        userVo.setCreateUserId(user.getUserId());
        Integer integer = userService.insertUser(userVo);
        Integer userId = userVo.getUserId();
        Integer[] roles = userVo.getRoles();
        for (int role : roles) {
            roleService.addRoles(userId, role);
        }
        System.out.println(userVo);
        return R.ok();
    }
    @GetMapping("/user/info/{userId}")
    @ResponseBody
    public R getuserInfoById(@PathVariable("userId") Integer userId){
        UserVo userVo = userService.queryUserByUserid(userId);
        List<Integer> list = roleService.queryAllRoleidByUserId(userId);
        Integer[] role = new Integer[list.size()];
        list.toArray(role);
        userVo.setRoles(role);
        return R.ok().put("user",userVo);
    }

    @ResponseBody
    @RequestMapping("/user/del/{userId}")
    public R deleteUser(@PathVariable Integer userId){
        userService.deleteUserByUserid(userId);
        roleService.deleteRolesByUserid(userId);
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/role/list")
    public R rolelist(String order,Integer limit,Integer offset){
        List<Role> roles = roleService.queryAllrolesByxxx(order, limit, offset);
        Integer count = roleService.getCount();
        return R.ok().put("rows", roles).put("total", count);
    }

    @ResponseBody
    @RequestMapping("/menu/select")
    public R menuSelect(){
        List<MenuVo> menuVos = menuService.queryAllMenu();
        return R.ok().put("menuList",menuVos);
    }
     @ResponseBody
    @RequestMapping("/role/save")
    public R roleSave(@RequestBody RoleVo roleVo){
         String username = (String) SecurityUtils.getSubject().getPrincipal();
         User user = userService.queryUserByUsername(username);
         Integer userId = user.getUserId();
         roleVo.setCreateUserId(userId);
         roleVo.setCreateTime(new Date());
         roleService.insertRole(roleVo);
         System.out.println("=======================");
         Integer[] menus = roleVo.getMenus();
         for (Integer menu : menus) {
             roleService.insertRoleMenu(roleVo.getRoleId(),menu);
         }
         return R.ok();
     }
    @ResponseBody
    @RequestMapping("/role/info/{roleId}")
    public R  roleInfoRoleId(@PathVariable Integer roleId){
        RoleVo roleVo = roleService.queryRoleByRoleId(roleId);
        List<Integer> list = menuService.queryAllMenuByRoleId(roleId);
        Integer[] array = list.toArray(new Integer[0]);
        roleVo.setMenus(array);
        return R.ok().put("role",roleVo);
    }
    @ResponseBody
    @RequestMapping("/role/update")
    public R roleUpdate(@RequestBody RoleVo roleVo){
        roleService.updateRole(roleVo);
        menuService.deleteAllmenuByRoleId(roleVo.getRoleId());
        Integer[] menus = roleVo.getMenus();
        for (Integer menu : menus) {
            roleService.insertRoleMenu(roleVo.getRoleId(), menu);
        }
        return R.ok();
    }

    @CrossOrigin("http://localhost:8082")
    @ResponseBody
    @DeleteMapping("/roles/{roleId}")
    public R roleDelete(@PathVariable Integer roleId){
        roleService.deleteRoleByRoleId(roleId);
        menuService.deleteAllmenuByRoleId(roleId);
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/menu/list")
    public R menuList(String order,Integer limit,Integer offset){
        List<MenuVo> menuVos = menuService.queryAllMenuByxxx(order, limit, offset);
        Integer count = menuService.getCount();
        return R.ok().put("total", count).put("rows", menuVos);
    }




}
