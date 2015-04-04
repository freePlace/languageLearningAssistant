package freeplace.lla.model.entities.user;

import java.util.List;

import javax.persistence.*;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import freeplace.lla.model.entities.global.Language;
import freeplace.lla.model.entities.user.course.UserCourse;


@Entity
@Table(name=User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_LAST_NAME = "last_name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_LOGIN = "login";
    public static final String COLUMN_USER_PASSWORD = "password";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_USER_ID)
    private Long id;
   
    @Column(name=COLUMN_USER_NAME)
    private String name;
    
    @Column(name=COLUMN_USER_LAST_NAME)
    private String lastName;
    
    @Column(name=COLUMN_USER_EMAIL, unique=true)
    private String email;

    @Column(name=COLUMN_USER_LOGIN, unique=true)
    private String login;
    
    @Column(name=COLUMN_USER_PASSWORD, unique=true)
    private String password;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= Language.COLUMN_LANGUAGE_ID, nullable = false)
    private Language nativeLanguage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name=User.COLUMN_USER_ID)
    private List<Comment> comments;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Role.COLUMN_ROLE_ID, nullable = false)
    private Role role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = UserAccount.COLUMN_USER_ACCOUNT_ID)
    private UserAccount userAccount;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_sent")
    private List<UserMessage> sentMessages;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_recieved")
    private List<UserMessage> recievedMessages;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = COLUMN_USER_ID)
    private List<UserCourse> userCourses;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAccount getUserAccount() { return userAccount; }

    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount;    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("name", name)
                .add("lastName", lastName)
                .add("email", email)
                .add("login", login)
                .add("password", password)
                .add("role", role)
                .omitNullValues()
                .toString();
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {  
           return false;  
        }  
        if (getClass() != object.getClass()) {  
           return false;  
        }  
        final User other = (User) object;  
        return   Objects.equal(this.name, other.name)  
              && Objects.equal(this.lastName, other.lastName)  
              && Objects.equal(this.email, other.email)  
              && Objects.equal(this.login, other.login)
              && Objects.equal(this.password, other.password)
              && Objects.equal(this.role, other.role); 
    }
    
    @Override  
    public int hashCode() {  
       return Objects.hashCode(  
                 this.name, this.lastName, this.email, this.login, this.password, this.role);  
    }

    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String ROLE_NAME = "role";

    public Language getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(Language nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public List<UserMessage> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<UserMessage> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<UserMessage> getRecievedMessages() {
        return recievedMessages;
    }

    public void setRecievedMessages(List<UserMessage> recievedMessages) {
        this.recievedMessages = recievedMessages;
    }

    public List<UserCourse> getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(List<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }
}