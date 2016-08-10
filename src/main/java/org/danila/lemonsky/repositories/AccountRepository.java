package org.danila.lemonsky.repositories;

import org.danila.lemonsky.models.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danila on 10.08.2016.
 */

@Repository
public interface AccountRepository {

    List<Account> getAllFeeds();
    Account getAccountById(Long id);
    void saveAccount(Account account);
}
