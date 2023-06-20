
package controller;

import connection.DBConnection;
import dao.DAO;
import models.Customer;
import models.Driver;
import models.Trips;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TripsDaoController implements DAO<Trips>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Trips t) {
 
        int added = 0;
        try
        {
            String query = "insert into trip (trip_id, customer_id, driver_id,payment, status)"
                    + "values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getTripId());
            preparedStatement.setInt(2,t.getCustomer().getCustomerId());
            preparedStatement.setInt(3,t.getDriver().getDriverId());
            preparedStatement.setInt(4,t.getPayment());
            preparedStatement.setInt(5, t.getStatus());
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Trips t) {
        int updated = 0;
        try
        {
            String query = "update trip Set payment =?, status=? where trip_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getPayment());
            preparedStatement.setInt(2, t.getStatus());
            preparedStatement.setInt(3,t.getTripId());
            
            updated = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return updated;
    }

    @Override
    public int deleteById(int id) {
        int deleted = 0;
        try
        {
            String query = "delete from trip where trip_id =?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Trips getById(int id) {
      
        Trips trip = null;
        try
        {
            String query = "select * from trip where trip_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Customer customer = new CustomerDaoController().getById(resultSet.getInt("customer_id"));
                Driver driver = new DriverDaoController().getById(resultSet.getInt("driver_id"));

                trip = new Trips(resultSet.getInt("trip_id"),resultSet.getInt("payment"),resultSet.getInt("status"), customer, driver);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return trip;
        
    }
    @Override
    public List<Trips> getAll() {
        List<Trips> trips =  new ArrayList<Trips>();
        try
        {
            String query = "select * from trip";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){


                Customer customer = new CustomerDaoController().getById(resultSet.getInt("customer_id"));
                Driver driver = new DriverDaoController().getById(resultSet.getInt("driver_id"));

                Trips trip = new Trips(resultSet.getInt("trip_id"),resultSet.getInt("payment"),resultSet.getInt("status"), customer, driver);
                trips.add(trip);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return trips;
        
    }

    
}
