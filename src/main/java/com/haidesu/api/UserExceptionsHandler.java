package com.haidesu.api;

import com.haidesu.exceptions.UserNotFoundException;
import com.haidesu.model.ErrorJson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Writing a controller advice
 * <p>
 * <ul>
 *     <li>Create your own exception classes.</li>
 *     <li>One controller advice class per application.</li>
 *     <li>Write handleException methods per exception and annotate it with @ExceptionHandler
 *     <li>Create a method that sends the response to the user. Handler methods are meant to do the logic to treat a
 *     given exception, then they will call the method that sends the respond.</li>
 * </ul>
 */
@ControllerAdvice
public class UserExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception e, WebRequest webRequest) {
        ErrorJson errorJson = new ErrorJson()
                .code(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage());
        return handleExceptionInternal(e, errorJson, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest webRequest) {
        ErrorJson errorJson = new ErrorJson()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage());
        return handleExceptionInternal(e, errorJson, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }
}
