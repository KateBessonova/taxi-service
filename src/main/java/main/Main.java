package main;

import controller.CarDaoController;
import controller.CustomerDaoController;
import controller.DriverDaoController;
import controller.OrderDaoController;
import controller.TripPaymentDaoController;
import controller.TripsDaoController;
import java.util.List;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.ITripsParserService;
import services.TripsParserService;


public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
    
        Customer customer1 = new Customer(1, "James", "James@gmail.com");
        Customer customer2 = new Customer(2, "William", "William@gmail.com");
        Customer customer3 = new Customer(3, "David", "david@gmail.com");
        Customer customer4 = new Customer(4, "Jack", "jack@gmail.com");
        Customer customer5 = new Customer(5, "Amy", "amy@gmail.com");
        
        // Customer Dao Controller
        CustomerDaoController customerController = new CustomerDaoController();
        // Insert 5 customers
        customerController.insert(customer1);
        customerController.insert(customer2);
        customerController.insert(customer3);
        customerController.insert(customer4);
        int inserted = customerController.insert(customer5);
        
        if(inserted >0){
        
            LOGGER.info("Customer inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Customers");
        // view all customers from Database
        List<Customer> customers = customerController.getAll();
        
            for(Customer c: customers){
            
                LOGGER.info(c.toString());
            }
        
        
        
                 LOGGER.info("");
                 
         // updated customer
         Customer customer6U = new Customer(5, "Amy", "amy@hotmail.com");
         customerController.update(customer6U);
         
         // get customer by id get updated
         Customer cUpdated = customerController.getById(5);
         LOGGER.info("Updated Customer: ");
         LOGGER.info(cUpdated.toString());
                 LOGGER.info("");
     
         LOGGER.info("Delete Customer: ");
         int deleted = customerController.deleteById(5);
        
         if(deleted>0){
         
             LOGGER.info("Customer Deleted");
         }
         
         LOGGER.info("");
         
         
        Driver driver1 = new Driver(1, "Daniel", "daniel@gmail.com", "112233");
        Driver driver2 = new Driver(2, "Thomas", "thomas@gmail.com", "113344");
        Driver driver3 = new Driver(3, "Micheal", "micheal@gmail.com", "115566");
        Driver driver4 = new Driver(4, "Oliver", "oliver@gmail.com", "116677");
        Driver driver5 = new Driver(5, "George", "george@gmail.com", "118899");
        
        // Driver Dao Controller
        DriverDaoController driverController = new DriverDaoController();
        // Insert 5 customers
        driverController.insert(driver1);
        driverController.insert(driver2);
        driverController.insert(driver3);
        driverController.insert(driver4);
        int insertedD = driverController.insert(driver5);
        
        if(insertedD >0){
        
            LOGGER.info("Driver inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Drivers");
        // view all drivers from Database
        List<Driver> drivers = driverController.getAll();
        
            for(Driver d: drivers){
            
                LOGGER.info(d.toString());
            }
        
            // update driver
       Driver driverU = new Driver(5, "George", "george@hotmail.com", "118890");
       driverController.update(driverU);
       
       Driver updatedDriver = driverController.getById(5);
       LOGGER.info("Updated Driver");
       LOGGER.info(updatedDriver);
       
       LOGGER.info("");
       LOGGER.info("Delete Driver");
       driverController.deleteById(5);
       LOGGER.info("Driver Deleted");
       
        Car car1 = new Car(1, 1,1,"Mecedeze", "2010");
        Car car2 = new Car(2, 2,2,"BMW", "2012");
        Car car3 = new Car(3, 3,3,"Honda Civic", "2022");
        Car car4 = new Car(4, 4,4,"Toyota Fortuner", "2023");
        
        
        // Car Dao Controller
        CarDaoController carController = new CarDaoController();
      
        // Insert 4 cars
        carController.insert(car1);
        carController.insert(car2);
        carController.insert(car3);
        int insertedC = carController.insert(car4);
        
        if(insertedC >0){
        
            LOGGER.info("Car inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Cars");
        // view all customers from Database
        List<Car> cars = carController.getAll();
        
            for(Car c: cars){
            
                LOGGER.info(c.toString());
            }
        
        LOGGER.info("Update Car");
        Car carU = new Car(4, 4,4,"Toyota Fortuner", "2020");
        carController.update(carU);
        LOGGER.info("Car Updated");
        Car updatedCar = carController.getById(4);
        LOGGER.info(updatedCar.toString());
     
        LOGGER.info("");



        Trips trip1 = new Trips(1, 2000,1,customer1, driver1);
        Trips trip2 = new Trips(2, 1500,0,customer2, driver2);
        Trips trip3 = new Trips(3, 3000,1,customer3, driver3);
        Trips trip4 = new Trips(4, 1000,1,customer4, driver4);
        
        
        // trip Dao Controller
        TripsDaoController tripController = new TripsDaoController();
      
        // Insert 4 trips
        tripController.insert(trip1);
        tripController.insert(trip2);
        tripController.insert(trip3);
        int insertedT = tripController.insert(trip4);
        
        if(insertedT >0){
        
            LOGGER.info("Trips inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Trips");
        // view all trips from Database
        List<Trips> trips = tripController.getAll();
        
            for(Trips t: trips){
            
                LOGGER.info(t.toString());
            }
        
            // update Trip
           
        LOGGER.info("Update Trip");
        Trips tripU = new Trips(4, 1200, 1,customer4, driver4);
        tripController.update(tripU);
        LOGGER.info("Trip Updated");
        Trips updatedTrip = tripController.getById(4);
        LOGGER.info(updatedTrip.toString());
        LOGGER.info("Trip Updated");
        
        LOGGER.info("");
        
        Order order1 = new Order(1, 1,"Abc Location","Xyz Location", 2000);
        Order order2 = new Order(2, 2,"Jkl Location","Yue Location", 3000);
        Order order3 = new Order(3, 3,"Mno Location","Tyu Location", 1500);
        Order order4 = new Order(4, 4,"Hyu Location","Qer Location", 1000);
        
        // Order Dao Controller
        OrderDaoController orderController = new OrderDaoController();
      
        // Insert 4 orders
        orderController.insert(order1);
        orderController.insert(order2);
        orderController.insert(order3);
        int insertedO = orderController.insert(order4);
        
        if(insertedO >0){
        
            LOGGER.info("Orders inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Orders");
        // view all trips from Database
        List<Order> orders = orderController.getAll();
        
            for(Order o: orders){
            
                LOGGER.info(o.toString());
            }
            
        LOGGER.info("Update Order");
        Order orderU = new Order(4, 4,"Hyu Location","ABC Location", 1000);
        orderController.update(orderU);
        LOGGER.info("Order Updated");
        Order updatedOrder = orderController.getById(4);
        LOGGER.info(updatedOrder.toString());
        LOGGER.info("Order Updated");

        
        LOGGER.info("");
                 
        TripPayment p1 = new TripPayment(1, "Cash", 2000, 1);
        TripPayment p2 = new TripPayment(2, "Card", 3000, 2);
        TripPayment p3 = new TripPayment(3, "Cash", 1500, 3);
        TripPayment p4 = new TripPayment(4, "Card", 1000, 4);
        
        
        // Trip payment Dao Controller
        TripPaymentDaoController paymentController = new TripPaymentDaoController();
      
        // Insert 4 payments of trip
        paymentController.insert(p1);
        paymentController.insert(p2);
        paymentController.insert(p3);
        int insertedP = paymentController.insert(p4);
        
        if(insertedP >0){
        
            LOGGER.info("Trip Payment inserted: ");
        }
            LOGGER.info("");
            LOGGER.info("Show All Trip Payments");
        // view all trip payments from Database
        List<TripPayment> payments = paymentController.getAll();
        
            for(TripPayment p: payments){
            
                LOGGER.info(p.toString());
            }
        
        LOGGER.info("Update Trip Payment");
        TripPayment pU = new TripPayment(4, "Cash", 1000, 4);
        paymentController.update(pU);
        LOGGER.info("Trip Payment Updated");
        TripPayment updatedTripPayment = paymentController.getById(4);
        LOGGER.info(updatedTripPayment.toString());
        LOGGER.info("Trip Payment Updated");

        LOGGER.info("");

        // sax parser
        ITripsParserService itripsParserService = new TripsParserService();
//        LOGGER.info(itripsParserService.getResult("src/main/resources/xml/trips.xml"));
        LOGGER.info(itripsParserService.validate("src/main/resources/xml/trips.xml"));








    }
    
}
