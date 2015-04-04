package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.TaskRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.course.Task;
import freeplace.lla.model.entities.course.TaskType;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
public abstract class TaskService extends BasicService<TaskRepository, Task>{
    abstract List<Task> findByLesson(CourseLesson courseLesson);
    abstract List<Task> findByTaskType(TaskType taskType);
}
