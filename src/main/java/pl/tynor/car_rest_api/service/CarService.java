package pl.tynor.car_rest_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.model.enums.Color;
import pl.tynor.car_rest_api.repository.abstracts.ICarRepository;
import pl.tynor.car_rest_api.service.abstracts.ICarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {
    private final ICarRepository carRepository;

    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carRepository.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Car> getCarById(Long id) {
        return carRepository.getCar(id)
                .map(car -> getCarById(id))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Car>> getCarsByColor(Color color) {
        return (ResponseEntity<List<Car>>) carRepository.getCars()
                .stream()
                .filter(car -> car.getColor().equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Car> create(Car newCar) {
        return ResponseEntity.ok(carRepository.addCar(newCar));
    }

    @Override
    public ResponseEntity<Car> update(Car update) {
        return ResponseEntity.ok(carRepository.updateCar(update));
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteCar(id);
    }
}
