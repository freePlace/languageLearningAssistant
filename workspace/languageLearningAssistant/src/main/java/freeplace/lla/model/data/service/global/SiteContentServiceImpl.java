package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.SiteContentRepository;
import freeplace.lla.model.entities.global.SiteContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@Service
public class SiteContentServiceImpl extends SiteContentService {

    @Autowired
    public SiteContentServiceImpl(SiteContentRepository siteContentRepository) {
        this.jpaRepository = siteContentRepository;
    }

    @Override
    public List<SiteContent> get() {
        return ((SiteContentRepository)jpaRepository).findAll();
    }

    @Override
    public List<String> getEnglish() {
        return ((SiteContentRepository)jpaRepository).findEnglish();
    }

    @Override
    public List<String> getFrench() {
        return ((SiteContentRepository)jpaRepository).findFrench();
    }

    @Override
    public List<String> getRussian() {
        return ((SiteContentRepository)jpaRepository).findRussian();
    }
}
