package com.example.crud.mapper;

import com.example.crud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liangzhihao
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-08-09 21:36:44
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




