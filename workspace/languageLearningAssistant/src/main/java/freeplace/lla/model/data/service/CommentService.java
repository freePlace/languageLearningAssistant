package freeplace.lla.model.data.service;

import java.sql.Date;
import java.util.List;

import freeplace.lla.model.entities.User;

public interface CommentService<Comment> extends BasicService<Comment>{
    List<Comment> findByDate(Date date);
    List<Comment> findByUser(User user);
}
