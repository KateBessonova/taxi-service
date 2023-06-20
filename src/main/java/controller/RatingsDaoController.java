
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Car;
import models.Ratings;


public class RatingsDaoController implements DAO<Ratings>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Ratings t) {
 
        int added = 0;
        try
        {
            String query = "insert into rating (customer_id, driver_id,trip_id, ratings, feedback)"
                    + "values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getCustomerId());
            preparedStatement.setInt(2,t.getDriverId());
            preparedStatement.setInt(3,t.getTripId());
            preparedStatement.setInt(4, t.getRating());
            preparedStatement.setString(5, t.getFeedback());
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Ratings t) {
        int updated = 0;
        try
        {
            String query = "update car Set ratings =?, feedback=? where trip_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, t.getRating());
            preparedStatement.setString(2, t.getFeedback());
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
            String query = "delete from rating where trip_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Ratings getById(int id) {
      
        Ratings rating = null;
        try
        {
            String query = "select * from rating where trip_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                rating = new Ratings(resultSet.getInt("customer_id"),resultSet.getInt("driver_id"),resultSet.getInt("trip_id"),resultSet.getInt("rating"), resultSet.getString("feedback"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return rating;
        
    }
    @Override
    public List<Ratings> getAll() {
        List<Ratings> ratings =  new ArrayList<Ratings>();
        try
        {
            String query = "select * from rating";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Ratings rating = new Ratings(resultSet.getInt("customer_id"),resultSet.getInt("driver_id"),resultSet.getInt("trip_id"),resultSet.getInt("rating"), resultSet.getString("feedback"));
                ratings.add(rating);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ratings;
        
    }

    
}
