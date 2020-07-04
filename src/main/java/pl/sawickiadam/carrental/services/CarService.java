package pl.sawickiadam.carrental.services;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pl.sawickiadam.carrental.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getCarById(Long Id) throws ResourceNotFoundException;
    Car saveCar(Car car);
    void deleteCar(Long Id) throws ResourceNotFoundException;
    List<Car> getRentedCars();
    List<Car> getAvailableCars();
}
