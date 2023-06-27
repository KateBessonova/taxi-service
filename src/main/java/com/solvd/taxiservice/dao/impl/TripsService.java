package services.implmybatis;

import mappers.TripsMappers;
import models.Trips;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.ITripsService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TripsService implements ITripsService {
    private static final String CONFIG = "mybatis-config.xml";
    private static final Logger LOGGER = LogManager.getLogger(TripsService.class);

    @Override
    public Trips readFromDb(int id) {
        throw new UnsupportedOperationException("use overloaded method with boolean type");
    }

    @Override
    public List<Trips> readAllFromDb() {
        throw new UnsupportedOperationException("use overloaded method with boolean type");
    }

    @Override
    public int writeToDb(Trips trip) {
        try (InputStream stream = Resources.getResourceAsStream(CONFIG);
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            TripsMappers tripMapper = session.getMapper(TripsMappers.class);
            tripMapper.createTrip(trip);
            session.commit();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return 1;
    }

    @Override
    public int updateInDb(Trips trip) {
        try (InputStream stream = Resources.getResourceAsStream(CONFIG);
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            TripsMappers tripsMapper = session.getMapper(TripsMappers.class);
            tripsMapper.updateTrip(trip);
            session.commit();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return 1;
    }

    @Override
    public int removeFromDb(int id) {
        try (InputStream stream = Resources.getResourceAsStream(CONFIG);
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            TripsMappers tripsMapper = session.getMapper(TripsMappers.class);
            tripsMapper.deleteTrip(id);
            session.commit();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return 1;
    }

    @Override
    public Trips readFromDb(int id, boolean full) {
        Trips trips = null;
        if (full) {
            try (InputStream stream = Resources.getResourceAsStream(CONFIG);
                 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                TripsMappers tripsMappers = session.getMapper(TripsMappers.class);
                trips = tripsMappers.selectTripByIdFull(id);
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        } else {
            try (InputStream stream = Resources.getResourceAsStream(CONFIG);
                 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                TripsMappers tripsMappers = session.getMapper(TripsMappers.class);
                trips = tripsMappers.selectTripById(id);
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return trips;
    }


    @Override
    public List<Trips> readAllFromDb(boolean full) {
        List<Trips> tripList = null;
        if (full) {
            try (InputStream stream = Resources.getResourceAsStream(CONFIG);
                 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                TripsMappers tripMapper = session.getMapper(TripsMappers.class);
                tripList = tripMapper.selectAllFull();
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        } else {
            try (InputStream stream = Resources.getResourceAsStream(CONFIG);
                 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                TripsMappers tripsMappers = session.getMapper(TripsMappers.class);
                tripList = tripsMappers.selectAll();
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return tripList;
    }
}