package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Users;
import cn.edu.guet.bll.IAccountService;
import cn.edu.guet.dao.IAccountDao;
import cn.edu.guet.dao.impl.AccountDaoImpl;

import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-26 15:47
 * @Version 1.0
 */
public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao=new AccountDaoImpl();
    @Override
    public List<Users> getAllUser() {
        return accountDao.getAllUser();
    }

    @Override
    public void deleteUser(String userId) {
        accountDao.deleteUser(userId);
    }
}
