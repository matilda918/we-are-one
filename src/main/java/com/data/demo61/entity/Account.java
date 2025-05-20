package com.data.demo61.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Data

public class Account {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int accountId;
    private String role;
    @Column(unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private Date createDate;
    private Date updateDate;
    private Date birthDay;
    private String address;


    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificate> certificates;

    public Account() {
    }
    public Account(int accountId, String role, String userName, String password, String email,Date createDate,Date updateDate,Date birthDay,String address) {
        this.accountId = accountId;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createDate=createDate;
        this.updateDate=updateDate;
        this.birthDay=birthDay;
        this.address=address;
    }
}
