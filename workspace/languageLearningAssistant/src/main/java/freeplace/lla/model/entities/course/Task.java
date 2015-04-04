package freeplace.lla.model.entities.course;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Entity
@Table(name = Task.TABLE_NAME)
public class Task {

    public static final String TABLE_NAME = "task";
    public static final String COLUMN_TASK_ID = "task_id";
    public static final String COLUMN_TASK_CONTENT = "task_content";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_TASK_ID)
    private Long id;

    @Column(name = COLUMN_TASK_CONTENT)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = CourseLesson.COLUMN_COURSE_LESSON_ID)
    private CourseLesson courseLesson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = TaskType.COLUMN_TASK_TYPE_ID)
    private TaskType taskType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CourseLesson getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(CourseLesson courseLesson) {
        this.courseLesson = courseLesson;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}
