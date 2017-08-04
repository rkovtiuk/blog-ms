package com.rkovtiuk.blog_ms.userclientlibs.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.ResponseEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationDTO {

    private int id;
    private String title;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
