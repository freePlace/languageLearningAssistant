package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.MainMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Service
public class MainMenuItemServiceImpl extends MainMenuItemService {

    @Autowired
    public MainMenuItemServiceImpl(MainMenuItemRepository mainMenuItemRepository) {
        this.jpaRepository = mainMenuItemRepository;
    }
}
