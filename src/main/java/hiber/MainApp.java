package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class MainApp {
    private static final String USER_BY_CAR = "User с машаной модели %s серии %d : %s, ID: %d \n";

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//
//        User perfectUser = new User("Первый", "Юзер", "first@mail.ru");
//        User perfectUser2 = new User("Последний", "Юзер", "last@mail.ru");
//        User perfectUser3 = new User("Его", "Однофамилец", "hes@mail.ru");
//        User perfectUser4 = new User("Их", "Однофамилец", "them@mail.ru");
//        userService.add(perfectUser);
//        userService.add(perfectUser2);
//        userService.add(perfectUser3);
//        userService.add(perfectUser4);
//
//        Car car1 = new Car(perfectUser, "единица", 1);
//        Car car2 = new Car(perfectUser, "вторая", 2);
//        Car car3 = new Car(perfectUser, "восьмая", 3);
//        Car car4 = new Car(perfectUser, "восьмая", 4);
//        carService.add(car1);
//        carService.add(car2);
//        carService.add(car3);
//        carService.add(car4);
//
//
//        System.out.printf(USER_BY_CAR,car1.getModel(),car1.getSeries(),perfectUser.getFirstName(),perfectUser.getId());
//        System.out.printf(USER_BY_CAR,car2.getModel(),car2.getSeries(),perfectUser2.getFirstName(),perfectUser2.getId());
//        System.out.printf(USER_BY_CAR,car3.getModel(),car3.getSeries(),perfectUser3.getFirstName(),perfectUser3.getId());
//        System.out.printf(USER_BY_CAR,car4.getModel(),car4.getSeries(),perfectUser4.getFirstName(),perfectUser4.getId());
//
//
//
//        Car luckyCar = new Car("Lucky Model",777);
//        User luckyUserWithCar = new User("Lucky","User","getlucky@mail.ru",luckyCar);
//        System.out.printf(USER_BY_CAR,luckyCar.getModel(),luckyCar.getSeries(),luckyUserWithCar.getFirstName(),luckyUserWithCar.getId());


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        context.close();
    }
}
