package pl.tynor.car_rest_api.repository;

import org.springframework.stereotype.Repository;
import pl.tynor.car_rest_api.model.Car;
import pl.tynor.car_rest_api.model.enums.Color;
import pl.tynor.car_rest_api.repository.abstracts.ICarRepository;

import java.util.*;

@Repository
public class CarRepository implements ICarRepository {

    private Long counter = 0L;
    private final Map<Long, Car> cars = new HashMap<>();

    public CarRepository() {
        Car carFirst = new Car(increment(), "Nissan", "QASHQAI", Color.BLUE);
        Car carSecond = new Car(increment(), "Vauxhall", "MOKKA", Color.YELLOW);
        Car carThird = new Car(increment(), "Renault", "CAPTUR", Color.GREEN);
        cars.put(carFirst.getId(), carFirst);
        cars.put(carSecond.getId(), carSecond);
        cars.put(carThird.getId(), carThird);
    }

    @Override
    public Car addCar(Car car) {
        car.setId(increment());
        cars.put(car.getId(), car);
        return car;
    }

    @Override
    public Car updateCar(Car update) {
        cars.remove(update.getId(), update);
        cars.put(update.getId(), update);
        return update;
    }
    @Override
    public Car updateCar(Car update, Long id) {
        cars.remove(id);
        update.setId(id);
        cars.put(id,update);
        return update;
    }

    @Override
    public void deleteCar(Long id) {
        cars.remove(id);
    }

    @Override
    public Optional<Car> getCar(Long id) {
        return Optional.ofNullable(cars.get(id));
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(cars.values());
    }

    private Long increment() {
        return ++counter;
    }
}
