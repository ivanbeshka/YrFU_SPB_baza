package data;

import com.opencsv.bean.CsvBindByName;

public class House {

    @CsvBindByName(column = "number")
    private String number;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "snapshot")
    private String snapshot;

    @CsvBindByName(column = "appellation")
    private String appellation;

    @CsvBindByName(column = "number_of_floor")
    private String numberOfFloor;

    @CsvBindByName(column = "prefix_code")
    private int prefixCode;

    @CsvBindByName(column = "building_type")
    private String buildingType;

    @CsvBindByName(column = "id_")
    private int id;

    @CsvBindByName(column = "year_construction")
    private String yearConstruction;

    public House(String number, String address, String snapshot, String appellation, String numberOfFloor, int prefixCode, String buildingType, int id, String yearConstruction) {
        this.number = number;
        this.address = address;
        this.snapshot = snapshot;
        this.appellation = appellation;
        this.numberOfFloor = numberOfFloor;
        this.prefixCode = prefixCode;
        this.buildingType = buildingType;
        this.id = id;
        this.yearConstruction = yearConstruction;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public String getAppellation() {
        return appellation;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public int getPrefixCode() {
        return prefixCode;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getId() {
        return id;
    }

    public String getYearConstruction() {
        return yearConstruction;
    }

    @Override
    public String toString() {
        return "House{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", snapshot='" + snapshot + '\'' +
                ", appellation='" + appellation + '\'' +
                ", numberOfFloor='" + numberOfFloor + '\'' +
                ", prefixCode=" + prefixCode +
                ", buildingType='" + buildingType + '\'' +
                ", id=" + id +
                ", yearConstruction='" + yearConstruction + '\'' +
                '}';
    }
}
