
package models;


public class Car {
 
    private int carId;
    private int driverId;
    private int customerId;
    private String model;
    private String year;

    public Car(int carId, int driverId, int customerId, String model, String year) {
        this.carId = carId;
        this.driverId = driverId;
        this.customerId = customerId;
        this.model = model;
        this.year = year;
    }

    public int getCarId() {
        return carId;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", driverId=" + driverId + ", customerId=" + customerId + ", model=" + model + ", year=" + year + '}';
    }
    

    
    
}
