package pl.sawickiadam.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sawickiadam.carrental.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
