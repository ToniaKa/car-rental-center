package ru.DigitalChief.Car.rental.service.service.car;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CarDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CreateCarInputDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.UpdateCarInputDto;
import ru.DigitalChief.Car.rental.service.exceptionhandling.CarRentNotFoundException;
import ru.DigitalChief.Car.rental.service.repository.car.Car;
import ru.DigitalChief.Car.rental.service.repository.car.CarRepository;
import ru.DigitalChief.Car.rental.service.validator.CarValidator;

import java.util.List;

@Service
@Scope("singleton")
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    private final CarValidator carValidator;

    public CarServiceImpl(CarRepository carRepository,
                          CarConverter carConverter, CarValidator carValidator) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
        this.carValidator = carValidator;
    }

    @Override
    public List<CarDto> listCars() {
        return carRepository.findAll().stream()
                .map(carConverter::toDto)
                .toList();
    }

    @Override
    public CarDto getCar(Integer id) {
        return carRepository.findById(id).map(carConverter::toDto)
                .orElseThrow(() -> new CarRentNotFoundException(String.format("Car with id not found: %s", id)));
    }

    @Override
    public Integer createCar(CreateCarInputDto carDto) {
        carValidator.validateOnCreate(carDto);
        Car toSave = carConverter.toEntity(carDto);
        return carRepository.save(toSave).getId();
    }

    @Override
    public void updateCar(Integer id, UpdateCarInputDto inputDto) {
        Car carToUpdate = carRepository.findById(id).orElseThrow(() -> new CarRentNotFoundException("Car not found: " + id));
        carToUpdate.setBrand(inputDto.getBrand());
        carToUpdate.setModel(inputDto.getModel());
        carToUpdate.setLicensePlate(inputDto.getLicensePlate());
        carRepository.save(carToUpdate);

    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
