package freeplace.lla.model.data.repositories.course;

import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long>{

    public static final String FIND_BY_TOPIC = "select l from CourseLesson l where topic = :topic";
    public static final String FIND_BY_COURSE = "select l from CourseLesson l where course = :course";

    @Query(FIND_BY_TOPIC)
    public CourseLesson findByName(@Param("topic") String topic);

    @Query(FIND_BY_COURSE)
    public List<CourseLesson> findByCourse(@Param("course") Course course);
}
