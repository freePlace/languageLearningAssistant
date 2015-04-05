package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.course.CourseLevel;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
public abstract class CourseService
        extends BasicService<CourseRepository, Course> {
    abstract Course findByName(String name);
    abstract List<Course> findByPublisher(String publisher);
    abstract List<Course> findByCourseLevel(CourseLevel courseLevel);
}
