package freeplace.lla.model.entities.course;

import freeplace.lla.model.entities.user.course.UserCourseLesson;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Entity
@Table(name = CourseLesson.TABLE_NAME)
public class CourseLesson {

    public static final String TABLE_NAME = "course_lesson";
    public static final String COLUMN_COURSE_LESSON_ID = "course_lesson_id";
    public static final String COLUMN_COURSE_LESSON_TOPIC = "course_lesson_topic";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_COURSE_LESSON_ID)
    private Long id;

    @Column(name = COLUMN_COURSE_LESSON_TOPIC)
    private String topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Course.COLUMN_COURSE_ID)
    private Course course;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = CourseLesson.COLUMN_COURSE_LESSON_ID)
    private List<Task> tasks;

    @OneToMany(fetch =  FetchType.EAGER)
    @JoinColumn(name = COLUMN_COURSE_LESSON_ID)
    private List<UserCourseLesson> userCourseLessons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<UserCourseLesson> getUserCourseLessons() {
        return userCourseLessons;
    }

    public void setUserCourseLessons(List<UserCourseLesson> userCourseLessons) {
        this.userCourseLessons = userCourseLessons;
    }
}
