package practise2025.circuit_breaker;

public class CircuitBreakException extends Exception {
    public CircuitBreakException(String message) {
        super(message);
    }
}
