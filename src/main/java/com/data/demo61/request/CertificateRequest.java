package com.data.demo61.request;

import lombok.Data;

@Data

public class CertificateRequest {
    private String certificateName;

    public CertificateRequest() {
    }
    public CertificateRequest(String certificateName) {
        this.certificateName = certificateName;
    }

}
