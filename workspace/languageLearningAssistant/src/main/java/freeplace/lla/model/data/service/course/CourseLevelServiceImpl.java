package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.CourseLevelRepository;
import freeplace.lla.model.entities.course.CourseLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
@Service
public class CourseLevelServiceImpl extends CourseLevelService {

    @Autowired
    public CourseLevelServiceImpl(CourseLevelRepository courseLevelRepository) {
        this.jpaRepository = courseLevelRepository;
    }

    @Override
    public CourseLevel findByName(String name) {
        return ((CourseLevelRepository)jpaRepository).findByName(name);
    }
}
