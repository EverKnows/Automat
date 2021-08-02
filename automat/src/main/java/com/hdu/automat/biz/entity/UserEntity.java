package com.hdu.automat.biz.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
@Setter
@Getter
public class UserEntity {

    private String userName;

    private String password;

    private Long id;
}