package com.xue.mapper;

import com.xue.pojo.Property;
import com.xue.pojo.PropertyValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PropertyValueMapper {
    List<PropertyValue> getPropertyValues(@Param("pid") int pid);

    int insert(PropertyValue propertyValue);

    PropertyValue get(Map<String, Object> map);

    int update(PropertyValue propertyValue);
}
