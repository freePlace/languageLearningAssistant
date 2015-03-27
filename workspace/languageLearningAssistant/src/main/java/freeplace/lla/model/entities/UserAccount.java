package freeplace.lla.model.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Entity
@Table(name=UserAccount.TABLE_NAME)
public class UserAccount {

    public static final String TABLE_NAME = "user_account";
    public static final String COLUMN_USER_ACCOUNT_ID = "user_account_id";
    public static final String COLUMN_IS_ENABLED = "is_enabled";
    public static final String COLUMN_IS_EXPIRED = "is_expired";
    public static final String COLUMN_IS_EXPIRED_CREDENTIALS = "is_expired_credentials";
    public static final String COLUMN_IS_LOCKED = "is_locked";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name=COLUMN_USER_ACCOUNT_ID)
    private Long id;

    @Column(name=COLUMN_IS_ENABLED)
    private Boolean isEnabled;

    @Column(name=COLUMN_IS_EXPIRED)
    private Boolean isExpired;

    @Column(name=COLUMN_IS_EXPIRED_CREDENTIALS)
    private Boolean isExpiredCredentials;

    @Column(name=COLUMN_IS_LOCKED)
    private Boolean isLocked;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = User.COLUMN_USER_ID)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Boolean getIsExpiredCredentials() {
        return isExpiredCredentials;
    }

    public void setIsExpiredCredentials(Boolean isExpiredCredentials) {
        this.isExpiredCredentials = isExpiredCredentials;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("isEnabled", isEnabled)
                .add("isExpired", isExpired)
                .add("isExpiredCredentials", isExpiredCredentials)
                .add("isLocked", isLocked)
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
        final UserAccount other = (UserAccount) object;
        return   Objects.equal(this.isEnabled, other.isEnabled)
                && Objects.equal(this.isExpired, other.isExpired)
                && Objects.equal(this.isExpiredCredentials, other.isExpiredCredentials)
                && Objects.equal(this.isLocked, other.isLocked);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.isEnabled, this.isExpired,
                this.isExpiredCredentials, this.isLocked);
    }
}
