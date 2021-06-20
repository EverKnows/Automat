package com.hdu.automat.api.request;

import com.hdu.automat.biz.exception.ParamException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Setter
@Getter
public class LoginRequest implements Serializable {

    // 名称
    @NotBlank(message = "用户名称不能为空")
    private String name;

    // 密码
    @NotBlank(message = "用户密码不能为空")
    private String pwd;


}
