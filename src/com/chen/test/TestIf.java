package com.chen.test;

import com.chen.mapper.SpecilMapper;
import com.chen.po.Specil;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIf {
    public static void main(String[] args) {
        SqlSession sqlSessionA = MybatisUtils.getSqlSession(false);
        int pageNum=1;
        int pageSize=5;

        int start=(pageNum-1)*pageSize;

        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("pageSize",pageSize);

        SpecilMapper specilMapper = sqlSessionA.getMapper(SpecilMapper.class);
        List<Specil> speciList = specilMapper.findAllSplit(map);

        for (Specil specil : speciList) {
            System.out.println(specil);
        }

    }
}
