package org.yab.lemonsky.wicket.pages.feeds;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.components.link.FeedPageLink;
import org.yab.lemonsky.wicket.pages.BasePage;

import java.util.Collections;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */
@MountPath("feeds")
public class FeedsPage extends BasePage {
    private final long ITEMS_PER_PAGE = 10;
    public FeedsPage() {
        super();
        init();
    }

    private void init() {
        List<Feed> feeds = feedRepository.getAllFeeds();
        Collections.reverse(feeds);

        ListDataProvider<Feed> listDataProvider = new ListDataProvider<>(feeds);
        DataView<Feed> dataView = new DataView<Feed>("feeds", listDataProvider, ITEMS_PER_PAGE) {
            @Override
            protected void populateItem(Item<Feed> item) {
                Feed feed = item.getModelObject();
                String feedText = feed.getFeedText();
                String displayedContent = feedText.length() > 500 ? feedText.substring(0, 501) : feedText;

                FeedPageLink feedLink = new FeedPageLink("feedLink", feed);
                feedLink.add(new Label("title", new PropertyModel<>(feed, "title")));
                feedLink.add(new Label("content", new Model<>(displayedContent)));
                feedLink.add(new Label("author", new PropertyModel<>(feed, "author.username")));
                item.add(feedLink);
//                item.add(new Label("author", new PropertyModel<>(feed, "author.username")));
//                item.add(new Label("date", new PropertyModel<>(feed, "date")));
            }
        };
        add(dataView);
        add(new PagingNavigation("pageNav", dataView));
    }
}
