package cn.edu.guet.controller;

import cn.edu.guet.bean.Users;
import cn.edu.guet.bll.IAccountService;
import cn.edu.guet.bll.impl.AccountServiceImpl;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;

import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-26 15:25
 * @Version 1.0
 */
@Controller
public class AccountController {

    IAccountService accountService=new AccountServiceImpl();
    @RequestMapping("zhgl.do")
    public String zhgl(){
        return "forward:zhgl.jsp";
    }
    /**
     * ·µ»ØJSON¸ñÊ½
     * @return
     */
    @RequestMapping("user/getAllUser.do")
    public List<Users> getAllUser(){
        return accountService.getAllUser();
    }
    @RequestMapping("user/deleteUser.do")
    public void deleteUser(String userId){
        accountService.deleteUser(userId);
    }
}