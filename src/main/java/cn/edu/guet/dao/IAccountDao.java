package cn.edu.guet.dao;

import cn.edu.guet.bean.Users;

import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-26 15:41
 * @Version 1.0
 */
public interface IAccountDao {
    List<Users> getAllUser();
    void deleteUser(String userId);
}
