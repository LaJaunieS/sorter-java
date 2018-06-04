package app;

import java.util.Arrays;
import java.util.List;

public class MainDriver {
    
    public static void main(String[] args) {
        Double[] arr = {3.0, 6.0, 4.0, 2.0 ,8.0, 1.0, 4.0, 5.0};
        List<Double> list = Arrays.asList(arr);
        List<Double> bubbleSortList = DoubleSorter.bubbleSort(list);
        List<Double> mergeSortList = DoubleSorter.mergeSort(list);
        List<Double> quickSortList = DoubleSorter.quickSort(list);
        
        System.out.format("%12s %40s%n","Bubble sort:",Arrays.toString(bubbleSortList.toArray()));
        System.out.format("%12s %40s%n","Merge sort:", Arrays.toString(mergeSortList.toArray()));
        System.out.format("%12s %40s%n","Quick sort:", Arrays.toString(quickSortList.toArray()));
    }
    
}
