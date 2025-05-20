package com.data.demo61.controller;

import com.data.demo61.Dto.AccountDto;
import com.data.demo61.Dto.CertificateDto;
import com.data.demo61.entity.Account;
import com.data.demo61.entity.Certificate;
import com.data.demo61.repository.CertificateRepository;
import com.data.demo61.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class CertificateController {
    @Autowired
    private CertificateRepository certificateRepository;
    private CertificateService certificateService;

    public CertificateController(CertificateRepository certificateRepository, CertificateService certificateService) {
        this.certificateRepository = certificateRepository;
        this.certificateService = certificateService;
    }

    @GetMapping("certificate")
    public ResponseEntity<?> getCertificate(Pageable pageable) {
        Page<Certificate> certificates = certificateRepository.findAll(pageable);
        List<CertificateDto> certificateDtos = new ArrayList<>();
        certificates.forEach(certificate -> {
            CertificateDto certificateDto = new CertificateDto();
            certificateDto.setId(certificate.getId());
            certificateDto.setCertificateName(certificate.getCertificateName());

            AccountDto accountDto = new AccountDto();
            Account account = certificate.getAccount();
            if (account != null) {
                accountDto.setAccountId(account.getAccountId());
                accountDto.setRole(account.getRole());
                accountDto.setEmail(account.getEmail());
                accountDto.setUserName(account.getUserName());
                accountDto.setPassword(account.getPassword());

            }
            certificateDto.setAccount(accountDto);
            certificateDtos.add(certificateDto);


        });
        Page<CertificateDto> certificateDtoPage = new PageImpl<>(certificateDtos, pageable, certificates.getTotalElements());
        return ResponseEntity.ok(certificateDtoPage);

    }
}
