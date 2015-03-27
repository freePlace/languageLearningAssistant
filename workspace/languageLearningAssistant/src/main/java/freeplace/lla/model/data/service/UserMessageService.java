package freeplace.lla.model.data.service;

import freeplace.lla.model.entities.UserMessage;

import java.util.List;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
public interface UserMessageService<UserMessage> extends BasicService<UserMessage> {

    List<UserMessage> findByIsNew(Boolean isNew);
    List<UserMessage> findByIsCritical(Boolean isCritical);
    List<UserMessage> findAllOrderByDateAsc();
    List<UserMessage> findAllOrderByDateDesc();

}
