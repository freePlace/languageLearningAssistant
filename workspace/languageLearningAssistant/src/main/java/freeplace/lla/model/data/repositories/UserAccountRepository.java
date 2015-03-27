package freeplace.lla.model.data.repositories;

import freeplace.lla.model.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public static final String FIND_USER_ACCOUNT_IS_ENABLED = "select ua from UserAccount ua where ua.isEnabled = :isEnabled";
    public static final String FIND_USER_ACCOUNT_IS_EXPIRED = "select ua from UserAccount ua where ua.isExpired = :isExpired";
    public static final String FIND_USER_ACCOUNT_IS_EXPIRED_CREDENTIALS = "select ua from UserAccount ua where ua.isExpiredCredentials = :isExpiredCredentials";
    public static final String FIND_USER_ACCOUNT_IS_LOCKED = "select ua from UserAccount ua where ua.isLocked = :isLocked";

    @Query(FIND_USER_ACCOUNT_IS_ENABLED)
    List<UserAccount> findByIsEnabled(@Param("isEnabled") Boolean isEnabled);

    @Query(FIND_USER_ACCOUNT_IS_EXPIRED)
    List<UserAccount> findByIsExpired(@Param("isExpired") Boolean isExpired);

    @Query(FIND_USER_ACCOUNT_IS_EXPIRED_CREDENTIALS)
    List<UserAccount> findByIsExpiredCredentials(@Param("isExpiredCredentials") Boolean isExpiredCredentials);

    @Query(FIND_USER_ACCOUNT_IS_LOCKED)
    List<UserAccount> findByIsLocked(@Param("isLocked") Boolean isLocked);
}
