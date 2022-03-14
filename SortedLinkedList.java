import java.util.Comparator;
import java.util.Iterator;

/**
 * SortedList interface adapted from Carrano and Henry's interface in Data
 * Structures and Abstractions with Java. A sorted list ADT is like a list,
 * but maintains its entries in sorted order (rather than in the order they
 * were inserted or the order that the user specified).
 * 
 * ***Important:***
 * Treats the index (position) to start from 1. So, the legit range of 
 * position is: 1 <= position <= numberOfEntries.
 *
 * @author Anna Rafferty; modified by Yucong Jiang
 *
 * @author Ani Laliashvili @author Wonjun Kim
 *
 */
public class SortedLinkedList implements SortedList<Country> {
    public int numberNodes;
    public Node first;
    public Comparator<Country> comparator;

    public SortedLinkedList(Comparator<Country> comparator) {
      numberNodes = 0;
      this.comparator = comparator;
    } // end constructor

    /**
    * Defines class Node to be used for the linked list.
    */
    private class Node {
        private Country data; // Data being stored
        private Node next; // Link to next node

        /**
        * Node constructor with data portion only.
        *
        * @param dataPortion data to be stored in the node
        */
        private Node(Country dataPortion) {
            this(dataPortion, null);
        }
        
        /**
        * Node constructor with data portion and next node values.
        * 
        * @param dataPortion data to be stored in the node
        * @param nextNode node to follow the current node
        */
        private Node(Country dataPortion, Node nextNode) {         
            data = dataPortion;
            next = nextNode;
        }

        /**
        * Returns next node.
        * 
        * @return next the node following the current node
        */
        private Node getNext() {
            return next;
        }

        /**
        * Sets next node.
        * 
        * @param nextNode the node to be set as next of the current node
        */
        private void setNext(Node nextNode) {
            next = nextNode;
        }

        /**
        * Returns data from current node.
        * 
        * @return data the data being stored
        */
        private Country getData(){
            return data;
        }
        
        /**
        * Sets data.
        * 
        * @param country the country data to be contained in current node
        */
        private void setData(Country country) {
            data = country;
        }
    }
    
    /**
     * Returns node at a specified position.
     * 
     * @param position specified position
     * @return current node at the specified position
     */
    private Node getNode(int position){
        Node current = first;
        // if position is 1, returns first node
        if (position == 1) {
            return current;
        // otherwise traverses through the rest of the nodes
        } else {
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            return current;
        }
    }

    /**
     * Adds item to the list in sorted order.
     *
     * Time efficiency: O(n)
     *
     * @param item country item to be added
     */
    @Override
    public void add(Country item){
        // create new Node containing item
        Node newNode = new Node(item, null);
        
        int i = 1;
        boolean assigned = false; // to stop loop once data is placed in position

        // if list is empty set newNode as first node and increase list size
        if (isEmpty()) { 
            first = newNode;
            numberNodes++;
        } else {
            
            // if list is not empty check several conditions:
            while (i <= numberNodes && !assigned) {
                
                // compare the node to i-th Node in the list
                int compValue = comparator.compare(newNode.getData(), getNode(i).getData()); 
                
                // if newNode feature is larger than i-th node, or if the countries have same indicator and name, insert the country into the i-th place
                if (compValue < 0 || compValue == 0) { 
                    assigned = true; // to stop loop once data is placed in position
                    
                    // if newNode is placed as the node before the last node and after position 1
                    if (i == numberNodes || i>1) {
                        newNode.setNext(getNode(i)); // set i-th node as next node of newNode 
                        getNode(i-1).setNext(newNode); // set newNode as next node of the node before i 
                    } else {
                        newNode.setNext(getNode(i));
                        first = newNode;
                    }   
                    
                // if there is no country smaller than country in newNode, insert newNode as the last node in the list    
                } else if (i == numberNodes){    
                    getNode(numberNodes).setNext(newNode); // set newNode as the next node of the last node 
                } i++;
            }
            numberNodes++; // increase number of nodes
        }
    }

    /**
     * Remove targetItem from the list, shifting everything after it up
     * one position. targetItem is considered to be in the list if
     * an item that is equal to it (using .equals) is in the list.
     * (This convention for something being in the list should be
     * followed throughout.)
     *
     * Time efficiency: O(n)
     *
     * @return true if the item was in the list, false otherwise
     */
    @Override 
    public boolean remove(Country targetItem){
        if (contains(targetItem)) {
            int position = getPosition(targetItem);
            Country removed = remove(position);
            if (removed != null) {
                return true;
            }
        } 
        return false;
    }
    
    /**
     * Removes the item at index position from the list, shifting everything
     * after it up one position.
     *
     * Time efficiency: O(n)
     *
     * @return the removed item, or throw an IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override 
    public Country remove(int position){
        Country removed = null;
        
        // position is in range check a couple of conditions
        if (position >= 1 && position <= size()) {  
            
            // if removing the first node
            if (position == 1) {
                removed = get(position);
                first = getNode(position + 1); // node at position + 1 will now be first 
                numberNodes = numberNodes - 1; // decrease number of nodes
                
            // if removing the last node    
            } else if (position == size()) {
                removed = get(position);
                getNode(position - 1).setNext(null); // node at position-1 will be last
                numberNodes = numberNodes - 1; // decrease number of nodes
                
            // if removing any other node    
            } else {
                removed = get(position);
                getNode(position - 1).setNext(getNode(position + 1)); // nodes at position-1 and position+1 will now be linked
                numberNodes = numberNodes - 1; // decrease number of nodes
            }
            
      } else throw new IndexOutOfBoundsException("Position out of range!");
      return removed; // return removed item
    }

    /**
     * Returns the position of targetItem in the list.
     *
     * Time efficiency: O(n^2)
     *
     * @return the position of the item, or -1 if targetItem is not in the list
     */
    @Override 
    public int getPosition(Country targetItem){
        if (!isEmpty()) {
            for (int i = 1; i <= numberNodes; i++){
                if (targetItem.equals(get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /** 
     * Returns the country object at a given index.
     *
     * Time efficiency: O(n)
     *
     * @return the item, or throw an IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override 
    public Country get(int position){
        if ((position >= 1) && (position <= numberNodes)){
            Country country = getNode(position).getData();
            return country;
        } else {
            throw new IndexOutOfBoundsException("Position out of range!");
        }
    }
    

    /** 
    * Returns true if the list contains the target item. 
    *
    * Time efficiency: O(n^2)
    *
    * @param targetItem country object to be searched for
    * @return true if country is in the list
    */
    @Override
    public boolean contains(Country targetItem){
        if (!isEmpty()) {
            // traverse through all nodes and compare data stored in each
            for (int i = 1; i <= numberNodes; i++){
                if (targetItem.equals(get(i))) {
                    return true;
                }
            } 
        } return false;
    }
    
    /** Re-sorts the list according to the given comparator.
     * All future insertions should add in the order specified
     * by this comparator.
     *
     * Time efficiency: O(n^3)
     *
     * @param comparator comparator to be used for resorting
     */
    @Override 
    public void resort(Comparator<Country> comparator){
        // skip first node, sort all others
        for (int i = 2; i <= numberNodes; i++) {
            // compare i-th node to each of the nodes in the list
            for (int j = 1; j <= i; j++){
                int compValue = comparator.compare(get(i), get(j));
                // if i-th node data is more than j-th node data or if the entries are the same insert node i in position j
                if (compValue < 0 || compValue == 0) {
                    Node resort = getNode(i); 
                    if (j == 1){ // if insertion position is first and node to be sorted isn't last
                        getNode(i - 1).setNext(getNode(i + 1)); // link i-1 and i+1
                        resort.setNext(getNode(j));
                        first = resort; // make resort first
                        if (i == numberNodes) {// insertion position is first and node to be sorted is last
                            getNode(i-1).setNext(null); // make i-1 last
                        }  
                    // if insertion position is the same as node to be sorted   
                    } else if (j == i && compValue >= 0) {
                        getNode(j-1).setNext(resort); // do not move resort
                    // if node to be sorted is in the last position and insertion position is not first  
                    } else if (i == numberNodes){
                        getNode(i-1).setNext(null);
                        resort.setNext(getNode(j));
                        getNode(j-1).setNext(resort);
                    // if insertion position and node to be sorted are not either first or last or equal to each other    
                    } else {  
                        getNode(i-1).setNext(getNode(i+1)); // link nodes at i-1 and i+1
                        resort.setNext(getNode(j)); // set next node of resort to j-th node
                        getNode(j-1).setNext(resort); // set resort after j-1
                    }
                }   
            }
        }
        this.comparator = comparator;
    }

    /** 
    * Returns the length of the list: the number of items stored in it. 
    *
    * Time efficiency: O(1)
    *
    * @return numberNodes size of list
    */
    @Override
    public int size(){
        return numberNodes;
    }

    /** 
    * Returns true if the list has no items stored in it. 
    * 
    * Time efficiency: O(1)
    *
    * @return true if list is empty
    */
    @Override
    public boolean isEmpty() {
        return (numberNodes == 0);
    }

    /** Returns an array version of the list.  Note that, for technical reasons,
     * the type of the items contained in the list can't be communicated
     * properly to the caller, so an array of Objects gets returned.
     *
     * Time efficiency: O(n)
     *
     * @return an array of length length(), with the same items in it as are
     *         stored in the list, in the same order.
     */
    @Override
    public Object[] toArray() {
        Node current = first;
        Country[] array = new Country[size()];
        array[0] = current.getData();
        for (int i = 1; i < numberNodes; i++) {
            current = current.getNext();
            array[i] = current.getData();
        }
        return array;
    }

    /** 
    * Returns an iterator that begins just before index 1 in this list. 
    * Unsupported Operation.
    */
    @Override
    public Iterator<Country> iterator(){
        throw new UnsupportedOperationException("iterator() not implemented!");
    }
    
    /** 
    * Removes all items from the list. 
    *
    * Time efficiency: O(1)
    *
    */
    @Override
    public void clear(){
        numberNodes = 0;
        first = null;
    }
}