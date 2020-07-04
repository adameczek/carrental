package pl.sawickiadam.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sawickiadam.carrental.models.Car;
import pl.sawickiadam.carrental.models.User;
import pl.sawickiadam.carrental.services.CarService;
import pl.sawickiadam.carrental.services.UserService;

@Controller
public class InitController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;
    @GetMapping("/init")
    public String init() {
        Car car1 = new Car("Ford", "Focus", "YV1MW837120", 25000);
        Car car2 = new Car("Volvo", "V50", "MW0D12938DAS", 152921);
        Car car3 = new Car("Fiat", "500", "F1029DASDAP2", 199324);
        Car car4 = new Car("Toyota", "Auris", "T0Y0T48231", 99999);
        carService.saveCar(car1);
        carService.saveCar(car2);
        carService.saveCar(car3);
        carService.saveCar(car4);
        User user1 = new User("Adam Sawicki", "haslo", "adam2sawicki@gmail.com", car1);
        User user2 = new User("Jan Kowalski", "p4ssw0rd", "janKowalski@wp.pl");
        User user3 = new User("Marcin Nowak", "marcin1234", "marcinek@o2.pl");
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        return "Initialized successfully";
    }
}
