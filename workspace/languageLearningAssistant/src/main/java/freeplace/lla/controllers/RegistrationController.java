package freeplace.lla.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.controllers.constants.Messages;
import freeplace.lla.controllers.constants.Pathes;
import freeplace.lla.model.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import freeplace.lla.model.springforms.User;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    
    @RequestMapping(value= Pathes.SLASH + Pathes.REGISTRATION, method = RequestMethod.GET)
    public String getRegistrationPage(ModelMap model, HttpSession session) {
        model.addAttribute(Attributes.SESSION_LANGUAGES, session.getAttribute(Attributes.SESSION_LANGUAGES));
        model.addAttribute(Attributes.USER, new User());
        return Pathes.REGISTRATION;
    }
    
    @RequestMapping(value=Pathes.SLASH + Pathes.REGISTER_USER, method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return Pathes.REGISTRATION;
        }
        if(!user.getPassword().equals(user.getRepeatedPassword())) {
            model.addAttribute(Attributes.MESSAGE, Messages.PASSWORDS_NOT_EQUALS);
            return Pathes.REGISTRATION;
        }
        registrationService.createNewUserWithAccount(user);
        model.addAttribute(Attributes.MESSAGE,Messages.USER_WAS_CREATED);
        return Pathes.LOGIN;
    }
    

}
