package edu.iastate.cs2280.hw2;

/**
 *
 * @author Ayr Nasser Neto
 *
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y
 * coordinates are respectively the medians of the x and y coordinates of the original points.
 *
 * It records the employed sorting algorithm as well as the sorting time for comparison.
 *
 */
public class PointScanner
{
    private Point[] points;

    private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of
    // the x coordinates and y coordinates of those points in the array points[].
    private Algorithm sortingAlgorithm;


    protected long scanTime; 	       // execution time in nanoseconds.

    /**
     * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy
     * the points into the array points[].
     *
     * @param  pts  input array of points
     * @throws IllegalArgumentException if pts == null or pts.length == 0.
     */
    public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
    {
        if(pts == null || pts.length == 0){
            throw new IllegalArgumentException("Parameter pts[] is empty");
        }

        points = new Point[pts.length];

        for(int i = 0; i < pts.length; i++){
            points[i] = pts[i];
        }

        sortingAlgorithm = algo;
    }


    /**
     * This constructor reads points from a file.
     *
     * @param  inputFileName
     * @throws FileNotFoundException
     * @throws InputMismatchException   if the input file contains an odd number of integers
     */
    protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
    {
        // Counting amount of points
        int size = 0;
        List<Integer> intHolder = new ArrayList<>();

        try{
            File file = new File(inputFileName);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextInt()){
                size++;
                intHolder.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e){
            System.out.println("File at PointScanner's constructor wasn't found");
        }

        // If size is odd
        if(size % 2 != 0){
            throw new InputMismatchException("File has odd number of integers");
        }

        // Allocate points[] size
        points = new Point[size];

        // Create each point and add to points[]
        int k = 0;
        for(int i = 0; i < size; i++){
            int x = intHolder.get(k);
            int y = intHolder.get(k + 1);
            k += 2;

            points[i] = new Point(x, y);
        }

        sortingAlgorithm = algo;
    }


    /**
     * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:
     *
     *     a) Sort points[] by the x-coordinate to get the median x-coordinate.
     *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
     *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.
     *
     * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
     * or QuickSorter to carry out sorting.
     * @param algo
     * @return
     */
    public void scan()
    {
        // TODO
        // TODO: I GET IT: We get the median value of the x, then get the median of the y
        // TODO: AND THEN, create a whole new Point from these 2 coords to input into
        // TODO: medianCoordinateInput. It doesnt need to be a Point that we have. can be a whole
        // TODO: new point coords
        AbstractSorter aSorter;
        int medianXSorted;
        int medianYSorted;

        // create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two
        // rounds of sorting, have aSorter do the following:
        //
        //     a) call setComparator() with an argument 0 or 1.
        //
        //     b) call sort().
        //
        //     c) use a new Point object to store the coordinates of the medianCoordinatePoint
        //
        //     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
        //
        //     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime.

        if(sortingAlgorithm == Algorithm.SelectionSort){
            aSorter = new SelectionSorter(points);

            // START counting up the time
            long startTime = System.nanoTime();

            aSorter.setComparator(0); // Set to compare by x-coordinate
            aSorter.sort(); // Sorts points[] on the x-coordinate
            medianXSorted = points[points.length / 2].getX(); // Get the median x-coordinate int

            aSorter.setComparator(1); // Set to compare by y-coordinate
            aSorter.sort(); // Sorts points[] on the y-coordinate
            medianYSorted = points[points.length / 2].getY(); // Get the median x-coordinate int

            // STOP counting the time
            long endTime = System.nanoTime();
            scanTime = endTime - startTime;

            // Create the median coordinate Point and assign it
            medianCoordinatePoint = new Point(medianXSorted, medianYSorted);
        }

        else if(sortingAlgorithm == Algorithm.InsertionSort){

        }

    }


    /**
     * Outputs performance statistics in the format:
     *
     * <sorting algorithm> <size>  <time>
     *
     * For instance,
     *
     * selection sort   1000	  9200867
     *
     * Use the spacing in the sample run in Section 2 of the project description.
     */
    public String stats()
    {
        return null;
        // TODO
    }


    /**
     * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space
     * in between.
     */
    @Override
    public String toString()
    {
        return null;
        // TODO
    }


    /**
     *
     * This method, called after scanning, writes point data into a file by outputFileName. The format
     * of data in the file is the same as printed out from toString().  The file can help you verify
     * the full correctness of a sorting result and debug the underlying algorithm.
     *
     * @throws FileNotFoundException
     */
    public void writeMCPToFile() throws FileNotFoundException
    {
        // TODO
    }




}
