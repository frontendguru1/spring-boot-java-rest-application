package com.example.JobSpringRestApplication.model;

import java.util.Date;

public class ApiError {
    private Integer errorCode;
    private String errorDesc;
    private Date date;

    public ApiError(Integer errorCode, String errorDesc, Date date) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.date = date;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
