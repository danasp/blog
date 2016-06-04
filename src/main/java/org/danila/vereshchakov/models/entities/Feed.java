package org.danila.vereshchakov.models.entities;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Danila on 04.06.2016.
 */

public class Feed {

    private Account author;

    private String title;

    private String text;

    private LocalDateTime date;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
