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
 * This class implements selection sort.
 *
 */

public class SelectionSorter extends AbstractSorter
{
    // Other private instance variables if you need ...

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts
     */
    public SelectionSorter(Point[] pts)
    {
        super(pts);
        super.algorithm = "selection sort";
    }


    /**
     * Apply selection sort on the array points[] of the parent class AbstractSorter.
     *
     */
    @Override
    public void sort()
    {
        int minIndex;
        Point temp;

        for(int i = 0; i < (points.length - 1); i++){
            minIndex = i;
            for(int k = (i+1); k < points.length; k++){
                if(pointComparator.compare(points[k], points[minIndex]) < 1){
                    minIndex = k;
                }
            }
            temp = points[minIndex];
            points[minIndex] = points[i];
            points[i] = temp;
        }
    }
}
