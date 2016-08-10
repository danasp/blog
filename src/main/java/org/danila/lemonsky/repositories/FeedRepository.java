package org.danila.lemonsky.repositories;

import org.danila.lemonsky.models.entities.Feed;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danila on 10.08.2016.
 */

@Repository
public interface FeedRepository {

    List<Feed> getAllAccounts();
    Feed getFeedById(Long id);
    void saveFeed(Feed feed);
}
