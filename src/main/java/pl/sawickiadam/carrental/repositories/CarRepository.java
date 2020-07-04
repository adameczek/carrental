package pl.sawickiadam.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sawickiadam.carrental.models.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
    List<Car> findAllByUserNotNull();
    List<Car> findAllByUserIsNull();
}
