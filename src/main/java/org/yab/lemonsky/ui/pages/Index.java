package org.yab.lemonsky.ui.pages;

import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.ui.components.panel.FeedsPanel;

/**
 * User: Danila Vereshchakov
 * Date: 27.08.2016
 */

@MountPath("index")
public class Index extends BasePage {

    public Index() {
        super();
        add(new FeedsPanel("feeds", feedRepository, roles));
    }
}
