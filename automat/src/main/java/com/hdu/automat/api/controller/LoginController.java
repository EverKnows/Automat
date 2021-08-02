package com.hdu.automat.api.controller;

import com.hdu.automat.api.request.LoginRequest;
import com.hdu.automat.api.response.HttpResult;
import com.hdu.automat.biz.entity.UserEntity;
import com.hdu.automat.biz.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
@Controller
public class LoginController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/userLogin")
    @ResponseBody
    public HttpResult<UserEntity> login(LoginRequest loginRequest) {
        return new HttpResult<UserEntity>().success(userRepository.loadByUserId(1L));
    }
}