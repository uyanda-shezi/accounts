package com.shezi.uyanda.bank.accounts.dao;

import com.shezi.uyanda.bank.accounts.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsDao extends CrudRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);
}
