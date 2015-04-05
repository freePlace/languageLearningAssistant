package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.TaskTypeRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.TaskType;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
public abstract class TaskTypeService
        extends BasicService<TaskTypeRepository, TaskType>{
    abstract TaskType findByName(String name);
}
