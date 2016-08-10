package org.yab.lemonsky.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.yab.lemonsky.wicket.pages.Index;

/**
 * User: Danila Vereshchakov
 * Date: 27.08.2016
 */
public class YablogApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return Index.class;
    }

    @Override
    protected void init() {
        super.init();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    }
}
