package org.yab.lemonsky.ui.components.panel;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.ui.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.ui.security.RoleChecker;

/**
 * User: Danila Vereshchakov
 * Date: 21.05.2017
 */
public class FeedNavigationExtensionPanel extends NavigationPanel {

    public FeedNavigationExtensionPanel(String id, Roles roles, boolean isLoggedIn, Feed feed) {
        super(id, roles, isLoggedIn);
        add(new StatelessLink<Feed>("editFeed") {
            @Override
            public void onClick() {
                setResponsePage(new AddFeedPage(feed));
            }
        }.setVisible(RoleChecker.isAdmin(roles)));
    }

}
