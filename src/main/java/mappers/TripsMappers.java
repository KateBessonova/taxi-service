package mappers;

import models.Trips;

import java.util.List;

public interface TripsMappers {

    Trips selectTripById(int id);
    Trips selectTripByIdFull(int id);
    List<Trips> selectAll();
    List<Trips> selectAllFull();
    void createTrip(Trips trip);
    void updateTrip(Trips trip);
    void deleteTrip(int id);

}
