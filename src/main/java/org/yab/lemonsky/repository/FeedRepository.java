package org.yab.lemonsky.repository;

import org.yab.lemonsky.models.entities.Feed;

import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */
public interface FeedRepository {
    List<Feed> getAllFeeds();
    Feed getFeedById(Long id);
    void saveFeed(Feed feed);
    Feed initComments(Feed feed);
}
