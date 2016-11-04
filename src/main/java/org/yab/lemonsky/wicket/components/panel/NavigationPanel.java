package org.yab.lemonsky.wicket.components.panel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.yab.lemonsky.wicket.pages.Index;
import org.yab.lemonsky.wicket.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.wicket.pages.feeds.FeedsPage;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class NavigationPanel extends Panel {

    public NavigationPanel(String id) {
        super(id);
        init();
    }

    private void init() {
        add(new Link("link1") {
            @Override
            public void onClick() {
                setResponsePage(FeedsPage.class);
            }
        });

        add(new Link("link2") {
            @Override
            public void onClick() {
                setResponsePage(AddFeedPage.class);
            }
        });

        add(new Link("link3") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });
    }
}
