package freeplace.lla.model.data.service.user.course;

import freeplace.lla.model.data.repositories.user.course.UserCourseLessonRepository;
import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.user.course.UserCourse;
import freeplace.lla.model.entities.user.course.UserCourseLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
@Service
public class UserCourseLessonServiceImpl extends UserCourseLessonService{

    @Autowired
    public UserCourseLessonServiceImpl(UserCourseLessonRepository userCourseLessonRepository) {
        this.jpaRepository = userCourseLessonRepository;
    }

    @Override
    List<UserCourseLesson> findByUserActivityState(Integer userActivityState) {
        return ((UserCourseLessonRepository)jpaRepository).findByUserActivityState(userActivityState);
    }

    @Override
    List<UserCourseLesson> findByUserCourse(UserCourse userCourse) {
        return ((UserCourseLessonRepository)jpaRepository).findByUserCourse(userCourse);
    }

    @Override
    List<UserCourseLesson> findByCourseLesson(CourseLesson courseLesson) {
        return ((UserCourseLessonRepository)jpaRepository).findByCourseLesson(courseLesson);
    }
}
