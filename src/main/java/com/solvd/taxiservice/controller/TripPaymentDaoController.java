
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.TripPayment;


public class TripPaymentDaoController implements DAO<TripPayment>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(TripPayment t) {
 
        int added = 0;
        try
        {
            String query = "insert into trip_payment (trip_id, method, amount, customer_id)"
                    + "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getTripId());
            preparedStatement.setString(2,t.getMethod());
            preparedStatement.setDouble(3,t.getAmount());
            preparedStatement.setInt(4,t.getCustomerId());
           
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(TripPayment t) {
        int updated = 0;
        try
        {
            String query = "update trip_payment Set amount =?, method=? where trip_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, t.getAmount());
            preparedStatement.setString(2, t.getMethod());
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
            String query = "delete from trip_payment where trip_id =?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public TripPayment getById(int id) {
      
        TripPayment trip = null;
        try
        {
            String query = "select * from trip_payment where trip_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                trip = new TripPayment(resultSet.getInt("trip_id"),resultSet.getString("method"), resultSet.getDouble("amount") ,resultSet.getInt("customer_id"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return trip;
        
    }
    @Override
    public List<TripPayment> getAll() {
        List<TripPayment> trips =  new ArrayList<TripPayment>();
        try
        {
            String query = "select * from trip_payment";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                TripPayment   trip = new TripPayment(resultSet.getInt("trip_id"),resultSet.getString("method"), resultSet.getDouble("amount") ,resultSet.getInt("customer_id"));
              trips.add(trip);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return trips;
        
    }

    
}
