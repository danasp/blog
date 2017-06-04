package org.yab.lemonsky.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Danila on 04.06.2016.
 */

@Entity
@SequenceGenerator(name = "seq_feed_generator", sequenceName = "feed_generator", allocationSize = 1)
public class Feed implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_feed_generator")
    private Long id;

    @ManyToOne
    private Account author;

    private String title;

    @Column(columnDefinition = "text")
    private String feedText;

    private Date date;

    private boolean visible;


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

    public String getFeedText() {
        return feedText;
    }

    public void setFeedText(String feedText) {
        this.feedText = feedText;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feed{");
        sb.append("feedText='").append(feedText).append('\'');
        sb.append(", id=").append(id);
        sb.append(", author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", date=").append(date);
        sb.append(", visible=").append(visible);
        sb.append('}');
        return sb.toString();
    }
}
