package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseLevelRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.CourseLevel;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
public abstract class CourseLevelService
        extends BasicService<CourseLevelRepository, CourseLevel> {
    abstract CourseLevel findByName(String name);
}
