package ru.DigitalChief.Car.rental.service.service.rentalCenter;

import org.springframework.stereotype.Component;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterShortDto;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenter;
import ru.DigitalChief.Car.rental.service.service.car.CarConverter;

@Component
public class RentalCenterConverter {

    private final CarConverter carConverter;

    public RentalCenterConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }

    public RentalCenter convertToEntity(CreateRentalCenterInputDto inputDto) {
        return new RentalCenter(inputDto.getName(), inputDto.getAddress());
    }

    public RentalCenterShortDto convertToShortDto(RentalCenter rentalCenter) {
        return new RentalCenterShortDto(rentalCenter.getId(), rentalCenter.getName(), rentalCenter.getAddress());
    }

    public RentalCenterDto convertToDto(RentalCenter rentalCenter) {
        RentalCenterDto result = new RentalCenterDto();
        result.setId(rentalCenter.getId());
        result.setAddress(rentalCenter.getAddress());
        result.setName(rentalCenter.getName());

        result.setCars(rentalCenter.getCars().stream()
                .map(carConverter::toDto)
                .toList());
        return result;
    }
}
