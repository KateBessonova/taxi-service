
package controller;

import connection.DBConnection;
import dao.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Car;
import models.Order;


public class OrderDaoController implements DAO<Order>{
    static Connection connection = new DBConnection().getConnection();
    
    @Override
    public int insert(Order t) {
 
        int added = 0;
        try
        {
            String query = "insert into orders (order_id, customer_id, fromT, toT, price)"
                    + "values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,t.getOrderId());
            preparedStatement.setInt(2,t.getCustomerId());
            preparedStatement.setString(3,t.getFrom());
            preparedStatement.setString(4, t.getTo());
            preparedStatement.setInt(5, t.getPrice());
            
          
            added = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return added;
    }

    @Override
    public int update(Order t) {
        int updated = 0;
        try
        {
            String query = "update Orders Set fromT =?, toT=?, price=? where order_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, t.getFrom());
            preparedStatement.setString(2, t.getTo());
            preparedStatement.setInt(3,t.getPrice());
            preparedStatement.setInt(4,t.getOrderId());
            
          
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
            String query = "delete from orders where order_id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
          
            deleted = preparedStatement.executeUpdate();

        }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return deleted;
    }

    @Override
    public Order getById(int id) {
      
        Order order = null;
        try
        {
            String query = "select * from orders where order_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
           
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                order = new Order(resultSet.getInt("order_id"),resultSet.getInt("customer_id"),resultSet.getString("fromT"),resultSet.getString("toT"), resultSet.getInt("price"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return order;
        
    }
    @Override
    public List<Order> getAll() {
        List<Order> orders =  new ArrayList<Order>();
        try
        {
            String query = "select * from orders";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
          
                Order order = new Order(resultSet.getInt("order_id"),resultSet.getInt("customer_id"),resultSet.getString("fromT"),resultSet.getString("toT"), resultSet.getInt("price"));
                orders.add(order);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return orders;
        
    }

    
}
