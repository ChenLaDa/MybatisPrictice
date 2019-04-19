package com.chen.test;

import com.chen.mapper.SpecilMapper;
import com.chen.po.Specil;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIf4 {
    public static void main(String[] args) {
        SqlSession sqlSessionA = MybatisUtils.getSqlSession(false);
        int pageNum=1;
        int pageSize=6;

        int start=(pageNum-1)*pageSize;
        String colName="spilinfoname";
        String keyword="技术";
        String coloder="spilinfocode";

        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("pageSize",pageSize);
        map.put("colName",colName);
        map.put("keyword",keyword);
        map.put("coloder",coloder);


        SpecilMapper specilMapper = sqlSessionA.getMapper(SpecilMapper.class);
        List<Specil> speciList = specilMapper.findAllSplit4(map);

        for (Specil specil : speciList) {
            System.out.println(specil);
        }

    }
}
