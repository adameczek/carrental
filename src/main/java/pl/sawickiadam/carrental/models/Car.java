package pl.sawickiadam.carrental.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false, unique = true)
    private String VIN;
    @Column(nullable = false)
    private int mileage;
    @Column
    private Long renterUserId;
    @Column
    private Date rentStart;
    @Column Date rentEnd;

    public Car() {
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
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
    public String getVIN() {
        return VIN;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public Long getRenterUserId() {
        return renterUserId;
    }
    public void setRenterUserId(Long renterUserId) {
        this.renterUserId = renterUserId;
    }
    public Date getRentStart() {
        return rentStart;
    }
    public void setRentStart(Date rentStart) {
        this.rentStart = rentStart;
    }
    public Date getRentEnd() {
        return rentEnd;
    }
    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }
}
