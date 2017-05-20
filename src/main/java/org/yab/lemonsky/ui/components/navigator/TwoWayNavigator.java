package org.yab.lemonsky.ui.components.navigator;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.navigation.paging.IPageable;

/**
 * User: Danila Vereshchakov
 * Date: 20.05.2017
 */
public class TwoWayNavigator extends AjaxPagingNavigator {
    public TwoWayNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        if (getPageable().getCurrentPage() == 0) {
            get("prev").setVisible(false);
        }
        get("first").setVisible(false);
        get("last").setVisible(false);
        getPagingNavigation().setVisible(false);
    }

    @Override
    protected void onAjaxEvent(AjaxRequestTarget target) {
        super.onAjaxEvent(target);
        hideRedundantNavigation();
    }

    private void hideRedundantNavigation() {
        if (getPageable().getCurrentPage() == 0) {
            get("prev").setVisible(false);
        } else {
            get("prev").setVisible(true);
        }

        if (getPageable().getCurrentPage() == getPageable().getPageCount() - 1) {
            get("next").setVisible(false);
        } else {
            get("next").setVisible(true);
        }
    }
}
