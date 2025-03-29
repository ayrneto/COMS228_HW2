package edu.iastate.cs2280.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

/**
 *
 * @author Ayr Nasser Neto
 *
 */

/**
 *
 * This class implements the mergesort algorithm.
 *
 */

public class MergeSorter extends AbstractSorter
{
    // Other private instance variables if needed

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts   input array of integers
     */
    public MergeSorter(Point[] pts)
    {
        super(pts);
        super.algorithm = "mergesort";
    }


    /**
     * Perform mergesort on the array points[] of the parent class AbstractSorter.
     *
     */
    @Override
    public void sort()
    {
        mergeSortRec(points);
    }


    /**
     * This is a recursive method that carries out mergesort on an array pts[] of points. One
     * way is to make copies of the two halves of pts[], recursively call mergeSort on them,
     * and merge the two sorted sub-arrays into pts[].
     *
     * @param pts	point array
     */
    private void mergeSortRec(Point[] pts)
    {
        if(pts.length <= 1){
            return;
        }

        int length = pts.length;
        int middle = length / 2;
        int k = 0;

        Point[] left = new Point[middle];
        Point[] right = new Point[length - middle];

        for(int i = 0; i < middle; i++){
            left[i] = pts[i];
        }

        for(int i = middle; i < pts.length; i++){
            right[k] = pts[i];
            k++;
        }

        mergeSortRec(left); // This works because the array is an object, and objects
        mergeSortRec(right); // always are passed as reference and keep their values

        // Merge starts here

        int i = 0;
        int j = 0;
        k = 0;

        while(i < left.length && j < right.length){
            if(pointComparator.compare(left[i], right[j]) <= 0){
                pts[k] = left[i];
                i++;
            }
            else{
                pts[k] = right[j];
                j++;
            }
            k++;
        }

        while(j < right.length){
            pts[k] = right[j];
            j++;
            k++;
        }

        while(i < left.length){
            pts[k] = left[i];
            i++;
            k++;
        }
    }


    // Other private methods if needed ...

}
