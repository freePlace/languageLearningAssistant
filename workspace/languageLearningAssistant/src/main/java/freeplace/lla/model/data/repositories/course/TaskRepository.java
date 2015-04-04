package freeplace.lla.model.data.repositories.course;

import freeplace.lla.model.entities.course.CourseLesson;
import freeplace.lla.model.entities.course.Task;
import freeplace.lla.model.entities.course.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

    public static final String FIND_BY_LESSON = "select t from Task t where lesson = :lesson";
    public static final String FIND_BY_TASK_TYPE = "select t from Task t where taskType = :taskType";

    @Query(FIND_BY_LESSON)
    public List<Task> findByLesson(@Param("lesson") CourseLesson courseLesson);

    @Query(FIND_BY_TASK_TYPE)
    public List<Task> findByTaskType(@Param("taskType") TaskType taskType);
}
