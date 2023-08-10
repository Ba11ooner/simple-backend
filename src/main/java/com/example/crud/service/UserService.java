package com.example.crud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.crud.entity.User;

/**
* @author liangzhihao
* @description 针对表【user】的数据库操作Service
* @createDate 2023-08-09 21:36:44
*/
public interface UserService extends IService<User> {

    User getOneByAcc(String acc);

    boolean addOne(User user);

    boolean updateOne(User user);

    boolean deleteOneByAcc(String account);
}
