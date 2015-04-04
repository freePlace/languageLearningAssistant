package freeplace.lla.model.data.service.user;

import java.sql.Date;
import java.util.List;

import freeplace.lla.model.data.repositories.user.CommentRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.user.Comment;
import freeplace.lla.model.entities.user.User;

public abstract class CommentService
        extends BasicService<CommentRepository, Comment> {
    abstract List<Comment> findByDate(Date date);
    abstract List<Comment> findByUser(User user);
}
