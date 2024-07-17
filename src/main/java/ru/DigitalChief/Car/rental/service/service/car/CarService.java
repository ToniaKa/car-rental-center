package ru.DigitalChief.Car.rental.service.service.car;

import ru.DigitalChief.Car.rental.service.controller.car.dto.CarDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CreateCarInputDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.UpdateCarInputDto;

import java.util.List;

public interface CarService {

    List<CarDto> listCars();

    CarDto getCar(Integer id);

    Integer createCar(CreateCarInputDto carDto);

    void updateCar(Integer id, UpdateCarInputDto inputDto);

    void deleteCar(Integer id);
}
