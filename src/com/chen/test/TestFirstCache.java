package com.chen.test;

import com.chen.mapper.SpecilMapper;
import com.chen.po.Specil;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestFirstCache {
    public static void main(String[] args) {
        SqlSession sqlSessionA = MybatisUtils.getSqlSession(false);
        SpecilMapper specilMapper = sqlSessionA.getMapper(SpecilMapper.class);

        Specil specil = specilMapper.findSpecilById(1);
        System.out.println(specil);
        //关闭
        MybatisUtils.closeSqlSession(sqlSessionA);
        //自动 提交后不缓存
//        sqlSessionA.commit();
        //手动清空缓存
//        sqlSessionA.clearCache();
        System.out.println("===========================================================");
        SqlSession sqlSessionB = MybatisUtils.getSqlSession(false);
        SpecilMapper specilMapperB = sqlSessionB.getMapper(SpecilMapper.class);

        Specil specil1 = specilMapperB.findSpecilById(1);
        System.out.println(specil1);
        //关闭
        MybatisUtils.closeSqlSession(sqlSessionB);
    }
}
