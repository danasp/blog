package org.yab.lemonsky.wicket.pages;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.repository.FeedRepository;
import org.yab.lemonsky.wicket.components.panel.NavigationPanel;
import org.yab.lemonsky.wicket.security.YabAuthenticationSession;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
public class BasePage extends WebPage {

    @SpringBean
    protected FeedRepository feedRepository;
    protected boolean isLogined;
    protected Roles roles;

    public BasePage() {
        super();
        this.isLogined = YabAuthenticationSession.get().isSignedIn();
        this.roles = YabAuthenticationSession.get().getRoles();
        init();
    }

    private void init() {
        Label headerText = new Label("headerText", "It's Header");
        headerText.setMarkupId("headerText");
        add(headerText);

        Label footerText = new Label("footerText", "It's Footer");
        footerText.setMarkupId("footerText");
        add(footerText);

        add(new NavigationPanel("navPanel", roles, isLogined));
    }
}
