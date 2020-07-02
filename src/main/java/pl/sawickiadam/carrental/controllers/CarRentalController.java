package pl.sawickiadam.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.services.CarService;
import pl.sawickiadam.carrental.services.UserService;
import java.util.List;

@RestController
@RequestMapping("/carRental")
public class CarRentalController {
    @Autowired
    CarService carService;
    @Autowired
    UserService userService;

    @GetMapping("/cars")
    public List<Car> findAll() {
        return carService.getCars();
    }
    @GetMapping("/cars/{id}")
    public Car findById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Car car) {
        carService.saveCar(car);
    }
    @PutMapping("/cars/{id}")
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
        carToUpdate.setRenterUserId(car.getRenterUserId());
        carToUpdate.setRentStart(car.getRentStart());
        carToUpdate.setRentEnd(car.getRentEnd());
        carService.saveCar(carToUpdate);
    }
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }
}
