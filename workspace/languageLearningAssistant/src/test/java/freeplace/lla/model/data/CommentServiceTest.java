package freeplace.lla.model.data;

import freeplace.lla.model.data.repositories.user.CommentRepository;
import freeplace.lla.model.data.service.user.CommentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public class CommentServiceTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentService;

    @Test
    public void test() {
     //   commentService = new CommentServiceImpl(commentRepository);
    //    commentService.findAll();
    //    commentService.add(new Comment());
    }
}
