package freeplace.lla.model.service;

import freeplace.lla.model.constants.Languages;
import freeplace.lla.model.data.service.user.CommentServiceImpl;
import freeplace.lla.model.data.service.global.SiteContentServiceImpl;
import freeplace.lla.model.data.service.user.UserMessageServiceImpl;
import freeplace.lla.model.data.service.user.UserServiceImpl;
import freeplace.lla.model.entities.user.Comment;
import freeplace.lla.model.entities.user.User;
import freeplace.lla.model.entities.user.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
@Service
public class MainService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserMessageServiceImpl userMessageService;

    @Autowired
    private SiteContentServiceImpl siteContentService;

    private HashMap<String, List<String>> siteContent;

    public List<Comment> findAllComments() {
        return commentService.findAll();
    }

    public User findUserByLogin(String login) {
        return userService.findByLogin(login, true);
    }

    public void addComment(Comment comment) {
        commentService.add(comment);
    }

    public List<String> getSiteContentForLanguage(String language) {
        List<String> siteContent = getSiteContentForLanguages().get(language);
        if(siteContent == null) {
            siteContent = getSiteContentForLanguages().get(Languages.English.name());
        }
        return siteContent;
    }

    public Map<String, List<String>> getSiteContentForLanguages() {
        if(siteContent == null) {
            siteContent = new HashMap<String, List<String>>();
            siteContent.put(Languages.English.name(), siteContentService.getEnglish());
            siteContent.put(Languages.French.name(), siteContentService.getFrench());
            siteContent.put(Languages.Russian.name(), siteContentService.getRussian());
        }

        return siteContent;
    }

    public List<UserMessage> getByRecipient(User user) {
        return userMessageService.findByRecipient(user);
    }
}
