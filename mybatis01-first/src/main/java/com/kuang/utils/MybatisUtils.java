package com.kuang.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
//SqlSessionFactory --> sqlSession
public class MybatisUtils {
//    提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
//           使用mybatis第一步：获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
//            通过Resources引入配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            通过build构造方法
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
//    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句

//            使用mybatis第二步，获取SqlSession实例
    public static SqlSession getSqlSession(){
         return sqlSessionFactory.openSession();

    }
}
