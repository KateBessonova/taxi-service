
package models;


public class CarPayment {
 
    private int carId;
    private double price   ;
    private double monthlyPayment;
    private int year;

    public CarPayment(int carId, double price, double monthlyPayment, int year) {
        this.carId = carId;
        this.price = price;
        this.monthlyPayment = monthlyPayment;
        this.year = year;
    }

    public int getCarId() {
        return carId;
    }

    public double getPrice() {
        return price;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getYear() {
        return year;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CarPayment{" + "carId=" + carId + ", price=" + price + ", monthlyPayment=" + monthlyPayment + ", year=" + year + '}';
    }
    

    
}
