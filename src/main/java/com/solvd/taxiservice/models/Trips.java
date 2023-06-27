package models;

import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name="trips")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trips {
    @XmlAttribute
    private int tripId;
    @XmlElement(name="payment")
    private int payment;
    @XmlElement(name="status")
    private int status;
    @XmlElement(name="customer")
    private Customer customer;
    @XmlElement(name="driver")
    private Driver driver;

    public Trips(int tripId, int payment, int status, Customer customer, Driver driver) {
        this.tripId = tripId;
        this.payment = payment;
        this.status = status;
        this.customer = customer;
        this.driver = driver;
    }

    public Trips() {
    }

    public int getTripId() {
        return tripId;
    }

    public int getPayment() {
        return payment;
    }

    public int getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    @Override
    public String toString() {
        return "Trips{" +
                "tripId=" + tripId +
                ", payment=" + payment +
                ", status=" + status +
                ", customer=" + customer.getCustomerId() +
                ", driver=" + driver .getDriverId()+
                '}';
    }
}
