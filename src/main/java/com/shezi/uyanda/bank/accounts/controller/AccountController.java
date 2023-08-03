package com.shezi.uyanda.bank.accounts.controller;

import com.shezi.uyanda.bank.accounts.handler.AccountHandler;
import com.shezi.uyanda.bank.accounts.model.AccountRequest;
import com.shezi.uyanda.bank.accounts.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts/")
public class AccountController {
    private AccountHandler accountHandler;

    @Autowired
    public AccountController(AccountHandler aAccountHandler){
        this.accountHandler = aAccountHandler;
    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse getAccount(@RequestBody AccountRequest request){
        AccountResponse response = accountHandler.findByCustomerId(request);
        return response;
    }
}
