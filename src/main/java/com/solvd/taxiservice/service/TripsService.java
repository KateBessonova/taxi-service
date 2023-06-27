package services;

import controller.TripsDaoController;
import models.Customer;
import models.Trips;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class TripsService implements ITripsService {
    private static final Logger LOGGER = LogManager.getLogger(TripsService.class);
//    private Dao customerDao = new CustomerDaoImpl();
//    private ISavingsDao savingDao = new SavingsDaoImpl();
//    private ICreditCardDao creditCardDao = new CreditCardDaoImpl();
//    private ICheckingDao checkingDao = new CheckingDaoImpl();
//    private IAddressDao addressDao = new AddressDaoImpl();

    @Override
    public Trips readFromDb(int id) {
        throw new UnsupportedOperationException("use overloaded method with boolean type");
    }

    @Override
    public List<Trips> readAllFromDb() {
        throw new UnsupportedOperationException("use overloaded method with boolean type");
    }

    public Trips readFromDb(int tripId, boolean full)  {
        if (tripId <= 0) {
            LOGGER.error("invalid id argument");
            throw new IllegalArgumentException("Id must be int >=1");
        }
        Trips trips = null;
            if (full) {
                trips = new TripsDaoController().getById(tripId);

            } else {
                trips = new TripsDaoController().getById(tripId);
            }
            return trips;
    }

    public List<Trips> readAllFromDb(boolean full){

        List<Trips> tripList = new ArrayList<>();
        if(full) {
            List<Trips> finalCustomersList = new TripsDaoController().getAll() ;

            }
        else {

        List<Trips> finalCustomersList = new TripsDaoController().getAll() ;

    }
        return tripList;
    }

    public int writeToDb(Trips trip)  {
        if (trip != null) {
            return new TripsDaoController().insert(trip);
        } else {
            LOGGER.error("invalid argument");
            throw new NullPointerException();
        }
    }

    public int updateInDb(Trips trip) {
        if (trip != null) {
            return new TripsDaoController().update(trip);
        } else {
            LOGGER.error("invalid argument");
            throw new NullPointerException();
        }
    }
    public int removeFromDb(int tripId) {
        if (tripId <= 0) {
            LOGGER.error("invalid id argument");
            throw new IllegalArgumentException("Id must be int >=1");
        }
        return new TripsDaoController().deleteById(tripId);
    }
}