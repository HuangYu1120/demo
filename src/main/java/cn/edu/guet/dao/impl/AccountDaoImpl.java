package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.Users;
import cn.edu.guet.dao.IAccountDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-26 15:42
 * @Version 1.0
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public List<Users> getAllUser() {
        /*
        具体的JDBC代码，连接数据库，获取数据
         */
        List<Users> userList = new ArrayList<Users>();
        String url = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            sql = "SELECT * FROM tb_user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getString("USERID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRealName(rs.getString("REALNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setState(rs.getString("STATE"));
                user.setCreateTime(rs.getTimestamp("CREATETIME"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void deleteUser(String userId) {
        List<Users> userList = new ArrayList<Users>();
        String url = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            conn.setAutoCommit(false);//开启事务
            sql = "DELETE FROM tb_user WHERE userid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.executeUpdate();//执行删除
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}