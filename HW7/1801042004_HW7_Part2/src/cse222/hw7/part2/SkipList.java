
package cse222.hw7.part2;

import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of a Skip-List data structure
 * @author Murat
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class SkipList<E extends Comparable<E>> {
    /**
     * Head of the skip-list
     */
    public SLNode<E> head;
    /**
     * Size of the skip list
     */
    private int size;
    /**
     * The maximum level of the skip-list
     */
    private int maxLevel;
    /**
     * Smallest power of 2 that is greater than the current skip-list size
     */
    private int maxCap;
    /**
     * Natural log of 2
     */
    static final double LOG2 = Math.log(2.0);
    /**
     * Minimum possible integer value for the head
     */
    static final int MIN = Integer.MIN_VALUE;
    /**
     * Random number generator
     */
    private Random rand = new Random();



    //Constructor

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public SkipList(int max){
        size = 0;
        maxLevel = 0;
        SLNode.maxArraySize = max;
        SLNode.minArraySize = max/2;
        maxCap = computeMaxCap(maxLevel);


        head = new SLNode(maxLevel, MIN);
    }

    /**
     * Search for an item in the list
     * @param target The item being sought
     * @return An SLNode array which references the predecessors of the target at each level.
     */
    @SuppressWarnings("unchecked")
    private SLNode<E>[] search(E target){
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for(int i = current.links.length - 1; i >= 0; i--){
            while(current.links[i] != null
                    && current.links[i].data[0].compareTo(target) <= 0){
                current = current.links[i];
            }
            pred[i] = current;
        }
        return pred;
    }

    /**
     * Find an object in the skip-list
     * @param target The item being sought
     * @return A reference to the object in the skip-list that matches
     * 		   the target. If not found, null is returned
     */
    public E find(E target){
        SLNode<E>[] pred = search(target);

        if(pred[0] == head )
            return null;
        else
            return pred[0].find(target);
    }

    /**
     * Inserts the given item
     * @param item The item to add
     * @return true as the item is added
     */
    public boolean add(E item){
        SLNode<E> newNode = null;
        SLNode<E>[] pred = search(item);

        if ( head.links.length == 0 ){
            size++;
            maxLevel++;
            maxCap = computeMaxCap(maxLevel);
            head.links = Arrays.copyOf(head.links, maxLevel);
            newNode = new SLNode<E>(logRandom(), item);
            head.links[0] = newNode;
            return true;
        }

        // is element exist
        else if ( (pred[0] == head && pred[0].links[0].find(item) != null) || (pred[0] != head && pred[0].find(item) != null) )
            return false;

        else if ( pred[0] == head && !pred[0].links[0].add(item) ){ // can item be added to previous
            size++;
            newNode = split(pred[0].links[0]); // split
            if(newNode.data[0].compareTo(item) > 0)
                pred[0].links[0].add(item);
            else
                newNode.add(item);

            if(size > maxCap){
                maxLevel++;
                maxCap = computeMaxCap(maxLevel);
                head.links = Arrays.copyOf(head.links, maxLevel);
                pred = Arrays.copyOf(pred, maxLevel);
                pred[maxLevel - 1] = head;
            }

            for(int i = 0; i < newNode.links.length; i++){ // link new node between next and next next
            	if( pred[i].links[i] != null ) {
            		newNode.links[i] = pred[i].links[i].links[i];
                    pred[i].links[i].links[i] = newNode;
            	}
            		
            }

        }
        else if ( pred[0] != head && !pred[0].add(item) ){
            size++;
            newNode = split(pred[0]); // split
            if(newNode.data[0].compareTo(item) > 0)
                pred[0].add(item);
            else
                newNode.add(item);

            if(size > maxCap){
                maxLevel++;
                maxCap = computeMaxCap(maxLevel);
                head.links = Arrays.copyOf(head.links, maxLevel);
                pred = Arrays.copyOf(pred, maxLevel);
                pred[maxLevel - 1] = head;
            }

            for(int i = 0; i < newNode.links.length; i++){ // link new node between pred and pred next
                newNode.links[i] = pred[i].links[i];
                pred[i].links[i] = newNode;
            }
        }


        return true;
    }

    /**
     * Method to generate a logarithmic distributed integer between 1 and maxLevel.
     *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
     * @return a random logarithmic distributed int between 1 and maxLevel
     */
    private int logRandom(){
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if(k > maxLevel - 1)
            k = maxLevel - 1;
        return maxLevel - k;
    }

    /**
     * Recompute the max cap
     * @param level will be computed
     * @return max capacity
     */
    private int computeMaxCap(int level){
        return (int) Math.pow(2, level) - 1;
    }

    private SLNode<E> split(SLNode<E> split){
        SLNode<E> newNode = new SLNode<E>(logRandom(), split.data[split.size-1]);

        for (int i=split.size-2; i>=split.size/2; i--){
            newNode.add(split.data[i]);
            split.data[i] = null;
        }
        split.data[split.size-1] = null;
        split.size = (int) (split.size/2);
        return newNode;
    }

    @SuppressWarnings("rawtypes")
    public String toString(){
        if(size == 0)
            return "Empty";
        StringBuilder sc = new StringBuilder();
        SLNode itr = head;
        sc.append("Head: " + maxLevel);
        int lineMaker = 0;
        while(itr.links[0] != null){
            itr = itr.links[0];
            sc.append(" --> " + itr.toString());
            lineMaker++;
            if(lineMaker == 1){
                sc.append("\n       ");
                lineMaker = 0;
            }
        }
        return sc.toString();
    }

    /**
     * Static class to contain data and links
     * @author murat
     *
     * @param <E> The type of data stored. Must be a Comparable
     */
    static class SLNode<E extends Comparable<E>>{
        SLNode<E>[] links;
        E [] data;
        public static int maxArraySize;
        public static int minArraySize;
        private int size = 0;

        /**
         * Create a node of level m
         * @param m The level of the node
         * @param data The data to be stored
         */
        @SuppressWarnings("unchecked")
        public SLNode(int m, E [] data){
            links = (SLNode<E>[]) new SLNode[m];
            this.data = data;
        }

        /**
         * Create a node of level m
         * @param m The level of the node
         * @param data The data to be stored
         */
        @SuppressWarnings("unchecked")
        public SLNode(int m, E data){
            links = (SLNode<E>[]) new SLNode[m];
            this.data = (E[]) new Comparable[maxArraySize-1];
            this.add(data);
        }

        public boolean add(E item){
            boolean exist = false;
            // if capacity not over
            if(size == maxArraySize-1)
                return  false;

            
            // check item already exist
            for (int i=0; i<size; i++){
                if(this.data[i].compareTo(item) == 0){
                    exist = true;
                    i = size; // break loop
                }
            }

            // if item is not already exist
            if (!exist){
                this.data[size++] = item;
                int i = size -1;

                while (i > 0 && data[i-1].compareTo(data[i]) > 0 ){
                    E temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                    i--;
                }
            }
            return true;
        }

        /**
         * Find an object in the skip-list
         * @param target The item being sought
         * @return A reference to the object in the skip-list that matches
         * 		   the target. If not found, null is returned
         */
        public E find(E target) {

            for (int i = 0; i < size; i++)
                if (data[i].compareTo(target) == 0)
                    return data[i];

            return null;
        }

        public E remove(){
            size--;
            return data[size];
        }

        public E remove(E item){
            int i = 0;
            E returned = null;
            boolean found = false;

            while ( !found || i < size){
                if (data[i].compareTo(item) == 0) {
                    found = true;
                    returned = data[i];
                }
                i++;
            }

            while( i < size-1 ){
                E temp = data[i];
                data[i] = data[i+1];
                data[i+1] = temp;
            }

            return found ? returned : null;
        }

        public String toString(){
            /*
            String str = new String();
            str = "[" ;

            for (int i=0; i<size; i++)
                str += " " + data[i];

            str = " ]";
            */

            return (Arrays.toString(data) + " |" + links.length + "|");
        }

    }

}
