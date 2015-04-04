package freeplace.lla.model.entities.user.course;

import freeplace.lla.model.entities.course.Course;
import freeplace.lla.model.entities.user.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by klymenko.ruslan on 31.03.2015.
 */
@Entity
@Table(name = UserCourse.TABLE_NAME)
public class UserCourse {

    public static final String TABLE_NAME = "user_course";
    public static final String COLUMN_USER_COURSE_ID = "user_course_id";
    public static final String COLUMN_USER_COURSE_ACTIVITY_STATE = "user_course_activity_state";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_USER_COURSE_ID)
    private Long id;

    @Column(name = COLUMN_USER_COURSE_ACTIVITY_STATE)
    private Integer userActivityState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Course.COLUMN_COURSE_ID)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = User.COLUMN_USER_ID)
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = COLUMN_USER_COURSE_ID)
    private List<UserCourseLesson> userCourseLessons;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserCourseLesson> getUserCourseLessons() {
        return userCourseLessons;
    }

    public void setUserCourseLessons(List<UserCourseLesson> userCourseLesson) {
        this.userCourseLessons = userCourseLesson;
    }

    public Integer getUserActivityState() {
        return userActivityState;
    }

    public void setUserActivityState(Integer userActivityState) {
        this.userActivityState = userActivityState;
    }
}
