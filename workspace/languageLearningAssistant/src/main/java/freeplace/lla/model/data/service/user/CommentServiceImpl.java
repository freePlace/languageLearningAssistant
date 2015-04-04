package freeplace.lla.model.data.service.user;

import java.sql.Date;
import java.util.List;

import freeplace.lla.model.data.repositories.user.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freeplace.lla.model.entities.user.Comment;
import freeplace.lla.model.entities.user.User;

@Service
public class CommentServiceImpl extends CommentService {

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.jpaRepository = commentRepository;
    }
    
    @Override
    public List<Comment> findByDate(Date date) {
        return ((CommentRepository)jpaRepository).findByDate(date);
    }

    @Override
    public List<Comment> findByUser(User user) {
        return ((CommentRepository)jpaRepository).findByUser(user);
    }

}
