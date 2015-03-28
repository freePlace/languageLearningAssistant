package freeplace.lla.controllers;

import freeplace.lla.controllers.constants.Attributes;
import freeplace.lla.controllers.constants.Pathes;
import freeplace.lla.model.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
@Controller
@RequestMapping(Pathes.SLASH)
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getWelcomePage(ModelMap model,
                                 @RequestParam(value = Attributes.ERROR, required=false) String error,
                                 HttpSession session) {
        welcomeService.setUpSession(session);
        model.addAttribute(Attributes.ERROR, error);
        return Pathes.LOGIN;
    }
}