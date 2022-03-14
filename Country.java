/**
 * @author: Yucong Jiang
 */


public class Country {
    private String countryName;
    private double co2Emissions;
    private double totalGreenhouseGasEmissions;
    private double accessToElectricity;
    private double renewableEnergy;
    private double protectedAreas;
    private double populationGrowth;
    private double populationTotal;
    private double urbanPopulationGrowth;
    
    public Country(String[] countryData) {
        countryName = countryData[0];
        co2Emissions = Double.parseDouble(countryData[1]);
        totalGreenhouseGasEmissions = Double.parseDouble(countryData[2]);
        accessToElectricity = Double.parseDouble(countryData[3]);
        renewableEnergy = Double.parseDouble(countryData[4]);
        protectedAreas = Double.parseDouble(countryData[5]);
        populationGrowth = Double.parseDouble(countryData[6]);
        populationTotal = Double.parseDouble(countryData[7]);
        urbanPopulationGrowth = Double.parseDouble(countryData[8]);
    }
    
    public String getCountryName() {
        return countryName;
    }
    
    public void setCountryName(String newCountryName) {
        countryName = newCountryName;
    }
    
    public double getFeature(String featureName) {
        if (featureName.equals("CO2Emissions")) {
            return co2Emissions;
        } else if (featureName.equals("TotalGreenhouseGasEmissions")) {
            return totalGreenhouseGasEmissions;
        } else if (featureName.equals("AccessToElectricity")) {
            return accessToElectricity;
        } else if (featureName.equals("RenewableEnergy")) {
            return renewableEnergy;
        } else if (featureName.equals("ProtectedAreas")) {
            return protectedAreas;
        } else if (featureName.equals("PopulationGrowth")) {
            return populationGrowth;
        } else if (featureName.equals("PopulationTotal")) {
            return populationTotal;
        } else if (featureName.equals("UrbanPopulationGrowth")) {
            return urbanPopulationGrowth;
        }
        System.err.println("ERROR in getFeature: The provided feature name doesn't exist!");
        System.exit(1);
        return 0;
    }
    
    public void setFeature(String featureName, double newValue) {
        if (featureName.equals("CO2Emissions")) {
            co2Emissions = newValue;
        } else if (featureName.equals("TotalGreenhouseGasEmissions")) {
            totalGreenhouseGasEmissions = newValue;
        } else if (featureName.equals("AccessToElectricity")) {
            accessToElectricity = newValue;
        } else if (featureName.equals("RenewableEnergy")) {
            renewableEnergy = newValue;
        } else if (featureName.equals("ProtectedAreas")) {
            protectedAreas = newValue;
        } else if (featureName.equals("PopulationGrowth")) {
            populationGrowth = newValue;
        } else if (featureName.equals("PopulationTotal")) {
            populationTotal = newValue;
        } else if (featureName.equals("UrbanPopulationGrowth")) {
            urbanPopulationGrowth = newValue;
        } else {
            System.err.println("ERROR in setFeature: The provided feature name doesn't exist!");
            System.exit(1);
        }
    }
    
    public String toString() {
        return countryName + "," + co2Emissions + "," + totalGreenhouseGasEmissions + "," + accessToElectricity + 
            "," + renewableEnergy + "," + protectedAreas + "," + populationGrowth + "," + populationTotal +
            "," + urbanPopulationGrowth;
    }
    
    // return true if two Country instances have the same values for all indicators and have the same name.
    // Otherwise, it returns false. 
    public boolean equals(Country otherCountry) {
        return this.toString().equals(otherCountry.toString());
    }
    
    public static void main (String[] args) {
        String[] data = {"Country1", "1", "2", "3", "4", "5", "6", "7", "8"};
        Country country1 = new Country(data);
        System.out.println(country1);
        // Or use one line:
        Country country2 = new Country(new String[] {"Country", "9", "8", "NaN", "6", "5", "4", "3", "2"});
        System.out.println(country2);
        
        Country country3 = new Country(new String[] {"Country", "9", "8", "NaN", "6", "5", "4", "3", "2"});
        System.out.println(country3);
        System.out.println(country2.equals(country3));
        System.out.println(country1.equals(country3));
    }
}
