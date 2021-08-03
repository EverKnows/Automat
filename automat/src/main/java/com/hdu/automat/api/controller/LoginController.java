package com.hdu.automat.api.controller;

import com.hdu.automat.api.request.LoginRequest;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.biz.entity.UserEntity;
import com.hdu.automat.biz.repository.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userLogin")
    public HttpResult<UserEntity> login(LoginRequest loginRequest) {
        return new HttpResult<UserEntity>().success(userService.loadByUserId(1L));
    }
}