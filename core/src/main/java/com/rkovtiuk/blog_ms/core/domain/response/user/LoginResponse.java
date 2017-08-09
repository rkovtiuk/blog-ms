package com.rkovtiuk.blog_ms.core.domain.response.user;

import com.rkovtiuk.blog_ms.core.domain.model.SessionTokenDTO;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.response.BaseResponse;

public class LoginResponse extends BaseResponse {

    private SessionTokenDTO sessionToken;
    private UserDTO forename;

    public SessionTokenDTO getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(SessionTokenDTO sessionToken) {
        this.sessionToken = sessionToken;
    }

    public UserDTO getForename() {
        return forename;
    }

    public void setForename(UserDTO forename) {
        this.forename = forename;
    }
}
