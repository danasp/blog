package org.yab.lemonsky.repository;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.yab.lemonsky.models.entities.Account;

import java.util.Optional;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */
public interface AuthRepository {
    boolean yabSignIn(String username, String password);

    Optional<Account> getByUserName(String username);

    Optional<Roles> getUserRole(String username);
}
