package cn.edu.guet.bll;

import cn.edu.guet.bean.Users;

import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-26 15:47
 * @Version 1.0
 */
public interface IAccountService {
    List<Users> getAllUser();
    void deleteUser(String userId);
}
