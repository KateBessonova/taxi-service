
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

    @Override
    public String toString() {
        return "CarPayment{" + "carId=" + carId + ", price=" + price + ", monthlyPayment=" + monthlyPayment + ", year=" + year + '}';
    }
    

    
}
