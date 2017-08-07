package com.rkovtiuk.blog_ms.core.domain.requests.notifications;

import com.rkovtiuk.blog_ms.core.domain.requests.BaseRequest;

public class NotificationRequest extends BaseRequest{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
