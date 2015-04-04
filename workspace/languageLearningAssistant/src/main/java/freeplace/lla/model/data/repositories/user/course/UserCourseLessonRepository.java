package freeplace.lla.model.data.repositories.user.course;

import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.user.course.UserCourse;
import freeplace.lla.model.entities.user.course.UserCourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
@Repository
public interface UserCourseLessonRepository extends JpaRepository<UserCourseLesson, Long> {

    public static final String FIND_BY_USER_ACTIVITY_STATE = "select ucl from UserCourseLesson ucl where ucl.userActivityState = :userActivityState";
    public static final String FIND_BY_USER_COURSE = "select ucl from UserCourseLesson ucl where ucl.userCourse = :userCourse";
    public static final String FIND_BY_COURSE_LESSON = "select ucl from UserCourseLesson ucl where ucl.courseLesson = :courseLesson";

    @Query(FIND_BY_USER_ACTIVITY_STATE)
    List<UserCourseLesson> findByUserActivityState(@Param("userActivityState") Integer userActivityState);

    @Query(FIND_BY_USER_COURSE)
    List<UserCourseLesson> findByUserCourse(@Param("userCourse") UserCourse userCourse);

    @Query(FIND_BY_COURSE_LESSON)
    List<UserCourseLesson> findByCourseLesson(@Param("courseLesson") CourseLesson courseLesson);
}
