package org.yab.lemonsky.models.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Danila on 05.06.2016.
 */

@Entity
@SequenceGenerator(name = "seq_comment_generator", sequenceName = "comment_generator", allocationSize = 1)
public class Comment {

    @Id
    @GeneratedValue(generator = "seq_comment_generator")
    private Long id;

    @Transient
    private Account author;

    private String text;

    private Date date;

    @Transient
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
