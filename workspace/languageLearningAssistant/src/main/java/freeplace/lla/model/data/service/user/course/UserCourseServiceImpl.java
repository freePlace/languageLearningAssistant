package freeplace.lla.model.data.service.user.course;

import freeplace.lla.model.data.repositories.user.course.UserCourseRepository;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.course.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
@Service
public class UserCourseServiceImpl extends UserCourseService{

    @Autowired
    public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.jpaRepository = userCourseRepository;
    }

    @Override
    List<UserCourse> findByUserActivityState(Integer userActivityState) {
        return ((UserCourseRepository) jpaRepository).findByUserActivityState(userActivityState);
    }

    @Override
    List<UserCourse> findByCourse(Course course) {
        return ((UserCourseRepository) jpaRepository).findByCourse(course);
    }

    @Override
    List<UserCourse> findByUser(User user) {
        return ((UserCourseRepository) jpaRepository).findByUser(user);
    }
}
