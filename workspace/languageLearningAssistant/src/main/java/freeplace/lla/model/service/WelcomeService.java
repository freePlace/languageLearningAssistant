package freeplace.lla.model.service;

import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.model.data.service.LanguageServiceImpl;
import freeplace.lla.model.data.service.MetadataServiceImpl;
import freeplace.lla.model.entities.Metadata;
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
        }
    }
}
