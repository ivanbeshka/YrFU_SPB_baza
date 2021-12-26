import data.House;
import db.DB;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        DB db = new DB();
        List<House> houses = db.getRegisteredShlisselburg9881();
        houses.forEach(System.out::println);
    }
}
