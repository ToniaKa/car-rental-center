package ru.DigitalChief.Car.rental.service.exceptionhandling;

public class CarRentNotFoundException extends RuntimeException {
    public CarRentNotFoundException(String message) {
        super(message);
    }
}
