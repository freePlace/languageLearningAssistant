package freeplace.lla.model.data.service.course;

import freeplace.lla.model.data.repositories.course.TaskRepository;
import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.course.Task;
import freeplace.lla.model.entities.course.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Service
public class TaskServiceImpl extends TaskService{

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.jpaRepository = taskRepository;
    }

    @Override
    List<Task> findByLesson(CourseLesson courseLesson) {
        return ((TaskRepository)jpaRepository).findByLesson(courseLesson);
    }

    @Override
    List<Task> findByTaskType(TaskType taskType) {
        return ((TaskRepository)jpaRepository).findByTaskType(taskType);
    }
}
