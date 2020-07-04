package pl.sawickiadam.carrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.repositories.CarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;
    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Car getCarById(Long Id) throws ResourceNotFoundException {
        return carRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long Id) throws ResourceNotFoundException {
        carRepository.deleteById(Id);
    }

    @Override
    public List<Car> getRentedCars() {
        return carRepository.findAllByUserNotNull();
    }

    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findAllByUserIsNull();
    }
}
