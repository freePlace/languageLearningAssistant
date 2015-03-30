package freeplace.lla.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
public class Comment extends ResourceSupport {

    private final String comment;

    @JsonCreator
    public Comment(@JsonProperty("comment") String comment) {
        this.comment = comment;
    }
    public String getCommentInfo() {
        return comment;
    }


}