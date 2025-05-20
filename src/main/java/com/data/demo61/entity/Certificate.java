package com.data.demo61.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "certificates")
@Data

public class Certificate {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String certificateName;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="accountId")
    private Account account;

    public Certificate() {
    }
    public Certificate(int id, String certificateName) {
        this.id = id;
        this.certificateName = certificateName;
    }
}
