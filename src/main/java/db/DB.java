package db;

import data.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DB {
    public void insert(List<House> houses) {
        String sql = "INSERT INTO " +
                "house(number,address,snapshot,appellation,number_of_floor,prefix_code,building_type,id_,year_construction) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        houses.forEach(house -> {
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, house.getNumber());
                pstmt.setString(2, house.getAddress());
                pstmt.setString(3, house.getSnapshot());
                pstmt.setString(4, house.getAppellation());
                pstmt.setString(5, house.getNumberOfFloor());
                pstmt.setInt(6, house.getPrefixCode());
                pstmt.setString(7, house.getBuildingType());
                pstmt.setInt(8, house.getId());
                pstmt.setString(9, house.getYearConstruction());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        });

    }

    public Map<String, Integer> getHousesNumberWithFloors() {
        Map<String, Integer> floorsHouses = new HashMap<>();

        String sql = "SELECT * FROM house WHERE number_of_floor <> ''";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                String floors = rs.getString("number_of_floor");
                if (floorsHouses.containsKey(floors)) {
                    int houses = floorsHouses.get(floors);
                    floorsHouses.put(floors, houses + 1);
                } else {
                    floorsHouses.put(floors, 1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return floorsHouses;
    }

    public List<House> getRegisteredShlisselburg9881() {
        String sql = "SELECT * FROM house WHERE appellation == 'Зарегистрированный участок' " +
                "AND prefix_code == 9881 AND address LIKE '%Шлиссельбургское шоссе%'";

        return query(sql);
    }

    public List<House> getUniversities() {


        String sql = "SELECT * FROM house WHERE appellation LIKE '%Университет%' AND year_construction <> ''";
        List<House> houses = query(sql);
        return houses.stream()
                .filter(house -> Integer.parseInt(house.getNumberOfFloor().split("-")[0]) > 5)
                .collect(Collectors.toList());
    }

    private List<House> query(String sql) {
        List<House> houses = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                House house = new House(rs.getString("number"), rs.getString("address"), rs.getString("snapshot"),
                        rs.getString("appellation"), rs.getString("number_of_floor"), rs.getInt("prefix_code"),
                        rs.getString("building_type"), rs.getInt("id_"), rs.getString("year_construction"));
                houses.add(house);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return houses;
    }

    public void deleteAll() {
        String sql = "DELETE FROM house";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect() {

        String url = "jdbc:sqlite:C:\\Users\\ivanb\\IdeaProjects\\YrFU_SPB_baza\\src\\main\\resources\\houses.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
