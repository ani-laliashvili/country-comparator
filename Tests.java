    public static void main(String[] args) {
      SortedLinkedList list = new SortedLinkedList(new CountryComparator("AccessToElectricity"));
      list.add(new Country(new String[] {"Country1", "9", "8", "7", "6", "5", "4", "3", "2"}));
      //System.out.println("202 " + list.get(1).toString());
      //System.out.println("203 " + list.numberNodes);
       if (!list.get(1).toString().equals("Country1,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0")) {
            System.err.println("Error in addTest: country data incorrect after adding one country to an empty list.");
        }
        if (list.size() != 1) {
            System.err.println("Error in addTest: size is not 1 after adding one country to an empty list.");
        }

        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country2", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
       // System.out.println("216getNode " + list.get(1).toString());
       // System.out.println("217getNode " + list.get(2).toString());

        //System.out.println(2 <= list.numberNodes);

        //System.out.println("212 " + list.get(1).toString());
        //System.out.println("211 " + list.get(2).toString());

        if (!list.get(2).toString().equals("Country2,7.0,8.0,6.5,6.0,5.0,4.0,3.0,2.0")) {
            System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
                               "should be after the first added country.");
        }
        if (list.size() != 2) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }

        // add another country with equal AccessToElectricity.
        list.add(new Country(new String[] {"Country2", "4", "8", "6.5", "6", "5", "4", "3", "2"}));

                
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
       // System.out.println("211 " + list.get(3).toString());

        if (!list.get(3).toString().equals("Country2,4.0,8.0,6.5,6.0,5.0,4.0,3.0,2.0")) {
            System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
                               "should be after the first added country.");
        }
        if (list.size() != 3) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }

        // add another country with same AccessToElectricity.
        list.add(new Country(new String[] {"Country3", "9", "8", "6.5", "6", "5", "4", "3", "2"}));

                
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());

      //  if (!list.get(2).toString().equals("Country3,9.0,8.0,6.5,6.0,5.0,4.0,3.0,2.0")) {
      //      System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
      //                         "should be after the first added country.");
      //  }
        if (list.size() != 4) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }

        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country3", "2", "8", "8.5", "6", "5", "4", "3", "2"}));

                
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());

    //    if (!list.get(5).toString().equals("Country3,9.0,8.0,8.5,6.0,5.0,4.0,3.0,2.0")) {
    //        System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
    //                           "should be after the first added country.");
    //    }
        if (list.size() != 5) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }

                // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Bountry4", "0.4", "8", "7.0", "6", "5", "4", "3", "2"}));

                
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());
        System.out.println("211 " + list.get(6).toString());

    //    if (!list.get(6).toString().equals("Country4,9.0,8.0,8.5,6.0,5.0,4.0,3.0,2.0")) {
    //        System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
    //                           "should be after the first added country.");
    //    }
        if (list.size() != 6) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }

        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country4", "6.4", "8", "8.5", "6", "5", "4", "3", "2"}));

                
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());
        System.out.println("211 " + list.get(6).toString());
        System.out.println("211 " + list.get(7).toString());

    //    if (!list.get(6).toString().equals("Country4,9.0,8.0,8.5,6.0,5.0,4.0,3.0,2.0")) {
    //        System.err.println("Error in addTest: the newly added country with lowerAccessToElectricity" +
    //                           "should be after the first added country.");
    //    }
        if (list.size() != 7) {
            System.err.println("Error in addTest: size is not 2 after adding two countries to an empty list.");
        }
        System.out.println(" ");
        System.out.println("removed" + list.remove(7));
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());
        System.out.println("211 " + list.get(6).toString()); 
        System.out.println(" ");
        System.out.println("removed" + list.remove(1));
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());
      //  System.out.println("211 " + list.get(6).toString());
        System.out.println(" ");
        System.out.println("removed" + list.remove(3));
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
      //  System.out.println("211 " + list.get(5).toString());
      //  System.out.println("211 " + list.get(6).toString());
        Object[] array = list.toArray();
        System.out.println("toArray() test:");
        for (int i = 0; i < array.length; i++){
            System.out.println("Array" + array[i].toString());
        }
        Country countrycheck = new Country(new String[] {"Country2", "9", "8", "6.5", "6", "5", "4", "3", "2"});
        System.out.println("contains() test:");
        System.out.println(list.contains(countrycheck));
        
        System.out.println("getPosition() test:");
        System.out.println(list.getPosition(countrycheck));
        
        //System.out.println("remove() test:");
        //System.out.println(list.remove(countrycheck));
        //System.out.println("212 " + list.get(1).toString());
        //System.out.println("211 " + list.get(2).toString());
        //System.out.println("211 " + list.get(3).toString());
        
        System.out.println("resort() test:");
        list.resort(new CountryComparator("CO2Emissions"));
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("211 " + list.get(4).toString());
        
        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country9", "3", "8", "6.5", "6", "5", "4", "3", "2"}));
        // add another country with lower AccessToElectricity.
        list.add(new Country(new String[] {"Country6", "7", "8", "6.5", "6", "5", "4", "3", "2"}));
        // add another country with lower AccessToElectricity.
      //  list.add(new Country(new String[] {"Country5", "NaN", "8", "6.5", "6", "5", "4", "3", "2"}));
        
        System.out.println("add() test:");
        System.out.println("212 " + list.get(1).toString());
        System.out.println("211 " + list.get(2).toString());
        System.out.println("211 " + list.get(3).toString());
        System.out.println("212 " + list.get(4).toString());
        System.out.println("211 " + list.get(5).toString());
    //    System.out.println("211 " + list.get(6).toString());
    }