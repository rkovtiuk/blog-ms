package com.rkovtiuk.blog_ms.db.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "text")
    private String text;

    @Column(name = "created_date")
    private long CreatedDate;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="answer_id", nullable=true)
    private Comment answer;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(long createdDate) {
        CreatedDate = createdDate;
    }

    public Comment getAnswer() {
        return answer;
    }

    public void setAnswer(Comment answer) {
        this.answer = answer;
    }
}
