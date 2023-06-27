
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Car;


public class CarDaoController implements DAO<Car>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Car t) {
 
        int added = 0;
        try
        {
            String query = "insert into car (car_id, customer_id, driver_id, model, year)"
                    + "values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getCarId());
            preparedStatement.setInt(2,t.getCustomerId());
            preparedStatement.setInt(3,t.getDriverId());
            preparedStatement.setString(4, t.getModel());
            preparedStatement.setString(5, t.getYear());
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Car t) {
        int updated = 0;
        try
        {
            String query = "update car Set model =?, year=? where car_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getModel());
            preparedStatement.setString(2, t.getYear());
            preparedStatement.setInt(3,t.getCarId());
            
          
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
            String query = "delete from car where car_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Car getById(int id) {
      
        Car car = null;
        try
        {
            String query = "select * from car where car_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                car = new Car(resultSet.getInt("car_id"),resultSet.getInt("customer_id"),resultSet.getInt("driver_id"),resultSet.getString("model"), resultSet.getString("year"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return car;
        
    }
    @Override
    public List<Car> getAll() {
        List<Car> cars =  new ArrayList<Car>();
        try
        {
            String query = "select * from car";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Car car = new Car(resultSet.getInt("car_id"),resultSet.getInt("customer_id"),resultSet.getInt("driver_id"),resultSet.getString("model"), resultSet.getString("year"));
                cars.add(car);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cars;
        
    }

    
}
