package freeplace.lla.model.data.service.global;

import freeplace.lla.model.data.repositories.global.SiteContentRepository;
import freeplace.lla.model.data.service.BasicService;
import freeplace.lla.model.entities.global.SiteContent;

import java.util.List;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
public abstract class SiteContentService
        extends BasicService<SiteContentRepository, SiteContent> {
    abstract List<SiteContent> get();
    abstract List<String> getEnglish();
    abstract List<String> getFrench();
    abstract List<String> getRussian();
}
