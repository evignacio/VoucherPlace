package org.techchallenge.web.v1.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.techchallenge.gestaocontas.domain.exception.ApplicationException;
import org.techchallenge.web.v1.response.Resposta;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Resposta> handleApplicationException(ApplicationException exception) {
        var httpStatus = this.getHttpStatus(exception);
        return new ResponseEntity<>(
                Resposta.criar(exception.getExceptionType().getCodigo(), exception.getMessage()),
                httpStatus
        );
    }

    private HttpStatus getHttpStatus(ApplicationException exception) {
        switch (exception.getExceptionType()) {
            case BUSINESS -> {
                return HttpStatus.UNPROCESSABLE_ENTITY;
            }
            case VALIDATION -> {
                return HttpStatus.BAD_REQUEST;
            }
            default -> {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
    }
}

