package com.bridgelabz.atmsystem.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose : To implement atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 6-12-2021.
 */

// @ControllerAdvice allows you to handle exceptions across the whole application.
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * @purpose : To handle Method Argument Not Valid.
     *
     * @param ex : ex is used for Method Argument Not Valid Exception.
     * @param headers : headers is used for HTTP headers of the HTTP message are
     *                  collectively known as the head of the requests.
     * @param status : status used to describe HTTP status code is a server response to a browser's request.
     * @param request : request is used to describe web request that is a communicative message,
     *                  that is transmitted between the client or web browsers, to the servers.
     * @return : body, headers and status of response entity.
     */

    @Override
    // error handle for @Valid
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity(body, headers, status);

    }

    /**
     * @purpose : To handle Http Request Method Not Supported Exception.
     *
     * @param ex : ex used for Http Request Method Not Supported Exception.
     * @param headers : headers is used for HTTP headers of the HTTP message are
     *                  collectively known as the head of the requests.
     * @param status : status used to describe HTTP status code is a server response to a browser's request.
     * @param request : request is used to describe web request that is a communicative message,
     *                  that is transmitted between the client or web browsers, to the servers.
     * @return : Please Check http Method Type for the bad request http status.
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Please Check http Method Type", HttpStatus.BAD_REQUEST);
    }

    /**
     * @purpose : To handle Entity Not Found Exception,
     *            In detail A HTML link in the home page calls a controller's method,
     *            which either returns data or throws an exception.
     *
     * @return : Given id is Not Found for the bad request http status.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException() {
        return new ResponseEntity<>("Given id is Not Found", HttpStatus.BAD_REQUEST);
    }
}
