import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    
/** 
 * This class displays countries sorted by specific 
 * feature.
 *
 * @author Ani Laliashvili @author Wonjun Kim
 */
public class CountryDisplayer {
    
    private SortedLinkedList countries; // countries list
    private String criteria; // feature used for sorting
    
    public CountryDisplayer(){
        countries = null;
        criteria = null;
    } // end constructor
    
    /**
    * Constructs a new CountryDisplayer containing the countries in the file at filePath.
    * If filePath is null, constructs an empty CountryDisplayer.
    *
    * @param filePath path to the file from which to load country data
    * @param indicator indicator to use for sorting the countries
    */
    
    public CountryDisplayer(String filePath, String indicator){
        if (filePath == null) {
            criteria = indicator;
            countries = new SortedLinkedList(new CountryComparator(criteria));
        } else {
            criteria = indicator;
            countries = new SortedLinkedList(new CountryComparator(criteria));
            Scanner fileData = null;
            try {
                fileData = new Scanner(new File(filePath));
            } catch (FileNotFoundException e) {
                System.out.println("Scanner error opening the file " + filePath);
                System.out.println(e.getMessage());
            }
            String header = fileData.nextLine();
            while (fileData.hasNextLine()) {
                String line = fileData.nextLine();
                Country country = new Country(line.split(","));
                addCountry(country);
            }
        }
    }
    
    /**
    * Returns the value of the indicator for a specific country.
    * If column is invalid prints error statement.
    *
    * @param index index of desired country
    * @param column desired indicator 
    */
    private double getDataEntry(int index, String column) {
        Country country = countries.get(index);
        if (column.equals("CO2Emissions")) {
            return country.getFeature("CO2Emissions");
        } else if (column.equals("TotalGreenhouseGasEmissions")) {
            return country.getFeature("TotalGreenhouseGasEmissions");
        } else if (column.equals("AccessToElectricity")) {
            return country.getFeature("AccessToElectricity");
        } else if (column.equals("RenewableEnergy")) {
            return country.getFeature("RenewableEnergy");
        } else if (column.equals("ProtectedAreas")) {
            return country.getFeature("ProtectedAreas");
        } else if (column.equals("PopulationGrowth")) {
            return country.getFeature("PopulationGrowth");
        } else if (column.equals("PopulationTotal")) {
            return country.getFeature("PopulationTotal");
        } else if (column.equals("UrbanPopulationGrowth")) {
            return country.getFeature("UrbanPopulationGrowth");
        }
        System.out.println("Error in getDataEntry with column name as " + column);
        System.exit(1);
        return 0;
    }
 
    /**
    * Prints a text version of the countries
    */
    public void displayCountriesAsText(){
        for (int i = 1; i < countries.size()+1; i++) {
            System.out.println(countries.get(i).toString());
        }
    }
 
    /**
    * Displays a graph with the top 10 countries (based on the sorting criteria)
    * and a second series showing the additional indicator.
    * @param secondaryIndicator indicator to show as the second series in the graph
    */
    public void displayGraph(String secondaryIndicator){
        // displays no values in a graph if list is empty
        if (size() == 0){
            BarChart barChart = new BarChart("Top " + criteria + " in Red, " + secondaryIndicator + " in Blue", "Country", "Value");
            barChart.addValue(" ", 0.0, " ");
            barChart.displayChart();
        // displays all countries if list has less than 10 countries   
        } else if (size() < 10){
            BarChart barChart = new BarChart("Top " + size() + " " + criteria + " in Red, " + secondaryIndicator + " in Blue", "Country", "Value");
            for (int i = 1; i < size()+1; i++) {
                barChart.addValue(countries.get(i).getCountryName(), getDataEntry(i, criteria), criteria);
                barChart.addValue(countries.get(i).getCountryName(), getDataEntry(i, secondaryIndicator), secondaryIndicator);
            }
            barChart.displayChart();
        // displays top 10 countries if size is equal to or more than 10    
        } else {
            BarChart barChart = new BarChart("Top 10 " + criteria + " in Red, " + secondaryIndicator + " in Blue", "Country", "Value");
            assert countries.size() >= 10;
            for (int i = 1; i < 11; i++) {
                barChart.addValue(countries.get(i).getCountryName(), getDataEntry(i, criteria), criteria);
                barChart.addValue(countries.get(i).getCountryName(), getDataEntry(i, secondaryIndicator), secondaryIndicator);
            }
            barChart.displayChart();
        }
    }
 
    /**
    * Changes the criteria for sorting 
    * @param indicator indicator to use for sorting the countries Valid values are: CO2Emissions, 
    *        TotalGreenhouseGasEmissions, AccessToElectricity, RenewableEnergy, ProtectedAreas, 
    *        PopulationGrowth, PopulationTotal, or UrbanPopulationGrowth
    */
    public void changeSortingCriteria(String indicator){ 
        countries.resort(new CountryComparator(indicator));
        criteria = indicator;
    }
    
    /**
    * Adds the given country to the data.
    * @param country country to add
    */
    public void addCountry(Country country){
        countries.add(country);
    }
    
    /**
    * Returns list size.
    *
    * @return list size
    */
    private int size(){
        if (countries.isEmpty() == false){
            return countries.size();
        } else return 0;
    } 
    
    /**
    * Changes sorting criteria from user input.
    */
    private void inputCriteria(){
        Scanner scanner = new Scanner(System.in);
        String sortingIndicator = null;
        System.out.println("Choose indicator to sort with (one of: CO2Emissions, TotalGreenhouseGasEmissions, AccessToElectricity, RenewableEnergy, ProtectedAreas, PopulationGrowth, PopulationTotal, or UrbanPopulationGrowth):");
            
        boolean correct = false;
        while (correct == false) {
            // String input
            sortingIndicator = (scanner.next()).trim();
                
            if (sortingIndicator.equals("CO2Emissions") || (sortingIndicator.equals("TotalGreenhouseGasEmissions")) || (sortingIndicator.equals("AccessToElectricity")) || (sortingIndicator.equals("RenewableEnergy")) ||(sortingIndicator.equals("ProtectedAreas")) || (sortingIndicator.equals("PopulationGrowth")) ||(sortingIndicator.equals("PopulationTotal")) || (sortingIndicator.equals("UrbanPopulationGrowth")) ) {
                correct = true;
                changeSortingCriteria(sortingIndicator);
            } else {
                System.out.print("Please provide a valid sorting criteria.");
                System.out.println("Choose indicator to sort with (one of: CO2Emissions, TotalGreenhouseGasEmissions, AccessToElectricity, RenewableEnergy, ProtectedAreas, PopulationGrowth, PopulationTotal, or UrbanPopulationGrowth).");
            }
        }
    }
     
    /**
    * Adds country to the list from user input.
    */
    private void inputAdd(){
        boolean valid = false;
        String[] countryData = {"countryName", "co2Emissions", "totalGreenhouseGasEmissions", "accessToElectricity", "renewableEnergy", "protectedAreas", "populationGrowth", "populationTotal", "urbanPopulationGrowth"};
        Scanner scanner = new Scanner(System.in);
                
        while(valid == false){
            System.out.println("Please enter your country in the following format: 'CountryName CO2Emissions TotalGreenhouseGasEmissions AccessToElectricity RenewableEnergy ProtectedAreas PopulationGrowth PopulationTotal UrbanPopulationGrowth'");
            
            int i = 0;
            valid = true;
                    
            String line = (scanner.nextLine()).trim();
                    
            while (i < 9 && valid == true) {
                countryData = line.split("\\s+");
                // if country does not contain all/ contains more data, display wrong format message and retry
                if (countryData.length != 9){
                    valid = false;
                    System.out.print("Wrong format! ");
                // if country contains all data display wrong format message and retry 
                } else if (countryData[i].contains(",") || countryData[i].contains("!") || countryData[i].contains(";") || countryData[i].contains("?")){
                    valid = false;
                    System.out.print("Wrong format! ");
                }
                i++;
            }
        }
        // if country format is valid add country to the list
        if (valid == true) {
            Country toAdd = new Country(countryData);
            addCountry(toAdd);
        }
    }
    
    
    public static void main(String[] args) {
        CountryDisplayer countryDisplayer = null;
        
        // if no dataset is given constructs an empty object
        if (args.length == 0) {
            countryDisplayer = new CountryDisplayer(null, "TotalGreenhouseGasEmissions");  
        // otherwise reads country list from the specified file
        } else { 
            countryDisplayer = new CountryDisplayer(args[0], "TotalGreenhouseGasEmissions");
        }
        
        // read user input and complete user requests
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (exit == false){
            System.out.println("What would you like to do?  There are five valid answers: 'set sorting criteria', 'add country', 'display text', 'display graph', and 'exit'");
            
            String function = (scanner.nextLine()).trim();
            
            if (function.equals("set sorting criteria")) {
                countryDisplayer.inputCriteria();
            } else if (function.equals("add country")) {
                countryDisplayer.inputAdd();
            } else if (function.equals("display text")){
                countryDisplayer.displayCountriesAsText();
            } else if (function.equals("display graph")){  
                System.out.println("Choose secondary indicator to include on your graph (one of: CO2Emissions, TotalGreenhouseGasEmissions, AccessToElectricity, RenewableEnergy, ProtectedAreas, PopulationGrowth, PopulationTotal, or UrbanPopulationGrowth).");
                String secondaryIndicator = (scanner.next()).trim();
                countryDisplayer.displayGraph(secondaryIndicator);
            } else if (function.equals("exit")) {
                exit = true;
                System.exit(1);
            }
        }
    }
}
