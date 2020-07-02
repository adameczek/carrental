package pl.sawickiadam.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sawickiadam.carrental.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
