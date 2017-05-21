package org.yab.lemonsky.ui.components.panel;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.yab.lemonsky.ui.pages.Index;
import org.yab.lemonsky.ui.pages.add_feed.AddFeedPage;
import org.yab.lemonsky.ui.pages.login.YabSignInPage;
import org.yab.lemonsky.ui.security.RoleChecker;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class NavigationPanel extends Panel {

    private Roles roles;
    private boolean isLoggedIn;

    public NavigationPanel(String id, Roles roles, boolean isLoggedIn) {
        super(id);
        this.roles = roles;
        this.isLoggedIn = isLoggedIn;
        init();
    }

    private void init() {
        Link headerLink = new StatelessLink("headerLink") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        };
        add(headerLink);

        add(new StatelessLink("home") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });

        add(new StatelessLink("addFeed") {
            @Override
            public void onClick() {
                setResponsePage(AddFeedPage.class);
            }
        }.setVisible(RoleChecker.isAdmin(roles)));

        add(new StatelessLink("about") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });

        add(new SignOutPanel("signOutPanel")
                .setRenderBodyOnly(true)
                .setVisible(this.isLoggedIn));

        add(new StatelessLink("login") {
            @Override
            public void onClick() {
                setResponsePage(YabSignInPage.class);
            }
        }.setVisible(!this.isLoggedIn));
    }
}
