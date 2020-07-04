package pl.sawickiadam.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.services.CarService;

import java.net.URI;
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
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{id}")
                                                    .buildAndExpand(savedCar.getId())
                                                    .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car update(@PathVariable("id") Long id, @RequestBody Car car) {
        Car carToUpdate = carService.getCarById(id);
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setMileage(car.getMileage());
        carToUpdate.setVIN(car.getVIN());
        return carService.saveCar(carToUpdate);
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
    @GetMapping("available")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

}
