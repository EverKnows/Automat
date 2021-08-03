package com.hdu.automat.biz.repository;

import com.hdu.automat.biz.convert.UserConvert;
import com.hdu.automat.biz.entity.UserEntity;
import com.hdu.automat.biz.util.AssertUtil;
import com.hdu.automat.dal.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
@Component
public class UserService {

    @Resource
    private UserMapper userMapper;

    public UserEntity loadByUserId(Long userId) {
        AssertUtil.isTrue(userId != null, "用户Id为空");

        return UserConvert.convert2Entity(userMapper.loadById(1L));

    }
}