package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseLessonRepository;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Service
public class CourseLessonServiceImpl extends CourseLessonService {

    @Autowired
    public CourseLessonServiceImpl(CourseLessonRepository lessonRepository) {
        this.jpaRepository = lessonRepository;
    }

    @Override
    CourseLesson findByName(String name) {
        return ((CourseLessonRepository) jpaRepository).findByName(name);
    }

    @Override
    List<CourseLesson> findByCourse(Course course) {
        return ((CourseLessonRepository) jpaRepository).findByCourse(course);
    }
}
