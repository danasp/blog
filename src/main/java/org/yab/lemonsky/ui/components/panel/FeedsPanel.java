package org.yab.lemonsky.ui.components.panel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.ui.components.navigator.TwoWayNavigator;
import org.yab.lemonsky.ui.pages.feed.FeedPage;

import java.util.Collections;
import java.util.List;

/**
 * User: Danila Vereshchakov
 * Date: 18.05.2017
 */
public class FeedsPanel extends Panel {

    private final long ITEMS_PER_PAGE = 10;
    private final int LETTERS_IN_PREVIEW = 100;

    public FeedsPanel(String id, FeedRepository feedRepository) {
        super(id);

        List<Feed> feeds = feedRepository.getAllFeeds();
        Collections.reverse(feeds);

        WebMarkupContainer container = new WebMarkupContainer("dataContainer");
        container.setOutputMarkupId(true);
        add(container);

        ListDataProvider<Feed> listDataProvider = new ListDataProvider<>(feeds);
        DataView<Feed> dataView = new DataView<Feed>("feeds", listDataProvider, ITEMS_PER_PAGE) {
            @Override
            protected void populateItem(Item<Feed> item) {
                Feed feed = item.getModelObject();
                String feedText = feed.getFeedText();
                String displayedContent = feedText.length() > LETTERS_IN_PREVIEW ? feedText.substring(0, (LETTERS_IN_PREVIEW + 1)) : feedText;

                String feedDate = feed.getFormattedDate();

                Link<Feed> feedLink = new StatelessLink<Feed>("feedLink") {
                    @Override
                    public void onClick() {
                        PageParameters parameters = new PageParameters();
                        parameters.set(0, feed.getId());
                        setResponsePage(FeedPage.class, parameters);
                    }
                };

                feedLink.add(new Label("title", new PropertyModel<>(feed, "title")));
                feedLink.add(new Label("content-preview", Model.of(displayedContent))
                        .setEscapeModelStrings(false));
                item.add(new Label("date", Model.of(feedDate)));
                item.add(feedLink);
            }
        };
        container.add(dataView);
        container.add(new TwoWayNavigator("pageNav", dataView) {
            @Override
            protected void onAjaxEvent(AjaxRequestTarget target) {
                super.onAjaxEvent(target);
                target.add(container);
            }
        });

    }
}
