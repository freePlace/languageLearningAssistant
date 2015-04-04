package freeplace.lla.model.data.repositories.course;

import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public static final String FIND_BY_NAME = "select cl from CourseLevel cl where name = :name";
    public static final String FIND_BY_PUBLISHER = "select cl from CourseLevel cl where publisher = :publisher";
    public static final String FIND_BY_COURSE_LEVEL = "select cl from CourseLevel cl where courseLevel = :courseLevel";

    @Query(FIND_BY_NAME)
    public Course findByName(@Param("name") String name);

    @Query(FIND_BY_PUBLISHER)
    public List<Course> findByPublisher(@Param("publisher") String publisher);

    @Query(FIND_BY_COURSE_LEVEL)
    public List<Course> findByCourseLevel(@Param("courseLevel") CourseLevel courseLevel);
}
