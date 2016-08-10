package org.danila.lemonsky.repositories.jpa;

import org.danila.lemonsky.repositories.FeedRepository;

import javax.persistence.EntityManager;

/**
 * Created by Danila on 10.08.2016.
 */
public interface FeedRepositoryJpa extends FeedRepository, EntityManager {
}
