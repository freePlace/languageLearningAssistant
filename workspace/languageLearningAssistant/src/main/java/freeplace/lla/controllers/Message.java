package freeplace.lla.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
public class Message extends ResourceSupport {

    private final String messagesInfo;

    @JsonCreator
    public Message(@JsonProperty("content") String messagesInfo) {
        this.messagesInfo = messagesInfo;
    }

    public String getMessageInfo() {
        return messagesInfo;
    }


}