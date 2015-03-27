package freeplace.lla.model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name=Comment.TABLE_NAME)
public class Comment {

    public static final String TABLE_NAME = "comment";
    public static final String COLUMN_COMMENT_ID = "comment_id";
    public static final String COLUMN_MESSAGE = "message";
    public static final String COLUMN_DATE = "date";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_COMMENT_ID)
    private Long id;
    @ManyToOne
    @JoinColumn(name= User.COLUMN_USER_ID, nullable = false)
    private User user;
    @Column(name=COLUMN_MESSAGE)
    private String message;
    @Column(name=COLUMN_DATE)
    private Date date;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDate() {
        return new Date(date.getTime());
    }
    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("user", user)
                .add("message", message)
                .add("date", date)
                .omitNullValues()
                .toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        return Objects.equal(this.getId(), id)
                && Objects.equal(this.getUser(), other.getUser())
                && Objects.equal(this.getMessage(), other.getMessage())
                && Objects.equal(this.getDate(), other.getDate());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id, this.user, this.message, this.date);
    }
}
