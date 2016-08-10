package org.danila.lemonsky.repositories;

import org.danila.lemonsky.models.entities.Account;
import org.danila.lemonsky.models.entities.Comment;
import org.danila.lemonsky.models.entities.Feed;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danila on 10.08.2016.
 */

@Repository
public interface CommentRepository {

    List<Comment> getAllComments();
    List<Comment> getCommentsByFeed(Feed feed);
    Comment getCommentById(Long id);
    void saveFeed(Comment comment);
    List<Comment> getByAccount(Account account);
}
