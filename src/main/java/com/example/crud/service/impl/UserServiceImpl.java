package com.example.crud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import com.example.crud.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liangzhihao
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-08-09 21:36:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean addOne(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean deleteOneByAcc(String account) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("acc", account);
        return userMapper.delete(queryWrapper) > 0;
    }

    @Override
    public boolean updateOne(User user) {
        int id = getOneByAcc(user.getAcc()).getId();
        user.setId(id);
        return userMapper.updateById(user) > 0;
    }

    @Override
    public User getOneByAcc(String account) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("acc", account);
        return super.getOne(queryWrapper);
    }
}




