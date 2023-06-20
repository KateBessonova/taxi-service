
package models;

public class Drivinglicense {
 
    private String drivingLicense;
    private String category;

    public Drivinglicense(String drivingLicense, String category) {
        this.drivingLicense = drivingLicense;
        this.category = category;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Drivinglicense{" + "drivingLicense=" + drivingLicense + ", category=" + category + '}';
    }
      
    
}
