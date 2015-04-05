package freeplace.lla.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.controllers.constants.Parameters;
import freeplace.lla.controllers.constants.Pathes;
import freeplace.lla.model.entities.user.UserMessage;
import freeplace.lla.model.service.MainService;
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

/** Controller for redirecting to main page
 * @author unnamedproj
 */
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    /**
     * method for redirecting to main page
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value= Pathes.SLASH + Pathes.MAIN, method = RequestMethod.GET)
    public final String getMainPage(final ModelMap model, HttpSession session) {

       model.addAttribute(Attributes.COMMENTS, mainService.findAllComments());
       String login = SecurityContextHolder.getContext().getAuthentication().getName();
       session.setAttribute(Attributes.SESSION_USER, mainService.findUserByLogin(login));
       return Pathes.MAIN;
    }

    @RequestMapping(Pathes.MAIN + Pathes.SLASH + Pathes.GET_MESSAGES)
    @ResponseBody
    public HttpEntity<Message> getMessages(HttpSession session) {
        List<UserMessage> userMessages = mainService.getByRecipient((freeplace.lla.model.entities.user.User) session.getAttribute(Attributes.USER));
        Map<String, Map<String, String>> obj=new LinkedHashMap<>();
        for(int i = 0; i < userMessages.size(); i++) {
            UserMessage userMessage = userMessages.get(i);
            Map<String, String> current = new LinkedHashMap<>();
            current.put("date", userMessage.getDate().toString());
            current.put("text", userMessage.getText());
            current.put("author", userMessage.getAuthor().getLogin());
            obj.put("message" + i, current);
        }
        Message message = new Message(JSONValue.toJSONString(obj));
        message.add(linkTo(methodOn(MainController.class).getMessages(session)).withSelfRel());

        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @RequestMapping(Pathes.MAIN + Pathes.SLASH + Pathes.USER_PROFILE_INFO)
    @ResponseBody
    public HttpEntity<User> userProfileInfo(HttpSession session) {
        freeplace.lla.model.entities.user.User userModel = (freeplace.lla.model.entities.user.User)session.getAttribute(Attributes.USER);
        Map<String, String> obj=new LinkedHashMap<>();
        obj.put( freeplace.lla.model.entities.user.User.NAME,userModel.getName());
        obj.put( freeplace.lla.model.entities.user.User.LAST_NAME,userModel.getLastName());
        obj.put( freeplace.lla.model.entities.user.User.EMAIL,userModel.getEmail());
        obj.put( freeplace.lla.model.entities.user.User.LOGIN,userModel.getLogin());
        //Hibernate.initialize(userModel.getRole());
        obj.put( freeplace.lla.model.entities.user.User.ROLE_NAME,userModel.getRole().getName());
        User user = new User(JSONValue.toJSONString(obj));
        user.add(linkTo(methodOn(MainController.class).userProfileInfo(session)).withSelfRel());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(Pathes.MAIN + Pathes.SLASH + Pathes.ADD_COMMENT)
    @ResponseBody
    public ResponseEntity<Comment> addComment(HttpServletRequest request, HttpSession session) {
        String message = request.getParameter(Attributes.COMMENT_MESSAGE);
        freeplace.lla.model.entities.user.User user = (freeplace.lla.model.entities.user.User)session.getAttribute(Attributes.USER);
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        freeplace.lla.model.entities.user.Comment comment = new freeplace.lla.model.entities.user.Comment();
        comment.setUser(user);
        comment.setMessage(message);
        comment.setDate(now);

        mainService.addComment(comment);

        Map<String, String> obj=new LinkedHashMap<>();
        obj.put(freeplace.lla.model.entities.user.User.LOGIN, user.getLogin());
        obj.put(Attributes.COMMENT_MESSAGE, message);
        obj.put(Attributes.TIME, SimpleDateFormat.getInstance().format(new java.util.Date(now.getTime())));
        Comment resultComment = new Comment(JSONValue.toJSONString(obj));
        resultComment.add(linkTo(methodOn(MainController.class).addComment(request, session)).withSelfRel());

        return new ResponseEntity<Comment>(resultComment, HttpStatus.OK);
    }

    @RequestMapping(value= Pathes.CHANGE_LANGUAGE, method = RequestMethod.GET)
    public final String getMainPage(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
        String language = request.getParameter(Parameters.LANGUAGE);
        session.setAttribute(Attributes.SESSION_SITE_CONTENT, mainService.getSiteContentForLanguage(language));

        String fullUrl = request.getRequestURL().toString();
        String returnUrl = "redirect:" + fullUrl.replace("changeLanguage","");

        return returnUrl;
    }
}