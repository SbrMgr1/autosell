package com.autosell.controllers;

import com.autosell.ErrorClass.DomainError;
import com.autosell.ErrorClass.DomainErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ControllerAdviceException {

    @Autowired
    MessageSourceAccessor messageAccessor;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DomainErrors handleException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        DomainErrors errors = new DomainErrors();
        errors.setErrorType("ValidationError");

        for (FieldError fieldError : fieldErrors) {
            DomainError error = new DomainError(messageAccessor.getMessage(fieldError));
            errors.addError(error);
        }

        return errors;
    }

}
