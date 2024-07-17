package ru.DigitalChief.Car.rental.service.repository.car;


import jakarta.persistence.*;
import ru.DigitalChief.Car.rental.service.repository.rentalcenter.RentalCenter;


@Entity
@Table(name = "car", schema = "car_rent")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_gen")
    @SequenceGenerator(name = "car_id_gen", sequenceName = "car_id_seq", schema = "car_rent", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_center_id")
    private RentalCenter rentalCenter;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;


    @Column(name = "license_plate")
    private String licensePlate;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Car(
            RentalCenter rentalCenter,
            String brand, String model,
            String licensePlate
    ) {
        this.rentalCenter = rentalCenter;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RentalCenter getRentalCenter() {
        return rentalCenter;
    }

    public void setRentalCenter(RentalCenter rentalCenter) {
        this.rentalCenter = rentalCenter;
    }

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
}
