package pl.tynor.car_rest_api.repository.abstracts;

import pl.tynor.car_rest_api.model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    Car addCar(Car car);
    Car updateCar(Car update);

    Car updateCar(Car update, Long id);

    void deleteCar(Long id);
    Optional<Car> getCar(Long id);
    List<Car> getCars();
}
