package pl.sawickiadam.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.services.CarService;
import pl.sawickiadam.carrental.services.UserService;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;


    @GetMapping()
    public List<Car> getCars() {
        return carService.getCars();
    }
    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Car car) {
        carService.saveCar(car);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Car car) {
        Car carToUpdate = carService.getCarById(id);
        carToUpdate.setId(id);
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setMileage(car.getMileage());
        if (carToUpdate.getVIN() != car.getVIN()) {
            carToUpdate.setVIN(car.getVIN());
        }
        carService.saveCar(carToUpdate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("rented")
    public List<Car> getRentedCars() {
        return carService.getRentedCars();
    }
    @GetMapping("notRented")
    public List<Car> getNotRentedCars() {
        return carService.getNotRentedCars();
    }
}
