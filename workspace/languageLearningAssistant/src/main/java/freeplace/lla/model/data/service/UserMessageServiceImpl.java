package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.UserMessageRepository;
import freeplace.lla.model.entities.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 27.03.2015.
 */
@Service
public class UserMessageServiceImpl implements UserMessageService<UserMessage>{

    private UserMessageRepository userMessageRepository;

    @Autowired
    public UserMessageServiceImpl(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }

    @Override
    public UserMessage add(UserMessage object) {
        return userMessageRepository.saveAndFlush(object);
    }

    @Override
    public UserMessage update(UserMessage object) {
        return userMessageRepository.saveAndFlush(object);
    }

    @Override
    public void delete(UserMessage object) {
        userMessageRepository.delete(object);
    }

    @Override
    public List<UserMessage> findAll() {
        return userMessageRepository.findAll();
    }

    @Override
    public UserMessage findById(Long id) {
        return userMessageRepository.findOne(id);
    }

    @Override
    public List<UserMessage> findByIsNew(Boolean isNew) {
        return userMessageRepository.findByIsNew(isNew);
    }

    @Override
    public List<UserMessage> findByIsCritical(Boolean isCritical) {
        return userMessageRepository.findByIsCritical(isCritical);
    }

    @Override
    public List<UserMessage> findAllOrderByDateAsc() {
        return userMessageRepository.findAllOrderByDateAsc();
    }

    @Override
    public List<UserMessage> findAllOrderByDateDesc() {
        return userMessageRepository.findAllOrderByDateDesc();
    }
}
