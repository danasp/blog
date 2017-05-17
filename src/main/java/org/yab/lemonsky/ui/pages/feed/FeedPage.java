package org.yab.lemonsky.ui.pages.feed;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Comment;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.ui.components.panel.AddCommentPanel;
import org.yab.lemonsky.ui.pages.BasePage;
import org.yab.lemonsky.ui.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.ui.security.RoleChecker;

import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 23.10.2016
 */
@MountPath("feed")
public class FeedPage extends BasePage {

    private Feed feed;

    public FeedPage(Feed feed) {
        this.feed = feedRepository.initComments(feed);
        init();
    }

    private void init() {
        add(new Link<Feed>("editFeed") {
            @Override
            public void onClick() {
                setResponsePage(new AddFeedPage(feed));
            }
        }.setVisible(RoleChecker.isAdmin(roles)));

        add(new Label("title", new PropertyModel<>(feed, "title")));
        add(new Label("author", new PropertyModel<>(feed, "author.username")));
        add(new MultiLineLabel("content", new PropertyModel<>(feed, "feedText")));
        List<Comment> commentsList = feed.getComments();
    }
}
