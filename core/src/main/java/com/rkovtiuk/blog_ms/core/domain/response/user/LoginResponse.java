package com.rkovtiuk.blog_ms.core.domain.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rkovtiuk.blog_ms.core.domain.model.SessionTokenDTO;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.response.BaseResponse;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class LoginResponse extends BaseResponse {

    private String sessionToken;
    private Integer id;
    private String email;
    private String forename;
    private String surname;
    private String organisation;
    private long points;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

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

    public void setPoints(long points) {
        this.points = points;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
