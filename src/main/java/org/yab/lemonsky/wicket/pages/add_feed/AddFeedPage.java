package org.yab.lemonsky.wicket.pages.add_feed;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.services.FeedService;
import org.yab.lemonsky.wicket.components.form.AddFeedForm;
import org.yab.lemonsky.wicket.pages.BasePage;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
@MountPath("add_feed")
public class AddFeedPage extends BasePage {

    public AddFeedPage() {
        super();
        init();
    }

    private void init() {
        AddFeedForm form = new AddFeedForm("feedForm", new Feed(), feedService);
        add(form);

        add(new FeedbackPanel("feedback"));
    }

}
