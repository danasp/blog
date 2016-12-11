package org.yab.lemonsky.wicket.pages.feeds;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.pages.BasePage;
import org.yab.lemonsky.wicket.pages.feed.FeedPage;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */
@MountPath("feeds")
public class FeedsPage extends BasePage {
    private final long ITEMS_PER_PAGE = 10;
    private final int LETTERS_IN_PREVIEW = 500;
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
                String displayedContent = feedText.length() > LETTERS_IN_PREVIEW ? feedText.substring(0, (LETTERS_IN_PREVIEW + 1)) : feedText;

                String feedDate = formatDate(feed.getDate());

                Link<Feed> feedLink = new Link<Feed>("feedLink") {
                    @Override
                    public void onClick() {
                        setResponsePage(new FeedPage(feed));
                    }
                };

                feedLink.add(new Label("title", new PropertyModel<>(feed, "title")));
                feedLink.add(new Label("content", Model.of(displayedContent)));
                feedLink.add(new Label("date", Model.of(feedDate)));
                item.add(feedLink);
            }
        };
        add(dataView);
        add(new PagingNavigation("pageNav", dataView));
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(date);
    }
}
