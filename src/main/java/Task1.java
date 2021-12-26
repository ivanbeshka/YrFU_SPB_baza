import db.DB;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        DB db = new DB();
        Map<String, Integer> data = db.getHousesNumberWithFloors();
        data.forEach((s, integer) -> System.out.println(s + " " + integer));
    }
}
