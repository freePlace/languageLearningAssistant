package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.LanguageRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.global.Language;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public abstract class LanguageService
        extends BasicService<LanguageRepository, Language> {
    abstract Language findByName(String name);
}
