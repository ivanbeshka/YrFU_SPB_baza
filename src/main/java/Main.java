import com.opencsv.bean.CsvToBeanBuilder;
import data.House;
import db.DB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {

    private final static String SPB_PATH = "C:\\Users\\ivanb\\IdeaProjects\\YrFU_SPB_baza\\src\\main\\resources\\base.csv";

    public static void main(String[] args) {
        DB db = new DB();
        try {
            List<House> houses = new CsvToBeanBuilder(new FileReader(SPB_PATH))
                    .withType(House.class)
                    .build()
                    .parse();

            db.insert(houses);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
