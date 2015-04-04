package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseRepository;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Service
public class CourseServiceImpl extends CourseService {

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        jpaRepository = courseRepository;
    }

    @Override
    Course findByName(String name) {
        return ((CourseRepository) jpaRepository).findByName(name);
    }

    @Override
    List<Course> findByPublisher(String publisher) {
        return ((CourseRepository) jpaRepository).findByPublisher(publisher);
    }

    @Override
    List<Course> findByCourseLevel(CourseLevel courseLevel) {
        return ((CourseRepository) jpaRepository).findByCourseLevel(courseLevel);
    }
}
