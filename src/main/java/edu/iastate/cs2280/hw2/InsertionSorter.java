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
 * This class implements insertion sort.
 *
 */

public class InsertionSorter extends AbstractSorter
{
    // Other private instance variables if you need ...

    /**
     * Constructor takes an array of points.  It invokes the superclass constructor, and also
     * set the instance variables algorithm in the superclass.
     *
     * @param pts
     */
    public InsertionSorter(Point[] pts)
    {
        super(pts);
        super.algorithm = "insertion sort";
    }


    /**
     * Perform insertion sort on the array points[] of the parent class AbstractSorter.
     */
    @Override
    public void sort()
    {
        for(int i = 1; i < points.length; i++){
            Point current = points[i];
            int k = i - 1;

            while(k >= 0 && pointComparator.compare(points[k], current) > 0){
                points[k+1] = points[k];
                k--;
            }
            points[k+1] = current;
        }
    }
}
