package org.yab.lemonsky.wicket.pages.feeds;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.pages.BasePage;

import java.util.Arrays;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 22.10.2016
 */
@MountPath("feeds")
public class FeedsPage extends BasePage {
    private final long ITEMS_PER_PAGE = 2;
    public FeedsPage() {
        super();
        init();
    }

    private void init() {
        List<Feed> feeds = feedService.getAllFeeds();

        ListDataProvider<Feed> listDataProvider = new ListDataProvider<>(feeds);
        DataView<Feed> dataView = new DataView<Feed>("feeds", listDataProvider, ITEMS_PER_PAGE) {
            @Override
            protected void populateItem(Item<Feed> item) {
                Feed feed = item.getModelObject();

                item.add(new Label("title", new PropertyModel<>(feed, "title")));
                item.add(new Label("author", new PropertyModel<>(feed, "author.username")));
                item.add(new Label("date", new PropertyModel<>(feed, "date")));
            }
        };
        /*ListView<Feed> listView = new ListView<Feed>("feeds", feeds) {
            @Override
            protected void populateItem(ListItem<Feed> listItem) {
                Feed feed = listItem.getModelObject();
                listItem.add(new Label("title", new PropertyModel<>(feed, "title")));
                listItem.add(new Label("author", new PropertyModel<>(feed, "author.username")));
                listItem.add(new Label("date", new PropertyModel<>(feed, "date")));
            }
        };*/

        add(dataView);
        add(new PagingNavigation("pageNav", dataView));
    }
}
