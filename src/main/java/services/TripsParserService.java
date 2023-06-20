package services;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import models.Trips;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import parser.Parser;
import validator.XMLValidator;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TripsParserService implements ITripsParserService {
    private static final Logger LOGGER = LogManager.getLogger(TripsParserService.class);
    private static final String SCHEMA = "src/main/resources/xml/trips.xsd";
    private static final String JAXB_OUTPUT = "src/main/resources/xml/jaxb_output.xml";

    @Override
    public Trips getResult(String uri) {
        TripsHandler tripsHandler = new TripsHandler();
        SAXParser saxParser = new Parser().get();
        try {
            saxParser.parse(uri, tripsHandler);
        } catch (SAXException | IOException e) {
            LOGGER.error(e.getMessage());
        }
        Trips trips = tripsHandler.getResult();

        return trips;
    }

    @Override
    public String validate(String uriXml) {
        Reader reader = null;
        try {
            Path xmlPath = Paths.get("src/main/resources/xml/trips.xml");
            reader = Files.newBufferedReader(xmlPath);
            SAXSource source = new SAXSource(new InputSource(reader));
            Validator validator = new XMLValidator().get(SCHEMA);
            validator.validate(source);

        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return "The document validation is OK";
    }

    @Override
    public void marshall(Trips trips) {
        try {
            JAXBContext context = JAXBContext.newInstance(Trips.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(trips, new File(JAXB_OUTPUT));
        } catch (jakarta.xml.bind.JAXBException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Marshalling completed");
    }

    @Override
    public Trips unmarshall(String xmlPath) {
        Unmarshaller um = null;
        Trips trips = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Trips.class);
            um = context.createUnmarshaller();
            trips = (Trips) um.unmarshal(new File(xmlPath));
        } catch (jakarta.xml.bind.JAXBException e) {
            LOGGER.error(e.getMessage());
        }
        return trips;
    }
}

