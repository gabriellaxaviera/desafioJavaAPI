package com.gabriellaxavier.desafioconcrete.handler;

import com.gabriellaxavier.desafioconcrete.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.ResourceNotFoundBuilder
                .newBuilder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<?> handleEmailExistsException(EmailExistsException emailExists) {

        ExceptionDetails exceptionDetails = ExceptionDetails.ResourceNotFoundBuilder
                .newBuilder()
                .message(emailExists.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleNotAuthorizedException(UnauthorizedException notAuth){

        ExceptionDetails exceptionDetails = ExceptionDetails.ResourceNotFoundBuilder
                .newBuilder()
                .message(notAuth.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<?> handleMediaType(HttpMediaTypeException media){

        ExceptionDetails exceptionDetails = ExceptionDetails.ResourceNotFoundBuilder
                .newBuilder()
                .message(media.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
