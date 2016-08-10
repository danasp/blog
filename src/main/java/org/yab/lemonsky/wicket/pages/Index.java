package org.yab.lemonsky.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * User: Danila Vereshchakov
 * Date: 27.08.2016
 */

public class Index extends WebPage {

    public Index() {
        super();

        add(new Label("test", "Test"));
    }
}
