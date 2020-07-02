package pl.sawickiadam.carrental.services;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pl.sawickiadam.carrental.models.User;

public interface UserService {
    public User getUserById(Long Id) throws ResourceNotFoundException;
    public User getUserByEmail(String email) throws ResourceNotFoundException;
    public void saveUser(User user);
    public void deleteUser(Long id) throws ResourceNotFoundException;
}
