package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
//    测试
    @Test
    public void test(){
//        第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        第二步：执行Sql语句
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList){
            System.out.println(user);
        }
//        关闭sqlSession
        sqlSession.close();
    }
}
