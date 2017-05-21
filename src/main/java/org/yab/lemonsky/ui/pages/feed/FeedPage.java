package org.yab.lemonsky.ui.pages.feed;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.ui.components.panel.FeedNavigationExtensionPanel;
import org.yab.lemonsky.ui.pages.BasePage;
import org.yab.lemonsky.ui.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.ui.security.RoleChecker;

/**
 * User: Danila Vereshchakov
 * Date: 23.10.2016
 */
@MountPath("feed")
public class FeedPage extends BasePage {

    private Feed feed;


    public FeedPage(PageParameters pageParameters) {
        String feedStrParam = pageParameters.get(0).toString();
        Long feedId = Long.parseLong(feedStrParam);
        this.feed = feedRepository.getFeedById(feedId);
        init();
    }

    private void init() {
        getNavPanel().replaceWith(new FeedNavigationExtensionPanel("navPanel", roles, isLoggedIn, feed));

        add(new Label("title", new PropertyModel<>(feed, "title")));
        add(new Label("author", new PropertyModel<>(feed, "author.username")));
        add(new MultiLineLabel("content", new PropertyModel<>(feed, "feedText")));
        add(new Label("feedDate", new PropertyModel<>(feed, "getFormattedDate")));
    }
}
