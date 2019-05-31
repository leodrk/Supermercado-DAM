package Supermercado.model.exceptions;

public class DineroInsuficienteException extends RuntimeException {
    private Double dineroFaltante;

    public DineroInsuficienteException(Double dinero) {
        dineroFaltante = dinero;
        printStackTrace();
    }

    @Override
    public String getMessage() {
        return "dinero insuficiente. por favor, añadir " + dineroFaltante.toString() + " al monto ya dado";
    }
}
