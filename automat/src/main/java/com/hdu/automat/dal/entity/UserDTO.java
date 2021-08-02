package com.hdu.automat.dal.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
/**
 * (User)实体类
 *
 * @author xjm
 * @since 2021-07-30 17:05:12
 */
@Setter
@Getter
public class UserDTO  {
    
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户姓名
    */
    private String userName;
    /**
    * 密码
    */
    private String password;
    /**
    * 创建时间
    */
    private Date createTime;


}