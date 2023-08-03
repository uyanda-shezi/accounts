package com.shezi.uyanda.bank.accounts.handler;

import com.shezi.uyanda.bank.accounts.dao.AccountsDao;
import com.shezi.uyanda.bank.accounts.model.Accounts;
import com.shezi.uyanda.bank.accounts.model.AccountRequest;
import com.shezi.uyanda.bank.accounts.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(AccountHandler.BEAN_NAME)
public class AccountHandler {

    public static final String BEAN_NAME = "handler.AccountHandler";
    private final AccountsDao accountsDao;

    @Autowired
    public AccountHandler(AccountsDao aAccountsDao){
        this.accountsDao = aAccountsDao;
    }

    public AccountResponse findByCustomerId(AccountRequest request){
        Accounts accounts = accountsDao.findByCustomerId(request.getCustomerId());
        return mapResponse(accounts);
    }

    private AccountResponse mapResponse(Accounts accounts) {
        AccountResponse response = new AccountResponse();
        response.setAccounts(accounts);
        return response;
    }
}
