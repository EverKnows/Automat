package com.hdu.automat;

import com.alibaba.fastjson.JSON;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.hdu.automat")
@MapperScan("com.hdu.automat.dal.mapper")
public class AutomatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AutomatApplication.class, args);

    }


}