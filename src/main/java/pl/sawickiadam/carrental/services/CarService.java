package pl.sawickiadam.carrental.services;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pl.sawickiadam.carrental.models.Car;

import java.util.List;

public interface CarService {
    public List<Car> getCars();
    public Car getCarById(Long Id) throws ResourceNotFoundException;
    public void saveCar(Car car);
    public void deleteCar(Long Id) throws ResourceNotFoundException;
    public List<Car> getRentedCars();
    public List<Car> getNotRentedCars();
}
