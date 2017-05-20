package org.yab.lemonsky.ui.pages;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.ui.components.panel.NavigationPanel;
import org.yab.lemonsky.ui.pages.feeds.FeedsPage;
import org.yab.lemonsky.ui.security.YabAuthenticationSession;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class BasePage extends WebPage {

    @SpringBean
    protected FeedRepository feedRepository;
    protected boolean isLoggedIn;
    protected Roles roles;

    public BasePage() {
        super();
        this.isLoggedIn = YabAuthenticationSession.get().isSignedIn();
        this.roles = YabAuthenticationSession.get().getRoles();
        init();
    }

    private void init() {
        add(new NavigationPanel("navPanel", roles, isLoggedIn));
    }
}
