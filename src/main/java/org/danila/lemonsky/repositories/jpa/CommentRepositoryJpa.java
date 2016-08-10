package org.danila.lemonsky.repositories.jpa;

import org.danila.lemonsky.repositories.CommentRepository;

import javax.persistence.EntityManager;

/**
 * Created by Danila on 10.08.2016.
 */
public interface CommentRepositoryJpa extends CommentRepository, EntityManager {
}
