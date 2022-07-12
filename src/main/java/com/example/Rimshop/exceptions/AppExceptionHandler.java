package com.example.Rimshop.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public ModelAndView fileStorageException(FileStorageException e,
                                             RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        view.addObject("message", e.getMessage());
        view.setViewName("error");
        return view;
    }
}
