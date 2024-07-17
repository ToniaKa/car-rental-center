package ru.DigitalChief.Car.rental.service.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.exceptionhandling.CarRentValidationException;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenterRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalCenterValidator {
    private final RentalCenterRepository rentalCenterRepository;

    public RentalCenterValidator(RentalCenterRepository rentalCenterRepository) {
        this.rentalCenterRepository = rentalCenterRepository;
    }

    public void validateOnCreate(CreateRentalCenterInputDto input) {
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(input.getName())) {
            errors.add("Name is blank");
        }
        if (StringUtils.isBlank(input.getAddress())) {
            errors.add("Address is blank");
        }

        if (!errors.isEmpty()) {
            throw new CarRentValidationException("Car data is invalid ", errors);
        }
    }
}
