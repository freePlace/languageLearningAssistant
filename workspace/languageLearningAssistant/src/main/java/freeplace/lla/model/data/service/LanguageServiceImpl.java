package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.LanguageRepository;
import freeplace.lla.model.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Service
public class LanguageServiceImpl implements LanguageService<Language>{

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language add(Language object) {
        return languageRepository.saveAndFlush(object);
    }

    @Override
    public Language update(Language object) {
        return languageRepository.saveAndFlush(object);
    }

    @Override
    public void delete(Language object) {
        languageRepository.delete(object);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findOne(id);
    }

    @Override
    public Language findByName(String name) {
        return languageRepository.findByName(name);
    }
}
