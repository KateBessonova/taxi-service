
package models;


public class TripZones {
 
    private String withinCityLimitZone;
    private String outCityLimitZone;
    private int tripPaymentId;
    private int customerId;

    public TripZones(String withinCityLimitZone, String outCityLimitZone, int tripPaymentId, int customerId) {
        this.withinCityLimitZone = withinCityLimitZone;
        this.outCityLimitZone = outCityLimitZone;
        this.tripPaymentId = tripPaymentId;
        this.customerId = customerId;
    }

    public String getWithinCityLimitZone() {
        return withinCityLimitZone;
    }

    public void setWithinCityLimitZone(String withinCityLimitZone) {
        this.withinCityLimitZone = withinCityLimitZone;
    }

    public String getOutCityLimitZone() {
        return outCityLimitZone;
    }

    public void setOutCityLimitZone(String outCityLimitZone) {
        this.outCityLimitZone = outCityLimitZone;
    }

    public int getTripPaymentId() {
        return tripPaymentId;
    }

    public void setTripPaymentId(int tripPaymentId) {
        this.tripPaymentId = tripPaymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
