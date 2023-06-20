
package models;


public class Driver {
 
    private int driverId;
    private String name;
    private String email;
    private String drivingLicense;

    public Driver(int driverId, String name, String email, String drivingLicense) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.drivingLicense = drivingLicense;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverId=" + driverId + ", name=" + name + ", email=" + email + ", drivingLicense=" + drivingLicense + '}';
    }

    
    
    
    
}
