
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Customer;


public class CustomerDaoController implements DAO<Customer>{

    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Customer t) {
 
        int added = 0;
        try
        {
            String query = "insert into Customer (customer_id, name, email)"
                    + "values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getCustomerId());
            preparedStatement.setString(2, t.getName());
            preparedStatement.setString(3, t.getEmail());
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Customer t) {
        int updated = 0;
        try
        {
            String query = "update Customer Set name =?, email=? where customer_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getEmail());
            preparedStatement.setInt(3,t.getCustomerId());
            
          
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
            String query = "delete from Customer where customer_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Customer getById(int id) {
      
        Customer customer = null;
        try
        {
            String query = "select * from customer where customer_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                customer = new Customer(resultSet.getInt("customer_id"),resultSet.getString("name"), resultSet.getString("email"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return customer;
        
    }
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<Customer>();
        try
        {
            String query = "select * from customer";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Customer customer = new Customer(resultSet.getInt("customer_id"),resultSet.getString("name"), resultSet.getString("email"));
                customers.add(customer);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return customers;
        
    }

    
}
