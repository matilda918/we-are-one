package com.data.demo61.service;

import com.data.demo61.entity.Account;
import com.data.demo61.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUserNameAndPassword(String userName, String password) {
        return accountRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Optional<Account> findByAccountId(Integer accountId) {
        return accountRepository.findByAccountId(accountId);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(
                account.getUserName(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
