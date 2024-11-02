package org.techchallenge.gestaocontas.domain.exception;

public class ApplicationException extends RuntimeException {
    private final ExceptionType exceptionType;

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    private ApplicationException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public static ApplicationException buildBusinessException(String message) {
        return new ApplicationException(ExceptionType.BUSINESS, message);
    }

    public static ApplicationException buildValidationException(String message) {
        return new ApplicationException(ExceptionType.VALIDATION, message);
    }

    public static ApplicationException buildInfrastructureException(String message) {
        return new ApplicationException(ExceptionType.INFRASTRUCTURE, message);
    }
}
