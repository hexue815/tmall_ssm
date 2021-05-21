package com.xue.service;

import com.xue.pojo.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyService {
    int deleteByID(int id);

    int insert(Property property);

    Property selectByID(int id);

    int updateProperty(Property property);

    List<Property> list(int cid);
}
