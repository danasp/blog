package org.yab.lemonsky.ui.components.panel;

import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.yab.lemonsky.ui.pages.Index;
import org.yab.lemonsky.ui.security.YabAuthenticationSession;

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
        add(new StatelessLink("signOut") {
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
