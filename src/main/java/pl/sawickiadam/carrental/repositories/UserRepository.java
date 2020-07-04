package pl.sawickiadam.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sawickiadam.carrental.models.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
}
