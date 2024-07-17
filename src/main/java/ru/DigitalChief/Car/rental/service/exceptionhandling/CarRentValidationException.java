package ru.DigitalChief.Car.rental.service.exceptionhandling;

import java.util.List;

public class CarRentValidationException extends RuntimeException {

    private final List<String> violations;

    public CarRentValidationException(String message, List<String> violations) {
        super(message);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

    @Override
    public String toString() {
        return getMessage() + " : " +
                "violations=" + violations;
    }
}
