package ru.DigitalChief.Car.rental.service.controller.car;

import org.springframework.web.bind.annotation.*;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CarDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.CreateCarInputDto;
import ru.DigitalChief.Car.rental.service.controller.car.dto.UpdateCarInputDto;
import ru.DigitalChief.Car.rental.service.service.car.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> listCars() {
        return carService.listCars();
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable Integer id) {
        return carService.getCar(id);
    }

    @PostMapping
    public Integer createCar(@RequestBody CreateCarInputDto createCarInputDto) {
        return carService.createCar(createCarInputDto);
    }

    @PutMapping("/{id}")
    public void updateCar(@RequestBody UpdateCarInputDto inputDto, @PathVariable(name = "id") Integer id) {
        carService.updateCar(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
    }
}
