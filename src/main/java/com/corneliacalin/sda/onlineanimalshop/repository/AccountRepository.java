package com.corneliacalin.sda.onlineanimalshop.repository;

import com.corneliacalin.sda.onlineanimalshop.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmail(String email);

}
