package freeplace.lla.controllers;

import freeplace.lla.controllers.constants.Pathes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by klymenko.ruslan on 28.03.2015.
 */
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception ex) {
        return Pathes.PAGE_NOT_FOUND;
    }
}