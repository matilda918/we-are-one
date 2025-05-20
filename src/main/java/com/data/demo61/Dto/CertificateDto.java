package com.data.demo61.Dto;

import lombok.Data;

@Data


public class CertificateDto {
    private int id;
    private String certificateName;

    private AccountDto account;
}
