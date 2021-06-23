package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarDaoImpl implements CarDao {
    private static final String GET_USER = "SELECT c.user FROM Car c WHERE c.series =: series AND c.model =: model";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Optional<User> getUserByCarService(String model, int series) {
        @SuppressWarnings("unchecked") Optional<User> optional = sessionFactory
                .getCurrentSession()
                .createQuery(GET_USER)
                .setParameter("series", series)
                .setParameter("model", model)
                .getResultList()
                .stream()
                .findFirst();
        return optional;
    }
}
