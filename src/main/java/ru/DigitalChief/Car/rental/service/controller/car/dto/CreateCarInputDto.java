package ru.DigitalChief.Car.rental.service.controller.car.dto;


import java.util.Objects;

public class CreateCarInputDto {

    private String brand;
    private String model;
    private Integer rentalCenterId;
    private String licensePlate;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getRentalCenterId() {
        return rentalCenterId;
    }

    public void setRentalCenterId(Integer rentalCenterId) {
        this.rentalCenterId = rentalCenterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCarInputDto that = (CreateCarInputDto) o;
        return Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(rentalCenterId, that.rentalCenterId) && Objects.equals(licensePlate, that.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, rentalCenterId, licensePlate);
    }
}
