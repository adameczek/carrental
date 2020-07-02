package pl.sawickiadam.carrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import pl.sawickiadam.carrental.models.User;
import pl.sawickiadam.carrental.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserById(Long Id) throws ResourceNotFoundException {
        return userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public User getUserByEmail(String email) throws ResourceNotFoundException {
        try {
            return userRepository.findByEmail(email);
        } catch (ResourceNotFoundException e) {
            System.out.println("User with that email not found");
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws ResourceNotFoundException {
        userRepository.deleteById(id);
    }
}