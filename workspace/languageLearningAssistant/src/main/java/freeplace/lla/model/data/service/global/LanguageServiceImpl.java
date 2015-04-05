package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.LanguageRepository;
import freeplace.lla.model.entities.global.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Service
public class LanguageServiceImpl extends LanguageService {

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.jpaRepository = languageRepository;
    }

    @Override
    public Language findByName(String name) {
        return ((LanguageRepository)jpaRepository).findByName(name);
    }
}
