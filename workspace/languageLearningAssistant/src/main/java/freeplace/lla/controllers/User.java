package freeplace.lla.controllers;

import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends ResourceSupport {

    private final String userInfo;

    @JsonCreator
    public User(@JsonProperty("content") String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserInfo() {
        return userInfo;
    }


}