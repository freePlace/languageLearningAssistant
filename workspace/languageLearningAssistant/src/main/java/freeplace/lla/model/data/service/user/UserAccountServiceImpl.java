package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.UserAccountRepository;
import freeplace.lla.model.entities.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Service
public class UserAccountServiceImpl extends UserAccountService {

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.jpaRepository = userAccountRepository;
    }

    @Override
    public List<UserAccount> findByIsEnabled(Boolean isEnabled) {
        return ((UserAccountRepository)jpaRepository).findByIsEnabled(isEnabled);
    }

    @Override
    public List<UserAccount> findByIsExpired(Boolean isExpired) {
        return ((UserAccountRepository)jpaRepository).findByIsExpired(isExpired);
    }

    @Override
    public List<UserAccount> findByIsExpiredCredentials(Boolean isExpiredCredentials) {
        return ((UserAccountRepository)jpaRepository).findByIsExpiredCredentials(isExpiredCredentials);
    }

    @Override
    public List<UserAccount> findByIsLocked(Boolean isLocked) {
        return ((UserAccountRepository)jpaRepository).findByIsLocked(isLocked);
    }
}
