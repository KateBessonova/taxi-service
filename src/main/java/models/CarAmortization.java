package models;

public class CarAmortization {
 
    private int carId;
    private String miles_driven;
    private int year;
    private int carDepriciation;

    public CarAmortization(int carId, String miles_driven, int year, int carDepriciation) {
        this.carId = carId;
        this.miles_driven = miles_driven;
        this.year = year;
        this.carDepriciation = carDepriciation;
    }

    public int getCarId() {
        return carId;
    }

    public String getMiles_driven() {
        return miles_driven;
    }

    public int getYear() {
        return year;
    }

    public int getCarDepriciation() {
        return carDepriciation;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setMiles_driven(String miles_driven) {
        this.miles_driven = miles_driven;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCarDepriciation(int carDepriciation) {
        this.carDepriciation = carDepriciation;
    }

    @Override
    public String toString() {
        return "CarAmortization{" + "carId=" + carId + ", miles_driven=" + miles_driven + ", year=" + year + ", carDepriciation=" + carDepriciation + '}';
    }
    
    
    
}
