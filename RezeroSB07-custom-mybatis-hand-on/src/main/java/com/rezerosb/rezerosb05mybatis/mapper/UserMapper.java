package com.rezerosb.rezerosb05mybatis.mapper;

import com.rezerosb.rezerosb05mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User findById(Integer id);
}
