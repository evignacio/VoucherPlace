package org.techchallenge.shared.exception;

public enum ExceptionType {
    BUSINESS(-1),
    VALIDATION(-2),
    INFRASTRUCTURE(-99);

    private final int codigo;

    ExceptionType(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
