package freeplace.lla.model.data.service.user.course;

import freeplace.lla.model.data.repositories.user.course.UserCourseRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.course.UserCourse;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
public abstract class UserCourseService
        extends BasicService<UserCourseRepository, UserCourse>{
    abstract List<UserCourse> findByUserActivityState(Integer userActivityState);
    abstract List<UserCourse> findByCourse(Course course);
    abstract List<UserCourse> findByUser(User user);
}
