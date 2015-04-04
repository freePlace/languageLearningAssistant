package freeplace.lla.model.data.service.user.course;

import freeplace.lla.model.data.repositories.user.course.UserCourseLessonRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.user.course.UserCourse;
import freeplace.lla.model.entities.user.course.UserCourseLesson;

import java.util.List;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
public abstract class UserCourseLessonService
        extends BasicService<UserCourseLessonRepository, UserCourseLesson> {
    abstract List<UserCourseLesson> findByUserActivityState(Integer userActivityState);
    abstract List<UserCourseLesson> findByUserCourse(UserCourse userCourse);
    abstract List<UserCourseLesson> findByCourseLesson(CourseLesson courseLesson);
}
