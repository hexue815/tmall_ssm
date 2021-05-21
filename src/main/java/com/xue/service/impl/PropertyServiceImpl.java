package com.xue.service.impl;

import com.xue.mapper.PropertyMapper;
import com.xue.pojo.Property;
import com.xue.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    @Qualifier("propertyMapper")
    private PropertyMapper propertyMapper;
    @Override
    public int deleteByID(int id) {
        return propertyMapper.deleteByID(id);
    }

    @Override
    public int insert(Property property) {
        return propertyMapper.insert(property);
    }

    @Override
    public Property selectByID(int id) {
        return propertyMapper.selectByID(id);
    }

    @Override
    public int updateProperty(Property property) {
        return propertyMapper.updateProperty(property);
    }

    @Override
    public List<Property> list(int cid) {
        return propertyMapper.list(cid);
    }
}
