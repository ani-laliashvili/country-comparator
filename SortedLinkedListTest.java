/**
 * This class tests SortedLinkedList class and prints
 * whether specific tests have passed.
 *
 * @author Ani Laliashvili @author Wonjun Kim
 */

public class SortedLinkedListTest {
    
    /**
     * Tests add() method.
     */
    public static void addTest() {
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
 
        // test 1.1
        if (!list.get(1).toString().equals("Country1,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0")) {
            System.err.println("Error in addTest: country data incorrect after adding one country to an empty list.");
        } else System.out.println("Passed: add() test 1.1 successful!");
        
        // test 1.2
        if (list.size() != 1) {
            System.err.println("Error in addTest: size is not 1 after adding one country to an empty list.");
        } else System.out.println("Passed: add() test 1.2 successful!");
        
        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        // test 2.1
        if (!list.get(2).toString().equals("Country2,7.0,8.0,6.5,6.0,5.0,4.0,3.0,2.0")) {
            System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
                               "should be after the first added country.");
        } else System.out.println("Passed: add() test 2.1 successful!");
        // test 2.2
        if (list.size() != 2) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        } else System.out.println("Passed: add() test 2.2 successful!");     
    }

    
    /**
     * Tests remove() method.
     */    
    public static void removeTest() {
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries to the list
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        Country country1 = new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"});
        Country country2 = new Country(new String[] {"Country1", "100", "8", "7", "6", "5", "4", "3", "2"});
        
        // remove second element
        Country removed = list.remove(2);
        
        // check if the removed country matches with the index in sorted order in terms of Access to Electricity
        Country toCheck = new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"});
        
        // test 1.1
        if (!removed.equals(toCheck)) {
            System.err.println("Error in removeTest: wrong country was removed.");
        } else System.out.println("Passed: remove() test 1.1 successful!");
            
        // test 1.2
        if (list.size() != 1) {
            System.err.println("Error in removeTest: size is not 1 after removing a country.");
        } else System.out.println("Passed: remove() test 1.2 successful!");
        
        // attempt to remove country not in the list
        boolean removedb = list.remove(country2);
            
        // test 2.1
        if (removedb != false) {
            System.err.println("Error in removeTest: country not in the list does not return false.");
        } else System.out.println("Passed: remove() test 2.1 successful!");
            
        // test 2.2
        if (list.size() != 1) {
            System.err.println("Error in removeTest: size is not 1.");
        } else System.out.println("Passed: remove() test 2.2 successful!"); 
            
        // remove the remaining country from the list
        removedb = list.remove(country1);
            
        // test 3.1
        if (removedb != true) {
            System.err.println("Error in removeTest: country not removed.");
        } else System.out.println("Passed: remove() test 3.1 successful!");
        
        // test 3.2
        if (list.size() != 0) {
            System.err.println("Error in removeTest: size is not 0 after removing all countries.");
        } else System.out.println("Passed: remove() test 3.2 successful!");
    }

    /**
     * Tests getPosition() method.
     */    
    public static void getPositionTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries to the list
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));

        Country countrycheck = new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"});
        
        // check that getPosition returns the position of Country3
        if (list.getPosition(countrycheck) != 3) {
            System.err.println("Error in getPositionTest: wrong position returned.");
        } else System.out.println("Passed: getPosition() test 1 successful!");
        
        countrycheck = new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"});
        
        // check that getPosition returns the position of Country1
        if (list.getPosition(countrycheck) != 1) {
            System.err.println("Error in getPositionTest: wrong position returned.");
        } else System.out.println("Passed: getPosition() test 2 successful!");
        
        countrycheck = new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"});
        
        // check that getPosition returns the position of Country2
        if (list.getPosition(countrycheck) != 2) {
            System.err.println("Error in getPositionTest: wrong position returned.");
        } else System.out.println("Passed: getPosition() test 3 successful!");
    }  

    /**
     * Tests size() method.
     */
    public static void sizeTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // check size of empty list
        if (list.size() != 0) {
            System.err.println("Error in sizeTest: size not accurate.");
        } else System.out.println("Passed: size() test 1 successful!");
        
        // add countries
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country4", "7", "8", "7.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "9", "6.5", "6", "5", "4", "3", "2"}));
        
        // check size of list with 4 countries
        if (list.size() != 4) {
            System.err.println("Error in sizeTest: size not accurate.");
        } else System.out.println("Passed: size() test 2 successful!");
    }  

    /**
     * Tests get() method.
     */
    public static void getTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));
        
        Country countrycheck = new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"});
        
        // check that get() method returns country2 at position 2
        if (!list.get(2).equals(countrycheck)) {
            System.err.println("Error in getTest: wrong country returned.");
        } else System.out.println("Passed: get() test 1 successful!");
        
        // attempt to get country at index 5 (out of bounds)
        try {
            list.get(5);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Passed: get() test 2 successful! Throws out of bounds exception!");
        }
    }  

    
    /**
     * Tests contains() method.
     */
    public static void containsTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));

        Country countrycheck = new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"});
        
        // check that list contains Country3
        if (list.contains(countrycheck) != true) {
            System.err.println("Error in containsTest: country in the list not recognized.");
        } else System.out.println("Passed: contains() test 1 successful!");
        
        countrycheck = new Country(new String[] {"Country52", "9", "2", "7", "6", "4", "4", "3", "2"});
        
        // attempt to check country not in the list
        if (list.contains(countrycheck) != false) {
            System.err.println("Error in containsTest: country not in the list recognized.");
        } else System.out.println("Passed: contains() test 2 successful!");
    }  

    /**
     * Tests resort() method.
     */
    public static void resortTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "4", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));
        
        // resort
        list.resort(new CountryComparator("CO2Emissions"));
        
        Country countrycheck = new Country(new String[] {"Country2", "4", "8", "6.5", "6", "5", "4", "3", "2"});
        
        // check that newly sorted order has Country2 at third position
        if (!list.get(3).equals(countrycheck)) {
            System.err.println("Error in resortTest: wrong order of countries.");
        } else System.out.println("Passed: resort() test 1 successful!");
        
        // add a country in second position
        list.add(new Country(new String[] {"Country4", "8", "8", "3.5", "6", "5", "4", "3", "2"}));

        countrycheck = new Country(new String[] {"Country4", "8", "8", "3.5", "6", "5", "4", "3", "2"});
        
        // check that the new Country4 is returned at index 2
        if (!list.get(2).equals(countrycheck)) {
            System.err.println("Error in resortTest: wrong order of countries.");
        } else System.out.println("Passed: resort() test 2 successful!");
        
    }  

    /**
     * Tests isEmpty() method.
     */
    public static void isEmptyTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // check isEmpty() on an empty list
        if (list.isEmpty() != true) {
            System.err.println("Error in isEmptyTest: isEmpty indicated empty when not.");
        } else System.out.println("Passed: isEmpty() test 1 successful!");
        
        // add country
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        
        // check isEmpty() on a non-empty list
        if (list.isEmpty() != false) {
            System.err.println("Error in isEmptyTest: isEmpty indicated not empty when empty.");
        } else System.out.println("Passed: isEmpty() test 2 successful!");
    } 

    /**
     * Tests toArray() method.
     */
    public static void toArrayTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        // add countries
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));
        
        Object[] countries = list.toArray();
        
        // check the length of array vs. list
        if (countries.length != list.size()){
            System.err.println("Error in toArrayTest: Array not the same size as the list.");
        } else System.out.println("Passed: toArray() test 1 successful!");
        
        // check second elements for equality (array index starts at 0, list index starts at 1)
        if (!countries[1].equals(list.get(2))){
            System.err.println("Error in toArrayTest: Array elements incorrect.");
        } else System.out.println("Passed: toArray() test 2 successful!");

    } 

    
    /**
     * Tests clear() method.
     */
    public static void clearTest() {  
        SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
        
        list.clear();
        
        // check clear() on an empty list 
        if (!list.isEmpty()){
            System.err.println("Error in clearTest: cleared list not empty.");
        } else System.out.println("Passed: clear() test 1 successful!");
        
        list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        list.add(new Country(new String[] {"Country3", "7", "8", "3.5", "6", "5", "4", "3", "2"}));
        
        list.clear();
        
        // check clear() on a non-empty list
        if (!list.isEmpty()){
            System.err.println("Error in clearTest: cleared list not empty.");
        } else System.out.println("Passed: clear() test 2 successful!");
    } 

    // runs all tests
    public static void main(String[] args) {
        addTest();
        removeTest();
        getPositionTest();
        sizeTest();
        getTest();
        containsTest();
        resortTest();
        isEmptyTest();
        toArrayTest();
        clearTest();
    }
}