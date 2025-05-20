package com.data.demo61.service;

import com.data.demo61.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CertificateServiceImpl implements CertificateService{
    @Autowired
    private CertificateRepository certificateRepository;
}
