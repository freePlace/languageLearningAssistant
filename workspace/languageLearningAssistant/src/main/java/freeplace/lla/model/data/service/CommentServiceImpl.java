package freeplace.lla.model.data.service;

import java.sql.Date;
import java.util.List;

import freeplace.lla.model.data.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freeplace.lla.model.entities.Comment;
import freeplace.lla.model.entities.User;

@Service
public class CommentServiceImpl implements CommentService<Comment>{

    private final CommentRepository commentRepository;
    
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @Override
    public Comment add(Comment object) {
        return commentRepository.saveAndFlush(object);
    }

    @Override
    public Comment update(Comment object) {
        return commentRepository.saveAndFlush(object);
    }

    @Override
    public void delete(Comment object) {
        commentRepository.delete(object);
    }

    @Override
    public List<Comment> findAll() { return commentRepository.findAll(); }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public List<Comment> findByDate(Date date) {
        return commentRepository.findByDate(date);
    }

    @Override
    public List<Comment> findByUser(User user) {
        return commentRepository.findByUser(user);
    }

}
