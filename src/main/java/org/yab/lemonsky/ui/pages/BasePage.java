package org.yab.lemonsky.ui.pages;

import org.apache.wicket.Component;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.ui.components.panel.NavigationPanel;
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
    private NavigationPanel navPanel;

    public BasePage() {
        super();
        this.isLoggedIn = YabAuthenticationSession.get().isSignedIn();
        this.roles = YabAuthenticationSession.get().getRoles();
        init();
    }

    private void init() {
        navPanel = new NavigationPanel("navPanel", roles, isLoggedIn);
        add(navPanel);
    }

    public NavigationPanel getNavPanel() {
        return navPanel;
    }
}
