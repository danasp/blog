package org.yab.lemonsky.wicket.components.form;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.services.FeedService;
import org.yab.lemonsky.wicket.pages.feeds.FeedsPage;

import java.util.Date;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class AddFeedForm extends Form<Feed> {

    private FeedService feedService;

    public AddFeedForm(String id) {
        super(id);
    }

    public AddFeedForm(String id, Feed feed, FeedService feedService) {
        super(id);
        this.feedService = feedService;

        Account account = new Account("test", "test", "test", "test", "test@test.test");
        account.setId(1L);
        feed.setAuthor(account);

        CompoundPropertyModel<Feed> model = new CompoundPropertyModel<>(feed);
        this.setModel(model);
        this.add(new Label("titleLable", new Model<>("Title")));
        this.add(new TextField<>("title"));
        this.add(new Label("feedTextLable", new Model<>("Text Of your feed")));
        this.add(new TextArea<>("feedText").setRequired(true));
    }

    @Override
    protected void onSubmit() {
        Feed feed = this.getModelObject();
        feed.setDate(new Date());
        feedService.saveFeed(feed);
        setResponsePage(FeedsPage.class);
    }

}
