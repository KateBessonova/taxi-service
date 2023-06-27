
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

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Drivinglicense{" + "drivingLicense=" + drivingLicense + ", category=" + category + '}';
    }
      
    
}
