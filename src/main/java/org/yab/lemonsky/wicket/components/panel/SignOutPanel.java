package org.yab.lemonsky.wicket.components.panel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.yab.lemonsky.wicket.pages.Index;
import org.yab.lemonsky.wicket.security.YabAuthenticationSession;

/**
 * User: Danila Vereshchakov
 * Date: 06.12.2016
 */
public class SignOutPanel extends Panel {

    public SignOutPanel(String id) {
        this(id, null);
    }

    public SignOutPanel(String id, IModel<?> model) {
        super(id, model);
        init();
    }

    private void init() {
        add(new Link("signOut") {
            @Override
            public void onClick() {
                if (YabAuthenticationSession.get().isSignedIn()) {
                    YabAuthenticationSession.get().invalidate();
                }
                setResponsePage(Index.class);
            }
        });

    }
}
