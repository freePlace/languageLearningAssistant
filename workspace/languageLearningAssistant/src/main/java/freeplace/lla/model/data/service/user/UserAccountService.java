package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.UserAccountRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.user.UserAccount;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public abstract class UserAccountService
        extends BasicService<UserAccountRepository, UserAccount> {
    abstract List<UserAccount> findByIsEnabled(Boolean isEnabled);
    abstract List<UserAccount> findByIsExpired(Boolean isExpired);
    abstract List<UserAccount> findByIsExpiredCredentials(Boolean isExpiredCredentials);
    abstract List<UserAccount> findByIsLocked(Boolean isLocked);
}
