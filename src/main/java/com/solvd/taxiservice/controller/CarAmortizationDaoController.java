
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Car;
import models.CarAmortization;


public class CarAmortizationDaoController implements DAO<CarAmortization>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(CarAmortization t) {
 
        int added = 0;
        try
        {
            String query = "insert into car_amortization (car_id, miles_driven, year, car_depriciation)"
                    + "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getCarId());
            preparedStatement.setString(2,t.getMiles_driven());
            preparedStatement.setInt(3,t.getYear());
            preparedStatement.setInt(4, t.getCarDepriciation());
           
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(CarAmortization t) {
        int updated = 0;
        try
        {
            String query = "update car_amortization Set miles_driven =?, year=?, car_depriciation=? where car_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getMiles_driven());
            preparedStatement.setInt(2, t.getYear());
            preparedStatement.setInt(3,t.getCarDepriciation());
            preparedStatement.setInt(4,t.getCarId());
           
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
            String query = "delete from car_amortization where car_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public CarAmortization getById(int id) {
      
        CarAmortization car = null;
        try
        {
            String query = "select * from car_amortization where car_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                car = new CarAmortization(resultSet.getInt("car_id"),resultSet.getString("miles_driven"),resultSet.getInt("year"),resultSet.getInt("car_depriciation"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return car;
        
    }
    @Override
    public List<CarAmortization> getAll() {
        List<CarAmortization> cars = new ArrayList<CarAmortization>();
        try
        {
            String query = "select * from car_amortization";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                CarAmortization car = new CarAmortization(resultSet.getInt("car_id"),resultSet.getString("miles_driven"),resultSet.getInt("year"),resultSet.getInt("car_depriciation"));
                cars.add(car);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cars;
        
    }

    
}
