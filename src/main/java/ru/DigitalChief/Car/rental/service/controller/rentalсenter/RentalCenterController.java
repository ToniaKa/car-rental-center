package ru.DigitalChief.Car.rental.service.controller.rentalсenter;

import org.springframework.web.bind.annotation.*;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterShortDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.UpdateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.service.rentalCenter.RentalCenterService;

import java.util.List;


@RestController
@RequestMapping("/rental-center")
public class RentalCenterController {

    private final RentalCenterService rentalCenterService;

    public RentalCenterController(RentalCenterService rentalCenterService) {
        this.rentalCenterService = rentalCenterService;
    }

    @GetMapping
    public List<RentalCenterShortDto> listCenters() {
        return rentalCenterService.listCenters();
    }

    @GetMapping("/{id}")
    public RentalCenterDto getCenter(@PathVariable(name = "id") Integer id) {
        return rentalCenterService.getCenter(id);
    }

    @PostMapping
    public Integer createCenter(@RequestBody CreateRentalCenterInputDto inputDto) {
        return rentalCenterService.createCenter(inputDto);
    }

    @PutMapping("/{id}")
    public void updateCenter(@RequestBody UpdateRentalCenterInputDto inputDto, @PathVariable(name = "id") Integer id) {
        rentalCenterService.updateCenter(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCenter(@PathVariable Integer id) {
        rentalCenterService.deleteCenter(id);
    }
}
