package org.yab.lemonsky.ui.pages.add_feed;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.wicketstuff.annotation.mount.MountPath;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.ui.components.form.AddFeedForm;
import org.yab.lemonsky.ui.pages.BasePage;

/**
 * User: Danila Vereshchakov
 * Date: 17.09.2016
 */
@MountPath("add_feed")
@AuthorizeInstantiation({"ADMIN"})
public class AddFeedPage extends BasePage {

    private Feed feed;

    public AddFeedPage() {
        super();
        init();
    }

    public AddFeedPage(Feed feed) {
        super();
        this.feed = feed;
        init();
    }

    private void init() {
        AddFeedForm form = (feed == null)
                ? new AddFeedForm("feedForm", new Feed(), feedRepository)
                : new AddFeedForm("feedForm", feed, feedRepository);
        add(form);

        add(new FeedbackPanel("feedback"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssUrlReferenceHeaderItem.forUrl("css/main.css"));
    }
}
