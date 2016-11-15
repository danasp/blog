package org.yab.lemonsky.repository;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */
public interface AuthRepository {
    boolean signIn(String username, String password);
}
