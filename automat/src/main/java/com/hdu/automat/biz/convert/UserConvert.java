package com.hdu.automat.biz.convert;

import com.hdu.automat.biz.entity.UserEntity;
import com.hdu.automat.dal.entity.UserDTO;

/**
 * @author jianmiao.xu
 * @date 2021/7/30
 */
public class UserConvert {

    public static UserEntity convert2Entity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }

    public static UserDTO convert2DTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setId(userEntity.getId());

        return userDTO;
    }


}