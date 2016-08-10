package org.yab.lemonsky.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;

/**
 * Created by Danila on 04.06.2016.
 */

@Entity
@SequenceGenerator(name = "seq_feed_generator", sequenceName = "feed_generator", allocationSize = 1)
public class Feed {

    @Id
    @GeneratedValue(generator = "seq_feed_generator")
    private Long id;

    private Account author;

    private String title;

    private String text;

    private Date date;

    private List<Comment> comments;

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feed{");
        sb.append("author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", date=").append(date);
        sb.append(", comments=").append(comments);
        sb.append('}');
        return sb.toString();
    }
}
