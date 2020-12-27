package edu.northeastern.cs5500.delivery.model.Driver;

import lombok.Data;

@Data
public class Car {
    private String make;
    private String model;
    private String licensePlateNumber;

    public Car(String make, String model, String licensePlateNumber) {
        this.make = make;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
    }
}
