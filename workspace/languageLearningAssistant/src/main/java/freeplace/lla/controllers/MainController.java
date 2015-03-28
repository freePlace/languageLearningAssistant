package freeplace.lla.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.controllers.constants.Parameters;
import freeplace.lla.controllers.constants.Pathes;
import freeplace.lla.model.constants.Languages;
import freeplace.lla.model.data.service.SiteContentServiceImpl;
import freeplace.lla.model.data.service.UserMessageServiceImpl;
import freeplace.lla.model.entities.SiteContent;
import freeplace.lla.model.entities.UserMessage;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import freeplace.lla.model.data.service.CommentServiceImpl;
import freeplace.lla.model.data.service.UserServiceImpl;

/** Controller for redirecting to main page
 * @author unnamedproj
 */
@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserMessageServiceImpl userMessageService;

    @Autowired
    private SiteContentServiceImpl siteContentService;

    /**
     * method for redirecting to main page
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value= Pathes.SLASH + Pathes.MAIN, method = RequestMethod.GET)
    public final String getMainPage(final ModelMap model, HttpSession session) {
       model.addAttribute(Attributes.COMMENTS, commentService.findAll());
       return Pathes.MAIN;
    }

    @RequestMapping(Pathes.MAIN + Pathes.SLASH + Pathes.USER_PROFILE_INFO)
    @ResponseBody
    public HttpEntity<User> userProfileInfo() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        freeplace.lla.model.entities.User userModel = userService.findByLogin(login, true);
        Map<String, String> obj=new LinkedHashMap<>();
        obj.put( freeplace.lla.model.entities.User.NAME,userModel.getName());
        obj.put( freeplace.lla.model.entities.User.LAST_NAME,userModel.getLastName());
        obj.put( freeplace.lla.model.entities.User.EMAIL,userModel.getEmail());
        obj.put( freeplace.lla.model.entities.User.LOGIN,userModel.getLogin());
        //Hibernate.initialize(userModel.getRole());
        obj.put( freeplace.lla.model.entities.User.ROLE_NAME,userModel.getRole().getName());
        User user = new User(JSONValue.toJSONString(obj));
        user.add(linkTo(methodOn(MainController.class).userProfileInfo()).withSelfRel());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(Pathes.MAIN + Pathes.SLASH + Pathes.ADD_COMMENT)
    @ResponseBody
    public ResponseEntity<Comment> addComment(HttpServletRequest request) {
        String message = request.getParameter(Attributes.COMMENT_MESSAGE);
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        freeplace.lla.model.entities.User user = userService.findByLogin(login, true);
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        freeplace.lla.model.entities.Comment comment = new freeplace.lla.model.entities.Comment();
        comment.setUser(user);
        comment.setMessage(message);
        comment.setDate(now);
        commentService.add(comment);
        Map<String, String> obj=new LinkedHashMap<>();
        obj.put(freeplace.lla.model.entities.User.LOGIN, user.getLogin());
        obj.put(Attributes.COMMENT_MESSAGE, message);
        obj.put(Attributes.TIME, SimpleDateFormat.getInstance().format(new java.util.Date(now.getTime())));
        Comment resultComment = new Comment(JSONValue.toJSONString(obj));
        resultComment.add(linkTo(methodOn(MainController.class).addComment(request)).withSelfRel());

        return new ResponseEntity<Comment>(resultComment, HttpStatus.OK);
    }

    @RequestMapping(value= Pathes.CHANGE_LANGUAGE, method = RequestMethod.GET)
    public final String getMainPage(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
        String language = URLEncoder.encode(request.getParameter(Parameters.LANGUAGE), "UTF-8");
        List<String> siteContent = null;
        if(language.equals(Languages.English.name())) {
            siteContent = siteContentService.getEnglish();
        } else if(language.equals(Languages.French.name())) {
            siteContent = siteContentService.getFrench();
        } else  if(language.equals(Languages.Russian.name())) {
            siteContent = siteContentService.getRussian();
        } else {
            // unknown lang. by default: eng
            siteContent = siteContentService.getEnglish();
        }
        session.setAttribute(Attributes.SESSION_SITE_CONTENT, siteContent);
        String fullUrl = request.getRequestURL().toString();
        String returnUrl = "redirect:" + fullUrl.replace("changeLanguage","");

        return returnUrl;
    }
}
