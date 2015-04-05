package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseLessonRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLesson;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
public abstract class CourseLessonService
        extends BasicService<CourseLessonRepository, CourseLesson> {
    abstract CourseLesson findByName(String name);
    abstract List<CourseLesson> findByCourse(Course course);
}
