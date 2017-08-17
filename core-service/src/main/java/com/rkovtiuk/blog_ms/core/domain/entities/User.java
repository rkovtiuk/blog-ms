package com.rkovtiuk.blog_ms.core.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "forename")
    private String forename;

    @Column(name = "surname")
    private String surname;

    @Column(name = "organisation")
    private String organisation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Blog> writtenBlogs;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Token token;

    @Column(name = "password")
    private String password;

    @Column(name = "points")
    private long points;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public long getPoints() {
        return points;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Blog> getUserBlogs() {
        return writtenBlogs;
    }

    public void setUserBlogs(List<Blog> userBlogs) {
        this.writtenBlogs = userBlogs;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public List<Blog> getWrittenBlogs() {
        return writtenBlogs;
    }

    public void setWrittenBlogs(List<Blog> writtenBlogs) {
        this.writtenBlogs = writtenBlogs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
