package freeplace.lla.model.data.repositories.course;

import freeplace.lla.model.entities.course.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
@Repository
public interface CourseLevelRepository extends JpaRepository<CourseLevel, Long> {

    public static final String FIND_BY_COURSE_LEVEL_NAME = "select cl from CourseLevel cl where name = :name";

    @Query(FIND_BY_COURSE_LEVEL_NAME)
    public CourseLevel findByName(@Param("name") String name);
}
