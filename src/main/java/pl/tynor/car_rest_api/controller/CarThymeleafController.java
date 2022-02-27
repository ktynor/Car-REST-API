package pl.tynor.car_rest_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.service.CarThymeleafService;

@Controller
public class CarThymeleafController {

    private final CarThymeleafService carThymeleafService;

    public CarThymeleafController(CarThymeleafService carThymeleafService) {
        this.carThymeleafService = carThymeleafService;
    }

    @GetMapping("/all-cars")
    public String getAllCars(Model model) {
        model.addAllAttributes(carThymeleafService.findAll());
        model.addAttribute("cars", carThymeleafService.findAll());
        return "cars";
    }
    @GetMapping("/index")
    public String welcome() {
        return "index";
    }

    @GetMapping("/add-car")
    public String addCar() {
        return "add-car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute("newCar") Car car, Model model) {
        carThymeleafService.addCar(car);
        model.addAttribute("car", carThymeleafService.getCarById(car.getId()));

        model.addAttribute("cars", carThymeleafService.findAll());
        return "cars";
    }

    @GetMapping("/update-car/{id}")
    public String updateForm(@PathVariable("id") Long id, @ModelAttribute("car") Car car, Model model) {

        model.addAttribute("car", carThymeleafService.getCarById(car.getId()));
        return "update-car";
    }

    @PostMapping("/update-car/{id}")
    public String updateCar(@PathVariable("id") Long id, @ModelAttribute("update") Car update, Model model) {
        carThymeleafService.updateCar(update,id);
        model.addAttribute("car", carThymeleafService.getCarById(id));
        model.addAttribute("cars", carThymeleafService.findAll());
        return "cars";
    }

    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id, Model model) {
        carThymeleafService.deleteCar(id);
        carThymeleafService.findAll();

        model.addAttribute("car", carThymeleafService.getCarById(id));
        model.addAttribute("cars", carThymeleafService.findAll());
        return "cars";
    }
}
