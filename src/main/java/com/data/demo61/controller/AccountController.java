package com.data.demo61.controller;

import com.data.demo61.entity.Account;
import com.data.demo61.repository.AccountRepository;
import com.data.demo61.request.AccountRequest;
import com.data.demo61.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class AccountController {
    private AccountService accountService;
    private AccountRepository accountRepository;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @PostMapping("account")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {
        if (accountRequest.getRole() == null) {
            return ResponseEntity.badRequest().body("Role không được để trống");
        } else if (accountRequest.getUserName() == null) {
            return ResponseEntity.badRequest().body("UserName không được để trống");
        } else if (accountRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Password không được để trống");
        } else if (accountRequest.getEmail() == null) {
            return ResponseEntity.badRequest().body("Email không được để trống");
        }
        Account account = new Account();
        account.setRole(accountRequest.getRole());
        account.setUserName(accountRequest.getUserName());
        account.setPassword(accountRequest.getPassword());
        account.setEmail(accountRequest.getEmail());
        account.setCreateDate(accountRequest.getCreateDate());
        account.setUpdateDate(accountRequest.getUpdateDate());
        account.setBirthDay(account.getBirthDay());
        account.setAddress(accountRequest.getAddress());

        accountRepository.save(account);
        return ResponseEntity.ok("Tạo tài khoản thành công"
                + " với thông tin: "
                + "Role: " + account.getRole()
                + ", UserName: " + account.getUserName()
                + ", Password: " + account.getPassword()
                + ", Email: " + account.getEmail()
                + "CreateDate: " + account.getCreateDate()
                + "UpdateDate: " + account.getUpdateDate()
                + "BirthDay: " + account.getBirthDay()
                + "Address: " + account.getAddress());


    }

    @GetMapping("account/{userName}/{password}")
    public ResponseEntity<?> getAccount(@PathVariable String userName, @PathVariable String password) {
        Account account = accountRepository.findByUserNameAndPassword(userName, password);
        if (account == null) {
            return new ResponseEntity<>("UserName hoặc password không chính xác", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Đăng nhập thành công", HttpStatus.OK);
        }


    }
    @PutMapping("account/{accountId}")
    public ResponseEntity<?>updateAccount(@PathVariable Integer accountId,@RequestBody AccountRequest accountRequest){
        if(accountRequest.getEmail()==null){
            return ResponseEntity.badRequest().body("Email không được để trống");
        }
        else if(accountRequest.getUserName()==null){
            return ResponseEntity.badRequest().body("UserName không được để trống");
        }
        else if(accountRequest.getCreateDate()==null){
            return ResponseEntity.badRequest().body("Ngày tạo không được để trống");
        }
        else if(accountRequest.getUpdateDate()==null){
            return ResponseEntity.badRequest().body("Ngày Update không được để trống");
        }


        Optional<Account>accountOptional=accountService.findByAccountId(accountId);
        if(accountOptional.isEmpty()){
            return ResponseEntity.badRequest().body("Account không tồn tại id:"+accountId);

        }
        Account account=accountOptional.get();
        account.setUserName(accountRequest.getUserName());
        account.setEmail(accountRequest.getEmail());
        account.setPassword(accountRequest.getPassword());
        account.setCreateDate(accountRequest.getCreateDate());
        account.setUpdateDate(accountRequest.getUpdateDate());
        account.setAddress(accountRequest.getAddress());
        account.setBirthDay(accountRequest.getBirthDay());
        account.setRole(accountRequest.getRole());
        accountRepository.save(account);
        return ResponseEntity.ok("Cập nhập Account thành công!");


    }


}
