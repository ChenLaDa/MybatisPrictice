package com.chen.test;

import com.chen.mapper.SpecilMapper;
import com.chen.po.Specil;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIf3 {
    public static void main(String[] args) {
        SqlSession sqlSessionA = MybatisUtils.getSqlSession(false);
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

        SpecilMapper specilMapper = sqlSessionA.getMapper(SpecilMapper.class);
        List<Specil> speciList = specilMapper.findAllSplit3(map);

        for (Specil specil : speciList) {
            System.out.println(specil);
        }

    }
}
