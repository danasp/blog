package org.danila.vereshchakov.models.entities;

import java.time.LocalDateTime;

/**
 * Created by Danila on 05.06.2016.
 */

public class Comment {

    private Account author;

    private String text;

    private LocalDateTime date;

    private Long like;

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
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

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("author=").append(author);
        sb.append(", text='").append(text).append('\'');
        sb.append(", date=").append(date);
        sb.append(", like=").append(like);
        sb.append('}');
        return sb.toString();
    }
}
