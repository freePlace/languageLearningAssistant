package freeplace.lla.model.data.repositories.user.course;

import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.course.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long>{

    public static final String FIND_BY_USER_ACTIVITY_STATE = "select uc from UserCourse uc where uc.userActivityState = :userActivityState";
    public static final String FIND_BY_COURSE = "select uc from UserCourse uc where uc.course = :course";
    public static final String FIND_BY_USER = "select uc from UserCourse uc where uc.user = :user";

    @Query(FIND_BY_USER_ACTIVITY_STATE)
    List<UserCourse> findByUserActivityState(@Param("userActivityState") Integer userActivityState);

    @Query(FIND_BY_COURSE)
    List<UserCourse> findByCourse(@Param("course") Course course);

    @Query(FIND_BY_USER)
    List<UserCourse> findByUser(@Param("user") User user);
}
