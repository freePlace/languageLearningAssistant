package freeplace.lla.model.entities.course;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Entity
@Table(name = TaskType.TABLE_NAME)
public class TaskType {

    public static final String TABLE_NAME = "task_type";
    public static final String COLUMN_TASK_TYPE_ID = "task_type_id";
    public static final String COLUMN_TASK_TYPE_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_TASK_TYPE_ID)
    private Long id;

    @Column(name = COLUMN_TASK_TYPE_NAME)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = TaskType.COLUMN_TASK_TYPE_ID)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
