package ru.DigitalChief.Car.rental.service.service.car;

import org.springframework.stereotype.Component;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CarDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CreateCarInputDto;
import ru.DigitalChief.Car.rental.service.repository.car.Car;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenter;

@Component
public class CarConverter {

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setModel(car.getModel());
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setRentalCenterId(car.getRentalCenter().getId());
        return carDto;
    }

    public Car toEntity(CreateCarInputDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setLicensePlate(carDto.getLicensePlate());
        car.setRentalCenter(new RentalCenter(carDto.getRentalCenterId()));
        return car;
    }

}
