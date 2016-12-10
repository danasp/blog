package org.yab.lemonsky.wicket.components.panel;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.yab.lemonsky.wicket.pages.Index;
import org.yab.lemonsky.wicket.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.wicket.pages.feeds.FeedsPage;
import org.yab.lemonsky.wicket.pages.login.YabSignInPage;
import org.yab.lemonsky.wicket.security.RoleChecker;
import org.yab.lemonsky.wicket.security.YabAuthenticationSession;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class NavigationPanel extends Panel {

    private Roles roles;
    private boolean isLogined;

    public NavigationPanel(String id, Roles roles, boolean isLogined) {
        super(id);
        this.roles = roles;
        this.isLogined = isLogined;
        init();
    }

    private void init() {
        add(new Link("home") {
            @Override
            public void onClick() {
                setResponsePage(FeedsPage.class);
            }
        });

        add(new Link("addFeed") {
            @Override
            public void onClick() {
                setResponsePage(AddFeedPage.class);
            }
        }.setVisible(RoleChecker.isAdmin(roles)));

        add(new Link("link3") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });

        add(new SignOutPanel("signOutPanel")
                .setVisible(this.isLogined));

        add(new Link("login") {
            @Override
            public void onClick() {
                setResponsePage(YabSignInPage.class);
            }
        }.setVisible(!this.isLogined));
    }
}
