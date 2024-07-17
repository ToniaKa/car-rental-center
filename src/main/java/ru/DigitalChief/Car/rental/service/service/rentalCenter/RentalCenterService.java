package ru.DigitalChief.Car.rental.service.service.rentalCenter;

import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterShortDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.UpdateRentalCenterInputDto;

import java.util.List;

public interface RentalCenterService {


    List<RentalCenterShortDto> listCenters();

    RentalCenterDto getCenter(Integer id);

    Integer createCenter(CreateRentalCenterInputDto inputDto);

    void updateCenter(Integer id, UpdateRentalCenterInputDto inputDto);

    void deleteCenter(Integer id);
}
