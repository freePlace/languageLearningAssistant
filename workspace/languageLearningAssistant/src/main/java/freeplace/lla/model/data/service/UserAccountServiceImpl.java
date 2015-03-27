package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.UserAccountRepository;
import freeplace.lla.model.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Service
public class UserAccountServiceImpl implements UserAccountService<UserAccount>{

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount add(UserAccount user) {
        return userAccountRepository.saveAndFlush(user);
    }

    @Override
    public UserAccount update(UserAccount user) {
        return userAccountRepository.saveAndFlush(user);
    }

    @Override
    public void delete(UserAccount user) {
        userAccountRepository.delete(user);
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount findById(Long id) {
        return userAccountRepository.findOne(id);
    }

    @Override
    public List<UserAccount> findByIsEnabled(Boolean isEnabled) {
        return userAccountRepository.findByIsEnabled(isEnabled);
    }

    @Override
    public List<UserAccount> findByIsExpired(Boolean isExpired) {
        return userAccountRepository.findByIsExpired(isExpired);
    }

    @Override
    public List<UserAccount> findByIsExpiredCredentials(Boolean isExpiredCredentials) {
        return userAccountRepository.findByIsExpiredCredentials(isExpiredCredentials);
    }

    @Override
    public List<UserAccount> findByIsLocked(Boolean isLocked) {
        return userAccountRepository.findByIsLocked(isLocked);
    }
}
