package org.yab.lemonsky.repository.impl;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.repository.AuthRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */
@Repository(value = "authRepository")
public class AuthRepositoryImpl implements AuthRepository {

    @Autowired
    EntityManager entityManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean yabSignIn(String username, String password) {
        Optional<Account> maybeAcc = getByUserName(username);
        if (maybeAcc.isPresent()) {
            String storedPassword = maybeAcc.get().getPassword();
            return passwordEncoder.matches(password, storedPassword);
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Account> getByUserName(String username) {
        List<Account> accounts = entityManager.createQuery("FROM Account as acc where acc.username = :username")
                .setParameter("username", username)
                .getResultList();

        return Optional.ofNullable(accounts.isEmpty() ? null : accounts.get(0));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Roles> getUserRole(String username) {
        List<String> roles = entityManager.createQuery("SELECT acc.roles FROM Account as acc WHERE acc.username = :username")
                .setParameter("username", username)
                .getResultList();

        return Optional.ofNullable(roles.isEmpty() ? null : new Roles(roles.get(0)));
    }
}
