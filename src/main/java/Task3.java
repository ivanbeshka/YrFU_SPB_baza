import db.DB;

public class Task3 {
    public static void main(String[] args) {
        DB db = new DB();
        db.getUniversities().forEach(System.out::println);
    }
}
