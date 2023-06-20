
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Cities;


public class CityDaoController implements DAO<Cities>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Cities t) {
 
        int added = 0;
        try
        {
            String query = "insert into city (city_name, country, customer_id)"
                    + "values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getCityName());
            preparedStatement.setString(2, t.getCountry());
            preparedStatement.setInt(3,t.getCustomerId());
            
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Cities t) {
        int updated = 0;
        try
        {
            String query = "update City Set  country=?, customer_id=? where city_name =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getCountry());
            preparedStatement.setInt(2, t.getCustomerId());
            preparedStatement.setString(3,t.getCityName());
            
          
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
            String query = "delete from City where city_name =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Cities getById(int id) {
      
        Cities city = null;
        try
        {
            String query = "select * from city where customer_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                city = new Cities(resultSet.getString("city_name"),resultSet.getString("country"), resultSet.getInt("customer_id"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return city;
        
    }
    @Override
    public List<Cities> getAll() {
        List<Cities> cities =  new ArrayList<Cities>();
        try
        {
            String query = "select * from city";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Cities city = new Cities(resultSet.getString("city_name"),resultSet.getString("country"), resultSet.getInt("customer_id"));
                cities.add(city);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cities;
        
    }

    
}
