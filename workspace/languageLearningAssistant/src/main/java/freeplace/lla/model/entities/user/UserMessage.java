package freeplace.lla.model.entities.user;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
@Entity
@Table(name= UserMessage.TABLE_NAME)
public class UserMessage {

    public static final String TABLE_NAME = "user_message";
    public static final String COLUMN_USER_MESSAGE_ID = "user_message_id";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_IS_NEW = "is_new";
    public static final String COLUMN_IS_CRITICAL = "is_critical";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name=COLUMN_USER_MESSAGE_ID)
    private Long id;

    @Column(name= COLUMN_TEXT)
    private String text;

    @Column(name= COLUMN_DATE)
    private Date date;

    @Column(name= COLUMN_IS_NEW)
    private Boolean isNew;

    @Column(name= COLUMN_IS_CRITICAL)
    private Boolean isCritical;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id_sent")
    private User author;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id_recieved")
    private User recipient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsCritical() {
        return isCritical;
    }

    public void setIsCritical(Boolean isCritical) {
        this.isCritical = isCritical;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
