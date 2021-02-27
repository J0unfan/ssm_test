package com.itheima.ssm.controller;

import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.service.domian.Role;
import com.itheima.ssm.service.domian.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author Ljunfan
 * @description
 * @date 2021/2/26 11:20
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * findAll
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> all = userService.findAll();
        mv.addObject("userList", all);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") String userId) {
        ModelAndView mv = new ModelAndView();

        UserInfo byId = userService.findById(userId);
        mv.addObject("user", byId);
        mv.setViewName("user-show");

        return mv;
    }

    /**
     * 查询用户以及用户可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") String userId) {
        ModelAndView mv = new ModelAndView();
        // 1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        // 2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");

        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId") String userId, @RequestParam("ids") List<String> roles) {
        userService.addRoleToUser(userId, roles);

        return "redirect: findAll.do";
    }
}
