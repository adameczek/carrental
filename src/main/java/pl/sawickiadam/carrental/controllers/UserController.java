package pl.sawickiadam.carrental.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.models.User;
import pl.sawickiadam.carrental.services.CarService;
import pl.sawickiadam.carrental.services.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveUSer(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        User userToUpdate = userService.getUserById(id);
        userToUpdate.setId(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());

        return userService.saveUser(userToUpdate);
    }
    @GetMapping("/{id}/car")
    public Car getUserCar(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return user.getCar();
    }
    @PutMapping("/{id}/rent/{carId}")
    @ResponseStatus(HttpStatus.OK)
    public void rentCar(@PathVariable("id") Long userId, @PathVariable("carId") Long carId) throws ResponseStatusException {
        User user = userService.getUserById(userId);
        Car car = carService.getCarById(carId);
        if (car.getUser() != null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        user.setCar(car);
        userService.saveUser(user);
    }
    @PutMapping("/{id}/endRenting")
    @ResponseStatus(HttpStatus.OK)
    public void stopRenting(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        user.setCar(null);
        userService.saveUser(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
