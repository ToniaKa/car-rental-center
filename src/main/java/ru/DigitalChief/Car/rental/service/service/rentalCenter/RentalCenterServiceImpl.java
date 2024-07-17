package ru.DigitalChief.Car.rental.service.service.rentalCenter;

import org.springframework.stereotype.Service;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.RentalCenterShortDto;
import ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto.UpdateRentalCenterInputDto;
import ru.DigitalChief.Car.rental.service.exceptionhandling.CarRentNotFoundException;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenter;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenterRepository;
import ru.DigitalChief.Car.rental.service.validator.RentalCenterValidator;

import java.util.List;

@Service
public class RentalCenterServiceImpl implements RentalCenterService {

    private final RentalCenterRepository repository;
    private final RentalCenterConverter converter;
    private final RentalCenterValidator validator;

    public RentalCenterServiceImpl(RentalCenterRepository repository, RentalCenterConverter converter, RentalCenterValidator validator) {
        this.repository = repository;
        this.converter = converter;
        this.validator = validator;
    }

    @Override
    public List<RentalCenterShortDto> listCenters() {
        return repository.findAll().stream()
                .map(converter::convertToShortDto)
                .toList();
    }

    @Override
    public RentalCenterDto getCenter(Integer id) {
        RentalCenter rentalCenter = repository.findById(id).orElseThrow(() -> new CarRentNotFoundException("Rental Center not found: " + id));
        return converter.convertToDto(rentalCenter);
    }

    @Override
    public Integer createCenter(CreateRentalCenterInputDto inputDto) {
        validator.validateOnCreate(inputDto);
        RentalCenter savedCenter = repository.save(converter.convertToEntity(inputDto));
        return savedCenter.getId();
    }

    @Override
    public void updateCenter(Integer id, UpdateRentalCenterInputDto inputDto) {
        RentalCenter rentalCenterToUpdate = repository.findById(id).orElseThrow(() -> new CarRentNotFoundException("Rental Center not found: " + id));
        rentalCenterToUpdate.setName(inputDto.getName());
        rentalCenterToUpdate.setAddress(inputDto.getAddress());
        repository.save(rentalCenterToUpdate);
    }

    @Override
    public void deleteCenter(Integer id) {
        repository.deleteById(id);
    }
}
