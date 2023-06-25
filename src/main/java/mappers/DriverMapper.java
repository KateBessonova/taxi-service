package mappers;

import models.Customer;
import models.Driver;

import java.util.List;

public interface DriverMapper {


    Driver selectDriverById(int id);
    List<Driver> selectDriverAll();
    void createDriver(Driver driver);
    void updateDriver(Driver driver);
    void deleteDriver(int id);
}
