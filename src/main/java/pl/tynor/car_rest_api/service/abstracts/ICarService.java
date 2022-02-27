package pl.tynor.car_rest_api.service.abstracts;

import org.springframework.http.ResponseEntity;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.model.enums.Color;

import java.util.List;

public interface ICarService {
    ResponseEntity<List<Car>> getCars();
    ResponseEntity<Car> getCarById(Long id);
    ResponseEntity<List<Car>> getCarsByColor(Color color);
    ResponseEntity<Car> create(Car newCar);
    ResponseEntity<Car> update(Car update);
    void delete(Long id);
}
