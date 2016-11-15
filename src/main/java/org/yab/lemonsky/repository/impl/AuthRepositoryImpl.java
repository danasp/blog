package org.yab.lemonsky.repository.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.yab.lemonsky.repository.AuthRepository;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */
@Repository(value = "authRepository")
public class AuthRepositoryImpl implements AuthRepository {
    @Override
    public boolean signIn(String username, String password) {
        //TODO implement!
        return true;
    }
}
