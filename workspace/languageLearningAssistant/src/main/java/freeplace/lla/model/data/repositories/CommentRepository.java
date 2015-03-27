package freeplace.lla.model.data.repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import freeplace.lla.model.entities.Comment;
import freeplace.lla.model.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    public static final String FIND_COMMENTS_BY_DATE = "select c from Comment c where c.date = :date";
    public static final String FIND_COMMENTS_BY_USER = "select c from Comment c where c.user = :user";

    @Query(FIND_COMMENTS_BY_DATE)
    List<Comment> findByDate(@Param("date") Date date);
    
    @Query(FIND_COMMENTS_BY_USER)
    List<Comment> findByUser(@Param("user") User user);
}
