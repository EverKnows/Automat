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

    private static final Integer SUCCESS = 200;

    private static final Integer FAIL = 500;
    private static final long serialVersionUID = -5323271072384263570L;

    private Integer code;

    private String msg;

    private Long pageSize;

    private Long pageNum;

    private Long pages;

    private Long total;

    private Long curPage;

    private T data;

    public HttpResult<T> success(T data) {
        this.data = data;
        this.code = SUCCESS;
        return this;
    }

    public HttpResult<T> pageInfo(Long pageSize, Long pageNum, Long curPage, Long total, Long pages) {
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
