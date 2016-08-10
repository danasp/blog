package org.danila.lemonsky.repositories.jpa;

import org.danila.lemonsky.repositories.AccountRepository;

import javax.persistence.EntityManager;

/**
 * Created by Danila on 10.08.2016.
 */
public interface AccountRepositoryJpa extends AccountRepository, EntityManager {
}
