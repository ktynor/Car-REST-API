package pl.tynor.car_rest_api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.model.enums.Color;
import pl.tynor.car_rest_api.service.abstracts.ICarService;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = {
        MediaType.APPLICATION_XML_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
public class CarApi {
    private final ICarService carService;

    public CarApi(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> findCarByColor(@PathVariable Color color) {
        return carService.getCarsByColor(color);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping
    public ResponseEntity modCar(@RequestBody Car update) {
        return carService.update(update);
    }

    @DeleteMapping("/{id}")
    public void removeCar(@PathVariable long id) {
        carService.delete(id);
    }
}
