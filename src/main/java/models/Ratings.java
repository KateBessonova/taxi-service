
package models;


public class Ratings {
 
    private int customerId;
    private int driverId;
    private int tripId;
    private int rating;
    private String feedback;

    public Ratings(int customerId, int driverId, int tripId, int rating, String feedback) {
        this.customerId = customerId;
        this.driverId = driverId;
        this.tripId = tripId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "Ratings{" + "customerId=" + customerId + ", driverId=" + driverId + ", tripId=" + tripId + ", rating=" + rating + ", feedback=" + feedback + '}';
    }
    

    
    
}
