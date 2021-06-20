package com.hdu.automat.api.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LoginResponse implements Serializable {

    // 用户Id
    private String userId;

    // 用户名称
    private String userName;

    // 登录token
    private String token;

}
