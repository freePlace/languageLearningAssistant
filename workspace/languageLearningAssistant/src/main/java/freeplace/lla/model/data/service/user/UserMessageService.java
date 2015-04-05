package freeplace.lla.model.data.service.user;

import freeplace.lla.model.data.repositories.user.UserMessageRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.UserMessage;

import java.util.List;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
public abstract class UserMessageService
        extends BasicService<UserMessageRepository, UserMessage> {

    abstract List<UserMessage> findByIsNew(Boolean isNew);
    abstract List<UserMessage> findByIsCritical(Boolean isCritical);
    abstract List<UserMessage> findAllOrderByDateAsc();
    abstract List<UserMessage> findAllOrderByDateDesc();
    abstract List<UserMessage> findByRecipient(User user);

}
