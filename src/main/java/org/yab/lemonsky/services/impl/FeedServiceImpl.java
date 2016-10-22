package org.yab.lemonsky.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.services.FeedService;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Feed> getAllFeeds() {
        List<Feed> feeds = entityManager.createQuery("FROM Feed").getResultList();
        return feeds == null ? Collections.emptyList() : feeds;
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
}
