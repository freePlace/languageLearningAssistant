package freeplace.lla.model.entities.course;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
@Entity
@Table(name = CourseLevel.TABLE_NAME)
public class CourseLevel {

    public static final String TABLE_NAME = "course_level";
    public static final String COLUMN_COURSE_LEVEL_ID = "course_level_id";
    public static final String COLUMN_COURSE_LEVEL_NAME = "course_level_name";

    @Id
    @Column(name = COLUMN_COURSE_LEVEL_ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COLUMN_COURSE_LEVEL_NAME)
    private String name;

    @OneToMany
    @JoinColumn(name = Course.COLUMN_COURSE_ID)
    private List<Course> courses;

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
