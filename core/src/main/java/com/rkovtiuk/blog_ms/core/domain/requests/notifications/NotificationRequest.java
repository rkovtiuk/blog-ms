package com.rkovtiuk.blog_ms.core.domain.requests.notifications;

import java.io.Serializable;

public class NotificationRequest implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
