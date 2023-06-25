
package models;


public class TripPayment {
 
    private int tripId;
    private String method;
    private double amount;
    private int customerId;

    public TripPayment(int tripId, String method, double amount, int customerId) {
        this.tripId = tripId;
        this.method = method;
        this.amount = amount;
        this.customerId = customerId;
    }

    public int getTripId() {
        return tripId;
    }

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "TripPayment{" + "tripId=" + tripId + ", method=" + method + ", amount=" + amount + ", customerId=" + customerId + '}';
    }
    
    
    
    
}
