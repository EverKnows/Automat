package com.hdu.automat.api.other;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
@Setter
@Getter
public class LoginAuth implements Serializable {

    private static final long serialVersionUID = -688937780225042783L;

    // 用户token， 对一些需要登录的界面起效
    private String token;
}