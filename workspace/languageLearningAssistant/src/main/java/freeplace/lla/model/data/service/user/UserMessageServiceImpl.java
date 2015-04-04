package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.UserMessageRepository;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
@Service
public class UserMessageServiceImpl extends UserMessageService {

    @Autowired
    public UserMessageServiceImpl(UserMessageRepository userMessageRepository) {
        this.jpaRepository = userMessageRepository;
    }

    @Override
    public List<UserMessage> findByIsNew(Boolean isNew) {
        return ((UserMessageRepository)jpaRepository).findByIsNew(isNew);
    }

    @Override
    public List<UserMessage> findByIsCritical(Boolean isCritical) {
        return ((UserMessageRepository)jpaRepository).findByIsCritical(isCritical);
    }

    @Override
    public List<UserMessage> findAllOrderByDateAsc() {
        return ((UserMessageRepository)jpaRepository).findAllOrderByDateAsc();
    }

    @Override
    public List<UserMessage> findAllOrderByDateDesc() {
        return ((UserMessageRepository)jpaRepository).findAllOrderByDateDesc();
    }

    @Override
    public List<UserMessage> findByRecipient(User user) {
        return ((UserMessageRepository)jpaRepository).findByRecipient(user);
    }
}
