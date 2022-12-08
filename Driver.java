import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;

/**CLASS Driver is test code to run two different test demonstrations of the {@code RangeMap} and {@code ARange} classes.
 *
 * @author Alex Molinari
 */


public class Driver {

    /**METHOD getTimeElapsed records the end-time of a method execution and prints the elapsed time in seconds to console.
     *
     * @param startTime starting time in nanoseconds.
     */
    public static void getTimeElapsed(long startTime){
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double timeInSeconds = (double) totalTime / 1_000_000_000;
        System.out.format("\nTime Elapsed: %f seconds\n",timeInSeconds);
    }

    /**
     * METHOD generate instantiates a RangeMap instance, and creates two ranges that each point to a
     * single value in memory.  It then prints the values from two arbitrary keys in the greater {@code ARange} key.
     */
    public static void generate(){
        int range1Start = 1000;
        int range1End = 2000;
        int range2Start = 2000;
        int range2End = 3000;
        RangeMap rangeMap = new RangeMap();
        rangeMap.put(range1Start, range1End, 12345);
        rangeMap.put(range2Start, range2End, 4040404);
        int testKey1 = 1950;
        int testKey2 = 2451;
        int answer = rangeMap.get(testKey1);
        int answer2 = rangeMap.get(testKey2);
        System.out.format("\nKey Range: %d to %d, Test Key: %d, Answer: %d\n",range1Start, range1End, testKey1, answer);
        System.out.format("\nKey Range: %d to %d, Test Key: %d, Answer: %d\n",range2Start, range2End, testKey2, answer2);
    }

    /**
     * METHOD generate2 generates 1 million entries, and 1 billion 'simulated' key/value pairs. It then iterates through
     * the {@code RangeMap} and prints a value from an arbitrary key within the greater {@code ARange} key.
     */
    public static RangeMap generate2(){
        RangeMap rangeMap = new RangeMap();
        int val;
        int val2 = 0;
        for (int i = 0; i < 1_000_001_000; i += 1000) {
            rangeMap.put(new RangeKey(i, i+1000), (int) i + 1 /* <- arbitrary number as value for each item*/ );
            //rangeMap.put( i, i+1000, (int)i -999);
        }
        return rangeMap;
        /*int progress = 0;
        for (var i : rangeMap.entrySet()){
            val = i.getKey()._start + 159; //creating a key that is inside the range to lookup - tests that keys inside range will find the value for that range
            int value1 = rangeMap.get(val);
            System.out.println(value1);
            //val2 = i.getKey()._start + 305;
            //int value2 = rangeMap.getValue(val2);
            progress += 1;

            //if (progress % 200 == 0){
                //System.out.println(progress);
            //}

            //System.out.println(value2);
        }
        System.out.println("\ntotal iterations:");
        System.out.println(progress);
         */
    }

    /**METHOD main describes the program and presents a menu for the user to choose which test to demonstrate.
     *
     * @param args
     */

    public static void main (String[] args){
        System.out.println("\n****RangeMap Demo****\n\nRangeMap is a Java Collection type that extends LinkedHashMap " +
                "where the key is a range\nof numeric values, and the value is any Object. Every value inside " +
                "each Range-key points\nto a singular Object-value in system memory, allowing billions " +
                "of key/value pairs to be\nsearched quickly without taking up space in memory.\n\n" +
                "RangeMap uses the ARange class, which is currently just an object that holds two values\n\n\n");
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("Select 1, 2, or 3...\n1. generate two entries (2000 k/v pairs) in RangeMap, returns " +
                    "corresponding value from each entry (arbitrary number)\n2. generate 1 million entries " +
                    "(1 billion k/v pairs) in RangeMap, prints corresponding value (arbitrarily set to " +
                    "first number in range + 1) of any value input to console\n3. End Test");
            String inputString = input.nextLine();
            if (Objects.equals(inputString, "1")){
                long startTime = System.nanoTime();
                generate();
                getTimeElapsed(startTime);
            }
            if (Objects.equals(inputString, "2")){
                long startTime = System.nanoTime();
                RangeMap rangeMap = generate2();
                getTimeElapsed(startTime);
                while (true){
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("input any number between 0 (zero) and 1,000,000,000 (1 billion) " +
                            "to get a corresponding key (type q to quit):");
                    String input2String = input2.nextLine();
                    if (!input2String.equals("q")){
                        System.out.format("Value for that key: %d\n", rangeMap.get(Integer.parseInt(input2String)));
                    }
                    if (input2String.equals("q")){
                        break;
                    }
                }
            }
            if (Objects.equals(inputString, "3")){
                System.exit(0);
            }
            if (!Objects.equals(inputString, "1") && !Objects.equals(inputString, "2") && !Objects.equals(inputString, "3")){
                System.out.println("**invalid response**");
            }
        }
        //generate(); //two-entry, 2-thousand-pair test
        //generate2();  //1-million-entry, 1-billion-pair test
        //test();
    }
}
