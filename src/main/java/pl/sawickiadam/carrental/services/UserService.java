package pl.sawickiadam.carrental.services;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pl.sawickiadam.carrental.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long Id) throws ResourceNotFoundException;
    User getUserByEmail(String email) throws ResourceNotFoundException;
    User saveUser(User user);
    void deleteUser(Long id) throws ResourceNotFoundException;
}
