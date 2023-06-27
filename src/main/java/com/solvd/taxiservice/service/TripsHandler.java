package services;

import models.Customer;
import models.Trips;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TripsHandler extends DefaultHandler {
    private static final String tripId = "tripid";
    private static final String Payment = "payment";
    private static final String Status = "status";
    private static final String Customer = "customer";
    private static final String Driver = "driver";

    private models.Trips trips;
    private StringBuilder elementValue;

    public Trips getResult() {
        return trips;
    }

    @Override
    // receives characters with boundaries. We'll convert them to a String and store it in a variable of CustomerHandler
    public void characters(char[] ch, int start, int length) {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    // startDocument() is invoked when the parsing begins – we'll use it to construct our Customer instance
    public void startDocument() {
        trips = new Trips();
    }

    // startElement() is invoked when the parsing begins for an element
    // – qName helps us make the distinction between both types
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        switch (qName) {
            case Payment:
            case Status:
            case tripId:
                elementValue = new StringBuilder();
                break;
           }
    }
        //assigns the content of the tags to their respective variables
        @Override
        public void endElement(String uri, String localName, String qName){
            switch (qName) {
                case Payment:
                    trips.setPayment(Integer.parseInt(elementValue.toString()));
                    break;

                case Status:
                    trips.setStatus(Integer.parseInt(elementValue.toString()));
                    break;

                case tripId:
                    trips.setTripId(Integer.parseInt(elementValue.toString()));
                    break;
            }
        }
}




