import java.util.Comparator;
import java.lang.*;

/** 
* This class compares two countries based on a specified identifier. A call to the compare method in this * class returns a negative number if country1 comes before country2 in sorted order, 0 if country1 and 
* country2 are equal in the sorted order, and a positive number if country1 comes after country2 in sorted * order.
* 
*
* @author Ani Laliashvili @author Wonjun Kim
*/
public class CountryComparator implements Comparator<Country> {
    private String feature; // feature to be used for comparisons
    
    public CountryComparator(String indicator){
        feature = indicator;
    } // end constructor
    
    
    /**
    * This method returns a negative number if country1 comes before country2 in sorted order, 0 if
    * country1 * and country2 are equal in the sorted order, and a positive number if country1 comes after * country2 in * sorted order.
    *
    * @param country1 country used for comparison
    * @param country2 country used for comparison
    * @return  negative number, positive number or 0
    *
    */
    public int compare(Country country1, Country country2){
        int returnValue = 0;
        // check if feature is NaN for any of the countries
        if (Double.isNaN(country1.getFeature(feature)) || Double.isNaN(country2.getFeature(feature))) {
            // if country1 feature is NaN and country2 feature is not, country2 comes first, hence return positive number
            if (Double.isNaN(country1.getFeature(feature)) && !Double.isNaN(country2.getFeature(feature))) {
                returnValue = 10;
            // if country1 feature is not NaN but country2 feature is, country1 comes first, hence return negative number   
            } else if (!Double.isNaN(country1.getFeature(feature)) && Double.isNaN(country2.getFeature(feature))) {
                returnValue = -10;
            // if both countries are NaN, compare country names using compareTo()    
            } else {
                returnValue = country1.getCountryName().compareTo(country2.getCountryName());
            }
        // if none of the countries have feature data with value NaN, continue with regular comparisons
        } else {
            // return zero if feature data and country names are equal
            if ((country1.getFeature(feature) == country2.getFeature(feature)) && (country1.getCountryName().equals(country2.getCountryName()))) {
                returnValue = 0;
            // if features are equal, compare country names using compareTo()    
            } else if (country1.getFeature(feature) == country2.getFeature(feature)) {
                returnValue = country1.getCountryName().compareTo(country2.getCountryName());
            // otherwise subtract feature data of country1 from that of country2    
            } else {
                Double value = country2.getFeature(feature) - country1.getFeature(feature);
                returnValue = value.intValue();
                
                // prevent rounding errors
                if (value > 0 && value < 1) {
                    returnValue = 4;
                } else if (value < 0 && value > -1){
                    returnValue = -4;
                } 
            } 
        }
        return returnValue;
    }
    
    // test
    public static void main(String[] args) {
        Comparator<Country> countryComparator = new CountryComparator("AccessToElectricity");
        Country akhaten = new Country(new String[] {"akhaten", "0", "0", "95", "0", "0", "0", "0", "0"});
        Country trenzalore = new Country(new String[] {"trenzalore", "0", "0", "65", "0", "0", "0", "0", "0"});
        Country gallifrey = new Country(new String[] {"gallifrey", "0", "0", "NaN", "0", "0", "0", "0", "0"});
        Country gallifrey2 = new Country(new String[] {"gallifrey", "0", "0", "NaN", "0", "0", "0", "0", "0"});
        Country gallifrez = new Country(new String[] {"gallifrez", "0", "0", "NaN", "0", "0", "0", "0", "0"});
        Country hallifren = new Country(new String[] {"hallifren", "0", "0", "NaN", "0", "0", "0", "0", "0"});
        Country gallig = new Country(new String[] {"gallig", "0", "0", "NaN", "0", "0", "0", "0", "0"});
        Country gali = new Country(new String[] {"gali", "0", "0", "9.430003", "0", "0", "0", "0", "0"});
        Country poti = new Country(new String[] {"gali", "0", "0", "9.420000", "0", "0", "0", "0", "0"});

        //Value for akhatenVersusTrenzalore should be negative (akhaten has more access)
        int akhatenVersusTrenzalore = countryComparator.compare(akhaten, trenzalore);
        System.out.println("This should be a negative number: " + akhatenVersusTrenzalore);

        //Value for akhatenVersusTrenzalore should be positive (trenzalore has less access)
        int trenzaloreVersusAkhaten = countryComparator.compare(trenzalore, akhaten);
        System.out.println("This should be a positive number: " + trenzaloreVersusAkhaten);

        //Value for akhatenVersusGallifrey should be negative (galligrey has missing data in AccessToElectricity)
        int akhatenVersusGallifrey = countryComparator.compare(akhaten, gallifrey);
        System.out.println("This should be a negative number: " + akhatenVersusGallifrey);
        
        // (same values in every data field)
        int twoGallifrey = countryComparator.compare(gallifrey, gallifrey2);
        System.out.println("This should be zero: " + twoGallifrey);
        
        // (Both missing data, but gallifrey is alphabetically first)
        int compareNames = countryComparator.compare(gallifrey, gallifrez);
        System.out.println("This should be a negative number: " + compareNames);
        
        // (Both missing data, but gallifrey is alphabetically first)
        int compareNamess = countryComparator.compare(gallifrez, gallifrey);
        System.out.println("This should be a positive number: " + compareNamess);
        
        // (Both missing data, but gallifrey is alphabetically first)
        int compareNamesss = countryComparator.compare(hallifren, gallifrey);
        System.out.println("This should be a positive number: " + compareNamesss);
        
        // (Difference in values is very small)
        int compareSmall = countryComparator.compare(poti, gali);
        System.out.println("This should be a positive number: " + compareSmall); 
    }
} 
