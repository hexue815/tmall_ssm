package com.xue.service.impl;

import com.xue.mapper.PropertyValueMapper;
import com.xue.pojo.Product;
import com.xue.pojo.Property;
import com.xue.pojo.PropertyValue;
import com.xue.service.PropertyService;
import com.xue.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    private PropertyValueMapper propertyValueMapper;
    @Autowired
    private PropertyService propertyService;

    @Override
    public void init(Product p) {
        //根据产品分类获取这个分类的所有属性集合
        List<Property> properties = propertyService.list(p.getCid());
        HashMap<String, Object> map = new HashMap<>();;

        for (Property property :
                properties) {
            map.put("pid", p.getId());
            map.put("ptid", property.getId());
            PropertyValue pv = get(map);
            if (null == pv) {
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(property.getId());
                propertyValueMapper.insert(pv);
            }

        }
    }

    @Override
    public int update(PropertyValue propertyValue) {
        return propertyValueMapper.update(propertyValue);
    }

    @Override
    public PropertyValue get(Map<String, Object> map) {
        return propertyValueMapper.get(map);
    }

    @Override
    public List<PropertyValue> getPropertyValues(int pid) {
        List<PropertyValue> pvs = propertyValueMapper.getPropertyValues(pid);
        for (PropertyValue pv :
                pvs) {
            Property property = propertyService.selectByID(pv.getPtid());
            pv.setProperty(property);
        }
        return pvs;
    }

    @Override
    public int insert(PropertyValue propertyValue) {
        return propertyValueMapper.insert(propertyValue);
    }
}


























