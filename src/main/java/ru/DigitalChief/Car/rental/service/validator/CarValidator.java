package ru.DigitalChief.Car.rental.service.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CreateCarInputDto;
import ru.DigitalChief.Car.rental.service.exceptionhandling.CarRentValidationException;
import ru.DigitalChief.Car.rental.service.repository.car.Car;
import ru.DigitalChief.Car.rental.service.repository.car.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarValidator {
    private final CarRepository carRepository;

    public CarValidator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void validateOnCreate(CreateCarInputDto input) {
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(input.getBrand())) {
            errors.add("Brand is blank");
        }
        if (StringUtils.isBlank(input.getModel())) {
            errors.add("Model is blank");
        }

        List<String> licensePlates = carRepository.findAll().stream()
                .map(Car::getLicensePlate)
                .toList();

        if (licensePlates.contains(input.getLicensePlate())) {
            errors.add("License Plate " + input.getLicensePlate() + " already exists");
        }
        if (!errors.isEmpty()) {
            throw new CarRentValidationException("Car data is invalid ", errors);
        }
    }
}
