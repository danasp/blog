package org.yab.lemonsky.wicket.pages.feed;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.yab.lemonsky.models.entities.Comment;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.components.panel.AddCommentPanel;
import org.yab.lemonsky.wicket.pages.BasePage;

import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 23.10.2016
 */
public class FeedPage extends BasePage {

    private Feed feed;

    public FeedPage(Feed feed) {
        this.feed = feedRepository.initComments(feed);
        init();
    }

    private void init() {
        add(new Label("title", new PropertyModel<>(feed, "title")));
        add(new Label("author", new PropertyModel<>(feed, "author.username")));
        add(new MultiLineLabel("content", new PropertyModel<>(feed, "feedText")));
        List<Comment> commentsList = feed.getComments();

        add(new Label("numberOfComment", commentsList == null ? 0 : commentsList.size()));

        add(new AddCommentPanel("addCommentPanel", feed)
                .setVisible(isLogined));

        ListView<Comment> comments = new ListView<Comment>("comments", commentsList) {
            @Override
            protected void populateItem(ListItem<Comment> item) {
                Comment comment = item.getModelObject();
                item.add(new Label("commentAuthor", new PropertyModel<>(comment, "author.username")));
                item.add(new MultiLineLabel("commentText", new PropertyModel<>(comment, "text")));
                item.add(new Label("commentDate", new PropertyModel<>(comment, "date")));
            }
        };

        add(comments);
    }
}
