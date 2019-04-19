package com.chen.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 设置工具包
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;//单例
    //初始化SqlSessionFactory对象
    static {
        try {
            //使用MyBatis提供的Resources类加载MyBatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建SqlSessionFactory工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession(boolean flag){
        return sqlSessionFactory.openSession(flag);
    }
    //关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }

}
