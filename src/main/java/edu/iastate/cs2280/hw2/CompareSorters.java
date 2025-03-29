package edu.iastate.cs2280.hw2;

/**
 *
 * @author Ayr Nasser Neto
 *
 */

/**
 *
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the
 * execution times of these algorithms on the same input.
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;


public class CompareSorters
{
    /**
     * Repeatedly take integer sequences either randomly generated or read from files.
     * Use them as coordinates to construct points.  Scan these points with respect to their
     * median coordinate point four times, each time using a different sorting algorithm.
     *
     * @param args
     **/
    public static void main(String[] args) throws FileNotFoundException
    {
        // Conducts multiple rounds of comparison of four sorting algorithms.  Within each round,
        // set up scanning as follows:
        //
        //    a) If asked to scan random points, calls generateRandomPoints() to initialize an array
        //       of random points.
        //
        //    b) Reassigns to the array scanners[] (declared below) the references to four new
        //       PointScanner objects, which are created using four different values
        //       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort.
        //
        //
        PointScanner[] scanners = new PointScanner[4];
        Scanner scanner = new Scanner(System.in);

        int keyInput = 0;
        int trialNumber = 1;
        int numPointsInput = 0;

        System.out.println("Performances of Four Algorithms in Point Scanning");

        while(keyInput != 3){
            System.out.println("Keys: 1 (random integers), 2 (file input), 3 (exit)");

            System.out.print("Trial " + trialNumber + ": ");
            keyInput = scanner.nextInt();
            System.out.println();

            // Random Integers
            if(keyInput == 1){
                System.out.println("Enter number of random points: ");
                numPointsInput = scanner.nextInt();
                System.out.println();

                Random random = new Random();
                Point[] points = generateRandomPoints(numPointsInput, random);

                scanners[0] = new PointScanner(points, Algorithm.SelectionSort);
                scanners[1] = new PointScanner(points, Algorithm.InsertionSort);
                scanners[2] = new PointScanner(points, Algorithm.MergeSort);
                scanners[3] = new PointScanner(points, Algorithm.QuickSort);

                System.out.println("Algorithm      Size     Time(ns)");
                System.out.println("--------------------------------");

                scanners[0].scan();
                System.out.println(scanners[0].stats());

                scanners[1].scan();
                System.out.println(scanners[1].stats());

                scanners[2].scan();
                System.out.println(scanners[2].stats());

                scanners[3].scan();
                System.out.println(scanners[3].stats());
                System.out.println("--------------------------------\n");
            }

            // File Input
            else if(keyInput == 2){
                System.out.println("Points from a file");
                System.out.print("File name: ");
                String fileName = scanner.nextLine();
                System.out.println();

                scanners[0] = new PointScanner(fileName, Algorithm.SelectionSort);
                scanners[1] = new PointScanner(fileName, Algorithm.InsertionSort);
                scanners[2] = new PointScanner(fileName, Algorithm.MergeSort);
                scanners[3] = new PointScanner(fileName, Algorithm.QuickSort);

                System.out.println("Algorithm      Size     Time(ns)");
                System.out.println("--------------------------------");

                scanners[0].scan();
                scanners[0].stats();
                System.out.println();

                scanners[1].scan();
                scanners[1].stats();
                System.out.println();

                scanners[2].scan();
                scanners[2].stats();
                System.out.println();

                scanners[3].scan();
                scanners[3].stats();
                System.out.println();
                System.out.println("--------------------------------\n");
            }

            // Exit
            else if(keyInput == 3){
                System.out.println("Exiting program...");
                return;
            }

            trialNumber++;
        }


        // For each input of points, do the following.
        //
        //     a) Initialize the array scanners[].
        //
        //     b) Iterate through the array scanners[], and have every scanner call the scan()
        //        method in the PointScanner class.
        //
        //     c) After all four scans are done for the input, print out the statistics table from
        //		  section 2.
        //
        // A sample scenario is given in Section 2 of the project description.

    }


    /**
     * This method generates a given number of random points.
     * The coordinates of these points are pseudo-random numbers within the range
     * [-50,50] � [-50,50]. Please refer to Section 3 on how such points can be generated.
     *
     * Ought to be private. Made public for testing.
     *
     * @param numPts  	number of points
     * @param rand      Random object to allow seeding of the random number generator
     * @throws IllegalArgumentException if numPts < 1
     */
    private static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
    {
        if(numPts < 1){
            throw new IllegalArgumentException();
        }

        int randomX, randomY;

        Point[] points = new Point[numPts];

        for(int i = 0; i < points.length; i++){
            randomX = rand.nextInt(101) - 50;
            randomY = rand.nextInt(101) - 50;

            points[i] = new Point(randomX, randomY);
        }

        return points;
    }

}
