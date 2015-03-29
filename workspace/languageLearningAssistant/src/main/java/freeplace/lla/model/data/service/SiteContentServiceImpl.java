package freeplace.lla.model.data.service;

import freeplace.lla.model.data.repositories.SiteContentRepository;
import freeplace.lla.model.entities.SiteContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Service
public class SiteContentServiceImpl implements SiteContentService<SiteContent>{

    private SiteContentRepository siteContentRepository;

    @Autowired
    public SiteContentServiceImpl(SiteContentRepository siteContentRepository) {
        this.siteContentRepository = siteContentRepository;
    }

    @Override
    public SiteContent add(SiteContent object) {
        return siteContentRepository.saveAndFlush(object);
    }

    @Override
    public SiteContent update(SiteContent object) {
        return siteContentRepository.saveAndFlush(object);
    }

    @Override
    public void delete(SiteContent object) {
        siteContentRepository.delete(object);
    }

    @Override
    public List<SiteContent> findAll() {
        return siteContentRepository.findAll();
    }

    @Override
    public SiteContent findById(Long id) {
        return siteContentRepository.findOne(id);
    }

    @Override
    public List<SiteContent> get() {
        return siteContentRepository.findAll();
    }

    @Override
    public List<String> getEnglish() {
        return siteContentRepository.findEnglish();
    }

    @Override
    public List<String> getFrench() {
        return siteContentRepository.findFrench();
    }

    @Override
    public List<String> getRussian() {
        return siteContentRepository.findRussian();
    }
}
