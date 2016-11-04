package org.yab.lemonsky.wicket.components.link;

import org.apache.wicket.markup.html.link.Link;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.pages.feed.FeedPage;

/**
 * User: Danila Vereshchakov
 * Date: 23.10.2016
 */
public class FeedPageLink extends Link<Feed> {

    private Feed feed;

    public FeedPageLink(String id, Feed feed) {
        super(id);
        this.feed = feed;
    }

    @Override
    public void onClick() {
        setResponsePage(new FeedPage(feed));
    }
}
