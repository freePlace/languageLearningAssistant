package freeplace.lla.model.data.service;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public interface LanguageService<Language> extends BasicService<Language> {
    Language findById(Long id);
    Language findByName(String name);
}
