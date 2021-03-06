package freeplace.lla.model.service;

import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.model.data.service.global.LanguageServiceImpl;
import freeplace.lla.model.data.service.global.MetadataServiceImpl;
import freeplace.lla.model.data.service.global.SiteContentServiceImpl;
import freeplace.lla.model.entities.global.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by klymenko.ruslan on 26.03.2015.
 */
@Service
public class WelcomeService {

    @Autowired
    private LanguageServiceImpl languageService;

    @Autowired
    private MetadataServiceImpl metadataService;

    @Autowired
    private SiteContentServiceImpl siteContentService;

    public LanguageServiceImpl getLanguageService() {
        return languageService;
    }

    public void setLanguageService(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    public MetadataServiceImpl getMetadataService() {
        return metadataService;
    }

    public void setUpSession(HttpSession session) {
        if(session.getAttribute(Attributes.SESSION_LANGUAGES) == null) {
            session.setAttribute(Attributes.SESSION_LANGUAGES, getLanguageService().findAll());
            Metadata metadata = getMetadataService().get();
            session.setAttribute(Attributes.SESSION_PROJECT_NAME, metadata.getProjectName());
            session.setAttribute(Attributes.SESSION_AUTHOR_NAME, metadata.getAuthorName());
            session.setAttribute(Attributes.SESSION_SITE_CONTENT, siteContentService.getEnglish());
        }
    }

    public SiteContentServiceImpl getSiteContentService() {
        return siteContentService;
    }

    public void setSiteContentService(SiteContentServiceImpl siteContentService) {
        this.siteContentService = siteContentService;
    }
}
