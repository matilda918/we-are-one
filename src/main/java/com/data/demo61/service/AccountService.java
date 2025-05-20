package com.data.demo61.service;

import com.data.demo61.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AccountService extends UserDetailsService {
    Account findByUserNameAndPassword(String userName, String password);
    Optional<Account> findByAccountId(Integer accountId);

}
