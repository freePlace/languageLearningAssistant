package freeplace.lla.model.entities.course;

import freeplace.lla.model.entities.user.course.UserCourse;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
@Entity
@Table(name = Course.TABLE_NAME)
public class Course {

    public static final String TABLE_NAME = "course";
    public static final String COLUMN_COURSE_ID = "course_id";
    public static final String COLUMN_COURSE_NAME = "course_name";
    public static final String COLUMN_COURSE_PUBLISHER = "course_publisher";

    @Id
    @Column(name = COLUMN_COURSE_ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = COLUMN_COURSE_NAME)
    private String name;

    @Column(name = COLUMN_COURSE_PUBLISHER)
    private String publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = CourseLevel.COLUMN_COURSE_LEVEL_ID)
    private CourseLevel level;

    @OneToMany
    @JoinColumn(name=Course.COLUMN_COURSE_ID)
    private List<CourseLesson> courseLessons;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = COLUMN_COURSE_ID)
    private List<UserCourse> userCourses;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public CourseLevel getLevel() {
        return level;
    }

    public void setLevel(CourseLevel level) {
        this.level = level;
    }

    public List<CourseLesson> getCourseLessons() {
        return courseLessons;
    }

    public void setCourseLessons(List<CourseLesson> courseLessons) {
        this.courseLessons = courseLessons;
    }

    public List<UserCourse> getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(List<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }
}
