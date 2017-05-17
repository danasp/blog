package org.yab.lemonsky.ui.components.form;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.models.entities.Comment;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.ui.pages.feed.FeedPage;

/**
 * User: Danila Vereshchakov
 * Date: 29.10.2016
 */
public class AddCommentForm extends Form<Comment> {

    @SpringBean
    private FeedRepository feedRepository;

    private Feed feed;
    private Comment comment;

    public AddCommentForm(String id, Feed feed, Comment comment) {
        super(id);
        this.feed = feed;
        this.comment = comment;

        Account account = new Account("commenter", "commenter", "commenter", "commenter", "commenter@test.test");
        account.setId(14L);
        comment.setAuthor(account);

        CompoundPropertyModel<Comment> model = new CompoundPropertyModel<>(comment);
        this.setModel(model);

        this.add(new Label("commentTextLabel", new Model<>("Your comment")));
        this.add(new TextArea<>("text").setRequired(true));
    }

    @Override
    protected void onSubmit() {
        Comment comment = this.getModelObject();
        feed.getComments().add(comment);
        feedRepository.saveFeed(feed);
        setResponsePage(new FeedPage(feed));
    }
}
