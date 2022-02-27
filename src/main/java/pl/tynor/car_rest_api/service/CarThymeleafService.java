package pl.tynor.car_rest_api.service;

import org.springframework.stereotype.Service;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.repository.abstracts.ICarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarThymeleafService {

    ICarRepository carRepository;

    public CarThymeleafService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.getCars();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.getCar(id);
    }

    public Optional<Car> addCar(Car newCar) {
        carRepository.addCar(newCar);
        return carRepository.getCar(newCar.getId());
    }

    public Optional<Car> updateCar(Car update, Long id) {
        carRepository.updateCar(update, id);
        return carRepository.getCar(update.getId());
    }

    public void deleteCar(Long id) {
        carRepository.deleteCar(id);
    }
}
