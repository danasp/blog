package org.yab.lemonsky.ui.components.form;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.ui.pages.Index;
import org.yab.lemonsky.ui.security.YabAuthenticationSession;

import java.util.Date;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class AddFeedForm extends Form<Feed> {

    private FeedRepository feedRepository;

    public AddFeedForm(String id) {
        super(id);
    }

    public AddFeedForm(String id, Feed feed, FeedRepository feedRepository) {
        super(id);
        this.feedRepository = feedRepository;

        Account account = ((YabAuthenticationSession) YabAuthenticationSession.get()).getAccount();
        feed.setAuthor(account);

        CompoundPropertyModel<Feed> model = new CompoundPropertyModel<>(feed);
        this.setModel(model);
        this.add(new Label("titleLable", new Model<>("Title")));
        this.add(new TextField<>("title"));
        this.add(new Label("feedTextLable", new Model<>("Text Of your feed")));
        this.add(new TextArea<>("feedText").setRequired(true));
        this.add(new CheckBox("isVisible", new PropertyModel<>(feed, "visible")));
    }

    @Override
    protected void onSubmit() {
        Feed feed = this.getModelObject();
        feed.setDate(new Date());
        feedRepository.saveFeed(feed);
        setResponsePage(Index.class);
    }

}
