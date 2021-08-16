package com.hdu.automat.api.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Setter
@Getter
@Component
public class HttpResult<T> implements Serializable {

    public static final Integer SUCCESS = 200;

    public static final Integer FAIL = 500;

    private static final long serialVersionUID = -5323271072384263570L;

    private Integer code;

    private String msg;

    private Integer pageSize;

    private Integer pageNum;

    private Integer pages;

    private Long total;

    private Integer curPage;

    private T data;

    public HttpResult<T> success(T data) {
        this.data = data;
        this.code = SUCCESS;
        return this;
    }

    public HttpResult<T> pageInfo(Integer pageSize, Integer pageNum, Integer curPage, Long total, Integer pages) {
        this.pageNum = pageNum;
        this.curPage = curPage;
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;

        return this;
    }

    public HttpResult<T> fail(String msg) {
        this.msg = msg;
        this.code = FAIL;
        return this;
    }
}
