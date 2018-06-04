package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**Implements a series of commonly-used sort methods and a Binary Search-
 * contains a Bubble Sort, Merge Sort, Quick Sort, Selection sort, and a
 * Binary search. For each method, the given list must be of type List\<Double\>.
 * @author slajaunie
 *
 *TODO- add check if given list is List<Double> if not throw illegal argument
 *exception
 */
public class DoubleSorter {
    
    /**Implementation of a Bubble Sort. Iterates through a given List,
     * comparing doubles in index positions i+1 and i. If i+1 < i, 
     * switches the two values'index positions, and begins the iteration again.
     * @param list a given <code>List&lt;double&rt;</code> implementation
     * @return the sorted List
     */
    public static List<Double> bubbleSort(List<Double> list) {
        int listSize = list.size();
        double thisValue;
        double nextValue;
        boolean sortAgain = false;
        for (int i = 0; i < listSize; i++) {
            thisValue = list.get(i);
            nextValue = i+1<listSize? list.get(i+1): Double.MAX_VALUE;
            if (nextValue < thisValue) {
                list.set(i, nextValue);
                list.set(i+1, thisValue);
                sortAgain = true;
            }
        }
        if (sortAgain)
            bubbleSort(list);

        return list;
    }
    
    /**Implements a merge sort. Splits a given list into a "left" and "right"
     * list, divided at the middle list item. Returns and recursively calls 
     * <code>merge()</code> method on the two split lists. 
     * @param list list a given <code>List&lt;double&rt;</code> implementation
     * @return the sorted list
     */
    public static List<Double> mergeSort(List<Double> list) {
        if (list.size()<=1) return list;
        
        int middle = list.size()/2;
        List<Double> left = new LinkedList<Double>(list.subList(0, middle));
        List<Double> right = new LinkedList<Double>(list.subList(middle,list.size()));
        
        return merge(mergeSort(left),mergeSort(right));
    }
    
    private static List<Double> merge(List<Double> left, List<Double> right){
        List<Double> result = new LinkedList<Double>();
        try {
            while (left.size()!=0 || right.size()!=0) {
                /*while there are items in either list, compare...*/
                if (left.size()!=0 && right.size()!=0) {
                    Double leftD = left.get(0);
                    Double rightD = right.get(0);
                    /*...If items in both lists, add the greater of the corresponding
                     * list items to the result list*/
                    if (Double.max(leftD,rightD)==leftD) 
                        result.add(right.remove(0));
                    else 
                       result.add(left.remove(0));
                /*...If only items in right list, add to result list*/
                } else if (right.size()!=0) 
                    result.add(right.remove(0));
                else 
                    result.add(left.remove(0));
            }    
        } catch (Exception ex) {
            System.out.println(Arrays.toString(result.toArray()));
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    /**Implements a Quick Sort on a given List. Using a "pivot value", iterates
     * through a List and sorts an index value based on that index's value 
     * compared to the pivotValue. Recursively performs the same operation on each
     * subList created from distributing the index values based on their comparison
     * to the pivot value. 
     * @param list a List of doubles
     * @return the sorted List
     */
    public static List<Double> quickSort(List<Double> list) {
        /*recursion check*/
        if (list.size()<=1) return list;
        
        List<Double> left = new LinkedList<Double>();
        List<Double> right = new LinkedList<Double>();
        List<Double> sortedList;
        int pivotIndex = (int) Math.floor(list.size()/2);
        Double pivotValue = list.get(pivotIndex);
        int subListSize = 0;
        
        
        /*Remove pivotValue from list to be sorted (since pivotValue doesn't need
         * to be compared to itself)
         */
        List<Double> subList = new LinkedList<Double>(list.subList(0, pivotIndex));
        subList.addAll(list.subList(pivotIndex+1, list.size()));
        subListSize = subList.size();
        /*Now do the compare*/
        for (int i = 0; i < subListSize; i++) {
            Double compareValue = subList.remove(0);
            if (Double.min(compareValue, pivotValue)==compareValue) 
                left.add(compareValue);
            else 
                right.add(compareValue);
        }
        
        /*concatenate the three elements- left side (recursively sorted),
         * pivotValue, and right side (recursively sorted);
         */
        sortedList = new LinkedList<Double>(quickSort(left));
        sortedList.add(pivotValue);
        sortedList.addAll(quickSort(right));
    
        return sortedList;
    }
    
}
