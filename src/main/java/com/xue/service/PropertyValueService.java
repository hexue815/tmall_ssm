package com.xue.service;

import com.xue.pojo.Product;
import com.xue.pojo.PropertyValue;

import java.util.List;
import java.util.Map;

public interface PropertyValueService {
    void init(Product product);

    int update(PropertyValue propertyValue);

    PropertyValue get(Map<String, Object> map);

    List<PropertyValue> getPropertyValues(int pid);

    int insert(PropertyValue propertyValue);
}
