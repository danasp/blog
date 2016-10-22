package org.yab.lemonsky.services;

import org.yab.lemonsky.models.entities.Feed;

import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */
public interface FeedService {
    List<Feed> getAllFeeds();
    Feed getFeedById(Long id);
    void saveFeed(Feed feed);
}
