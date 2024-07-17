package ru.DigitalChief.Car.rental.service.controller.rentalсenter.dto;

public class RentalCenterShortDto {

    private Integer id;
    private String name;
    private String address;

    public RentalCenterShortDto(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
