package com.chen.mapper;

import com.chen.po.Specil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecilMapper {
    Specil findSpecilById(int id);

    List<Specil> findAll();

    List<Specil> findAllSplit(Map<String,Object> map);

    List<Specil> findAllSplit2(@Param("start") int start, @Param("pageSize")int pageSize);

    List<Specil> findAllSplit3(Map<String,Object> map);
//if元素
    List<Specil> findAllSplit4(Map<String,Object> map);
//choose元素
    List<Specil> findSpecilByNameTestchoose(Map<String,Object> map);
//where元素
    List<Specil> findSpecilByNameAndTestWhere(Map<String,Object> map);
//foreach元素
    List<Specil> findSpecilByNameAndTestforeach(int ids);
//Set元素
    List<Specil> findSpecilByNameAndTestSet(Map<String,Object> map);
}
