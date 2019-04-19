package com.chen.test;

import com.chen.mapper.SpecilMapper;
import com.chen.po.Specil;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestChoose {
    @Test
    public void TestChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        int pageNum=1;
        int pageSize=5;
        int start=(pageNum-1)*pageSize;
        String colName="spilinfoname";
        String keyword="技术";
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("pageSize",pageSize);
        map.put("colName",colName);
        map.put("keyword",keyword);
        SpecilMapper specilMapper = sqlSession.getMapper(SpecilMapper.class);
        List<Specil> speciList = specilMapper.findSpecilByNameTestchoose(map);
        for (Specil specil : speciList) {
            System.out.println(specil);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void TestWhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        int pageNum=1;
        int pageSize=3;
        int start=(pageNum-1)*pageSize;
        String colName="spilinfoname";
        String keyword="技术";
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("pageSize",pageSize);
        map.put("colName",colName);
        map.put("keyword",keyword);
        SpecilMapper specilMapper = sqlSession.getMapper(SpecilMapper.class);
        List<Specil> speciList = specilMapper.findSpecilByNameAndTestWhere(map);
        for (Specil specil : speciList) {
            System.out.println(specil);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void Testforeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);

        List<Specil> speciList = sqlSession.selectList("findSpecilByNameAndTestforeach",ids);

        for (Specil specil : speciList) {
            System.out.println(specil);
        }
        MybatisUtils.closeSqlSession(sqlSession);
        }
    @Test
    public void TestSet() {
        SqlSession session = MybatisUtils.getSqlSession(true);
        int id=1;
        String colName="spilinfoname";
        String colNameH="陈冰清";

        Map<String,Object> map = new HashMap<>();
        map.put("colName",colName);
        map.put("colNameH",colNameH);
        map.put("id",id);

/*        Specil specil = new Specil();
//        specil.setDid(1);
        specil.setSname("陈冰清");*/

        int rows = session.update("findSpecilByNameAndTestSet",map);
        if (rows>0){
            System.out.println("成功修改一条数据！");
        }else {
            System.out.println("修改失败！");
        }
        MybatisUtils.closeSqlSession(session);
    }
}

