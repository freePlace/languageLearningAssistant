package freeplace.lla.model.data.service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public interface UserAccountService<UserAccount> extends BasicService<UserAccount> {
    List<UserAccount> findByIsEnabled(Boolean isEnabled);
    List<UserAccount> findByIsExpired(Boolean isExpired);
    List<UserAccount> findByIsExpiredCredentials(Boolean isExpiredCredentials);
    List<UserAccount> findByIsLocked(Boolean isLocked);
}
