
package models;


public class Cities {
 
    private String cityName;
    private String country;
    private int customerId;

    public Cities(String cityName, String country, int customerId) {
        this.cityName = cityName;
        this.country = country;
        this.customerId = customerId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Cities{" + "cityName=" + cityName + ", country=" + country + ", customerId=" + customerId + '}';
    }
   
}
