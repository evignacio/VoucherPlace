package org.techchallenge.resource.v1.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.techchallenge.gestaocontas.domain.exception.ApplicationException;
import org.techchallenge.gestaocontas.domain.exception.ExceptionType;
import org.techchallenge.resource.v1.response.Resposta;

import java.util.Iterator;
import java.util.List;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Resposta> handle(MethodArgumentNotValidException ex) {
        var mensagemDeErro = new StringBuilder();
        Iterator<FieldError> fieldErrors = ex.getFieldErrors().iterator();

        while (fieldErrors.hasNext()) {
            FieldError field = fieldErrors.next();
            mensagemDeErro.append(field.getField())
                    .append(": ")
                    .append(field.getDefaultMessage());

            if (fieldErrors.hasNext())
                mensagemDeErro.append(", ");
        }

        return new ResponseEntity<>(
                Resposta.criar(ExceptionType.VALIDATION.getCodigo(), mensagemDeErro.toString()),
                HttpStatus.BAD_REQUEST
        );
    }


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

