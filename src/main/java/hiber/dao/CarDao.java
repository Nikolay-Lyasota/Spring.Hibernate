package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.Optional;

public interface CarDao {
    void add(Car car);
    Optional<User> getUserByCarService(String model, int series);
}
