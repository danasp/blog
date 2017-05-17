package org.yab.lemonsky.ui.components.panel;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.yab.lemonsky.models.entities.Comment;
import org.yab.lemonsky.models.entities.Feed;
import org.yab.lemonsky.ui.components.form.AddCommentForm;

/**
 * User: Danila Vereshchakov
 * Date: 29.10.2016
 */
public class AddCommentPanel extends Panel {

    private Feed feed;

    public AddCommentPanel(String id, Feed feed) {
        super(id);
        this.feed = feed;
        init();
    }

    private void init() {
        Comment comment = new Comment();
        Form commentForm = new AddCommentForm("commentForm", feed, comment);
        add(commentForm);
    }
}
