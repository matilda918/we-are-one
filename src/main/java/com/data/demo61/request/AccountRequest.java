package com.data.demo61.request;

import lombok.Data;

import java.util.Date;

@Data

public class AccountRequest {
    private String role;
    private String userName;
    private String password;
    private String email;
    private Date createDate;
    private Date updateDate;
    private Date birthDay;
    private String address;
}
