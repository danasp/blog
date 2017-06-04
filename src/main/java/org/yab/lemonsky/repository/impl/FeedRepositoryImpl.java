package org.yab.lemonsky.repository.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.repository.FeedRepository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */

@Repository
public class FeedRepositoryImpl implements FeedRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Feed> getAllFeeds() {
        List<Feed> feeds = entityManager.createQuery("FROM Feed ORDER BY id")
                .getResultList();
        return (feeds == null) ? Collections.emptyList() : feeds;
    }

    @Override
    public List<Feed> getAllVisibleFeeds() {
        List<Feed> feeds = entityManager.createQuery("SELECT f FROM Feed AS f WHERE f.visible = true ORDER BY id")
                .getResultList();
        return (feeds == null) ? Collections.emptyList() : feeds;
    }

    @Override
    public Feed getFeedById(Long id) {
        return entityManager.find(Feed.class, id);
    }

    @Transactional
    @Override
    public void saveFeed(Feed feed) {
        entityManager.merge(feed);
        feed.setAuthor(entityManager.getReference(Account.class, feed.getAuthor().getId()));
        entityManager.flush();
    }

    @Transactional
    @Override
    public Feed initComments(Feed feed) {
        Feed fromDb = getFeedById(feed.getId());
//        Hibernate.initialize(fromDb.getComments());
        return fromDb;
    }
}
