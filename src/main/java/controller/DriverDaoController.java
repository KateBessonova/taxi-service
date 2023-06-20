
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Driver;


public class DriverDaoController implements DAO<Driver>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Driver t) {
 
        int added = 0;
        try
        {
            String query = "insert into driver (driver_id, name, email, driving_license)"
                    + "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getDriverId());
            preparedStatement.setString(2, t.getName());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getDrivingLicense());
            
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Driver t) {
        int updated = 0;
        try
        {
            String query = "update driver Set name =?, email=? , driving_license =? where driver_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getEmail());
            preparedStatement.setString(3,t.getDrivingLicense());
            preparedStatement.setInt(4,t.getDriverId());
            
          
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
            String query = "delete from driver where driver_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Driver getById(int id) {
      
        Driver driver = null;
        try
        {
            String query = "select * from driver where driver_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                driver = new Driver(resultSet.getInt("driver_id"),resultSet.getString("name"), resultSet.getString("email"),resultSet.getString("driving_license"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return driver;
        
    }
    @Override
    public List<Driver> getAll() {
        List<Driver> drivers =  new ArrayList<Driver>();
        try
        {
            String query = "select * from driver";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Driver driver = new Driver(resultSet.getInt("driver_id"),resultSet.getString("name"), resultSet.getString("email"),resultSet.getString("driving_license"));
                drivers.add(driver);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return drivers;
        
    }

    
}
