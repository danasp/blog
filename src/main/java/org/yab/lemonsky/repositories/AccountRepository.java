package org.yab.lemonsky.repositories;

import org.springframework.stereotype.Repository;
import org.yab.lemonsky.models.entities.Account;

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
