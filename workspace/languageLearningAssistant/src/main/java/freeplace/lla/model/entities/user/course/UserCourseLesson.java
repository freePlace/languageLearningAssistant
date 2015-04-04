package freeplace.lla.model.entities.user.course;

import freeplace.lla.model.entities.course.CourseLesson;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 01.04.2015.
 */
@Entity
@Table(name = UserCourseLesson.TABLE_NAME)
public class UserCourseLesson {

    public static final String TABLE_NAME = "user_course_lesson";
    public static final String COLUMN_USER_COURSE_LESSON_ID = "user_course_lesson_id";
    public static final String COLUMN_USER_COURSE_LESSON_ACTIVITY_STATE = "user_course_lesson_activity_state";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_USER_COURSE_LESSON_ID)
    private Long id;

    @Column(name = COLUMN_USER_COURSE_LESSON_ACTIVITY_STATE)
    private Integer userActivityState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = UserCourse.COLUMN_USER_COURSE_ID)
    private UserCourse userCourse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = CourseLesson.COLUMN_COURSE_LESSON_ID)
    private CourseLesson courseLesson;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCourse getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(UserCourse userCourse) {
        this.userCourse = userCourse;
    }

    public CourseLesson getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(CourseLesson courseLesson) {
        this.courseLesson = courseLesson;
    }

    public Integer getUserActivityState() {
        return userActivityState;
    }

    public void setUserActivityState(Integer userActivityState) {
        this.userActivityState = userActivityState;
    }
}
