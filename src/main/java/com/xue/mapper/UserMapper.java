package com.xue.mapper;

import com.xue.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int add(User user);

    int delete(@Param("id") int id);

    int update(User user);

    User get(@Param("id") int id);

    List<User> list();
}
