package com.xue.mapper;

import com.xue.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyMapper {
    int deleteByID(@Param("id") int id);

    int insert(Property property);

    Property selectByID(@Param("id") int id);

    int updateProperty(Property property);

    List<Property> list(@Param("cid") int cid);
}
