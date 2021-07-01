package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDao {
    void add(Car car);

    User getUserByCarService(String model, int series);
}
