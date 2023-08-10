package com.example.crud.controller;

import com.example.crud.common.BaseResponse;
import com.example.crud.common.ResultUtils;
import com.example.crud.entity.User;
import com.example.crud.exception.BusinessException;
import com.example.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.crud.common.ErrorCode.NULL_ERROR;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public BaseResponse<String> hello() {
        return ResultUtils.success("hello");
    }

    @PostMapping("/add")
    public BaseResponse<String> addUser(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getAcc(), user.getPwd()))
            throw new BusinessException(NULL_ERROR);
        log.info("UserController addUser: " + user);
        if (userService.addOne(user)) {
            return ResultUtils.success("Add user successfully");
        } else {
            return ResultUtils.success("Failed to add user");
        }
    }

    @GetMapping("/delete")
    public BaseResponse<String> deleteUser(@RequestParam String account) {
        if (StringUtils.isAnyBlank(account))
            throw new BusinessException(NULL_ERROR);
        log.info("UserController deleteUser: " + account);
        if (userService.deleteOneByAcc(account)) {
            return ResultUtils.success("Delete user successfully");
        } else {
            return ResultUtils.success("Delete user successfully");
        }
    }

    @PostMapping("/update")
    public BaseResponse<String> updateUser(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getAcc(), user.getPwd()))
            throw new BusinessException(NULL_ERROR);
        log.info("UserController updateUser: " + user);
        if (userService.updateOne(user)) {
            return ResultUtils.success("Update user successfully");
        } else {
            return ResultUtils.success("Update user successfully");
        }
    }

    @GetMapping("/get")
    public BaseResponse<User> getUserByAcc(@RequestParam String account) {
        if (StringUtils.isAnyBlank(account))
            throw new BusinessException(NULL_ERROR);
        log.info("UserController getUserByAcc: " + account);
        return ResultUtils.success(userService.getOneByAcc(account));
    }

}
