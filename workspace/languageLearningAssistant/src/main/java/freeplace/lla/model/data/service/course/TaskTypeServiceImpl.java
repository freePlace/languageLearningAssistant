package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.TaskTypeRepository;
import freeplace.lla.model.entities.course.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Service
public class TaskTypeServiceImpl extends TaskTypeService{

    @Autowired
    public TaskTypeServiceImpl(TaskTypeRepository taskTypeRepository) {
        this.jpaRepository = taskTypeRepository;
    }

    @Override
    TaskType findByName(String name) {
        return ((TaskTypeRepository) jpaRepository).findByName(name);
    }
}
