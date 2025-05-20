package com.data.demo61.repository;

import com.data.demo61.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserNameAndPassword(String userName, String password);
    Account findByUserName(String userName);
    Optional<Account> findByAccountId(Integer accountId);

}

