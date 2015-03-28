package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.MainMenuItemRepository;
import freeplace.lla.model.entities.MainMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Service
public class MainMenuItemServiceImpl implements MainMenuItemService<MainMenuItem>{

    private MainMenuItemRepository mainMenuItemRepository;

    @Autowired
    public MainMenuItemServiceImpl(MainMenuItemRepository mainMenuItemRepository) {
        this.mainMenuItemRepository = mainMenuItemRepository;
    }

    @Override
    public MainMenuItem add(MainMenuItem object) {
        return mainMenuItemRepository.saveAndFlush(object);
    }

    @Override
    public MainMenuItem update(MainMenuItem object) {
        return mainMenuItemRepository.saveAndFlush(object);
    }

    @Override
    public void delete(MainMenuItem object) {
        mainMenuItemRepository.delete(object);
    }

    @Override
    public List<MainMenuItem> findAll() {
        return mainMenuItemRepository.findAll();
    }

    @Override
    public MainMenuItem findById(Long id) {
        return mainMenuItemRepository.getOne(id);
    }
}
