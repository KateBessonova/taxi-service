package services;

import models.Trips;

import java.util.List;

public interface ITripsService extends IService <Trips> {
    Trips readFromDb(int tripId, boolean full);
    public List<Trips> readAllFromDb(boolean full);
}
