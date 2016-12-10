package org.yab.lemonsky.wicket.pages.add_feed;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.wicket.components.form.AddFeedForm;
import org.yab.lemonsky.wicket.pages.BasePage;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
@MountPath("add_feed")
@AuthorizeInstantiation({"ADMIN"})
public class AddFeedPage extends BasePage {

    public AddFeedPage() {
        super();
        init();
    }

    private void init() {
        AddFeedForm form = new AddFeedForm("feedForm", new Feed(), feedRepository);
        add(form);

        add(new FeedbackPanel("feedback"));
    }

}
