package com.data.demo61.repository;

import com.data.demo61.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}

