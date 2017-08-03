package com.rkovtiuk.boot_microservices.userclientlibs.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserView implements Serializable{

    private Integer id;
    private String forename;
    private String surname;
    private String organisation;
    private List<String> notifications;
    private long points;

    public UserView() {
    }

    public UserView(Integer id) {
        String[] forenames = {"Alice", "Bartosz", "Mack"};
        String[] surnames = {"Smith", "Salvatore", "Jedrzejewski", "Scott"};
        String[] organisations = {"ScottLogic", "UNICEF"};

        forename = forenames[id%3];
        surname = surnames[id%4];
        organisation = organisations[id%2];
        notifications= new ArrayList<>();
        notifications.add("You have been promoted!");
        notifications.add("Sorry, disregard the previous notifaction- wrong user");
        points = id * 31 % 1000;

        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
