package com.data.demo61.Dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class AccountDto {
    private int accountId;
    private String role;
    private String userName;
    private String password;
    private String email;
    private Date createDate;
    private Date updateDate;
    private Date birthDay;
    private String address;

    List<CertificateDto> certificates;

    public AccountDto() {
    }

    public AccountDto(int accountId, String role, String userName, String password, String email, Date createDate, Date updateDate, Date birthDay, String address) {
        this.accountId = accountId;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.birthDay = birthDay;
        this.address = address;
    }
}
