package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public static List<Car> getListCars(int count) {

        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("BMW", 123, "Black"));
        carsList.add(new Car("WW", 456, "Yellow"));
        carsList.add(new Car("KIA", 789, "Red"));
        carsList.add(new Car("Renault", 101, "White"));
        carsList.add(new Car("KAMAZ", 213, "Blue"));

        List<Car> Endlist = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Endlist.add(carsList.get(i));
        }
        return Endlist;
    }

}
