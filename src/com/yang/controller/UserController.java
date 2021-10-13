package com.yang.controller;

import com.yang.pojo.SmbmsRole;
import com.yang.pojo.SmbmsUser;
import com.yang.service.SmbmsRoleService;
import com.yang.service.UserService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "user")
    UserService userService;

    @Resource(name = "role")
    SmbmsRoleService smbmsRoleService;

    @RequestMapping("/login")//登录
    public String login(String userCode, String userPassword, HttpSession session){
        SmbmsUser login = userService.login(userCode, userPassword);
        if (login!=null){
            session.setAttribute("user",login);
            return "jsp/frame";
        }else {
            return "jsp/error";
        }
    }

    @RequestMapping("/logout")//退出
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/userLimit")
    public String getUserLimit(String queryname,@RequestParam(value = "queryUserRole",required = true,defaultValue = "-1") Integer queryUserRole,
                               @RequestParam(value = "pageIndex",required = true,defaultValue = "1") Integer pageIndex, Model model){
        List<SmbmsRole> all = smbmsRoleService.getAll();
        PageUtil<SmbmsUser> userList=userService.getLimit(queryname,queryUserRole,pageIndex,3);
        model.addAttribute("userList",userList);
        model.addAttribute("roleList",all);
        return "jsp/user/userlist";
    }


    @RequestMapping("/toupdate/{id}/{index}") //去修改  加  查看
    public String toUpdate(@PathVariable("id") Integer id,@PathVariable("index") Integer index,
                           Model model){
        SmbmsUser smbmsUser = userService.toUpdate(id);
        model.addAttribute("user",smbmsUser);
        if (index==1){
            return "jsp/user/userview";
        }else{
            List<SmbmsRole> all = smbmsRoleService.getAll();
            model.addAttribute("roleList",all);
            return "jsp/user/usermodify";
        }
    }

    @RequestMapping("/toadd")
    public String toadd(Model model){
        List<SmbmsRole> all = smbmsRoleService.getAll();
        model.addAttribute("roleList",all);
        return  "jsp/user/useradd";
    }

    @RequestMapping("/chkUserCode")
    @ResponseBody
    public  String ajaschkUserCode(String userCode){
        if (userService.checkCode(userCode)){
            return "exists";
        }
        return "not";
    }
    //新增
    @RequestMapping("/doadd")
    public String doadd(SmbmsUser user){
        int add = userService.add(user);
        if (add>0){
            return "redirect:/user/userLimit";
        }
            return "redirect:/user/toadd";
    }

    @RequestMapping("/doupdate")
    public String doupdate(SmbmsUser user){
        int update = userService.update(user);
        if (update>0){
            return "redirect:/user/userLimit";
        }
        return "redirect:/user/toupdate/"+user.getId()+"/2";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(Integer id){
        int delete = userService.delete(id);
        if (delete>0)
        {
            return "ok";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/pwdCheck")
    @ResponseBody
    public String pwdCheck(String oldpassword,HttpSession session){
         SmbmsUser user = (SmbmsUser)session.getAttribute("user");
            if (user.getUserpassword().equals(oldpassword)){
                 return "true";
             }
            return "false";
    }

    @RequestMapping("/dopwd")
    public String doPwd(@RequestParam("newpassword") String newpassword,HttpSession session){
        SmbmsUser user = (SmbmsUser) session.getAttribute("user");
        user.setUserpassword(newpassword);
        user.setModifyby(user.getId());
        int i=userService.update(user);
        if (i>0){
            return "jsp/pwdmodify";
        }
        return "jsp/user/userlist";
    }
}
