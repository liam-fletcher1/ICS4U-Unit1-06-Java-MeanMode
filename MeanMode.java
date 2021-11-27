/*
 * This is a program that calculates mean and median 
 *
 * @author Liam Fletcher
 * @version 1.0
 * @since   2021-11-27
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This is a program that calculates mean and median 
 */
final class MeanMode {
    /**
     * Prevent instantiation
     *
     * @throws IllegalStateException
     *
     */
    private MeanMode() {
        throw new IllegalStateException("Cannot be instantiated");
    }
    /**
     * The mean function.
     *
     * @param arrayOfInts the collection of integers
     * @param numberOf the number of integers in the array
     * @return the mean of the integers
     */
    public static double mean(final Integer[] arrayOfInts,
        final Integer numberOf) {
        double mean = 0;
        for (int meanAns = numberOf - 1; meanAns != -1; meanAns--) {
            mean = mean + arrayOfInts[meanAns];
        }
        mean = mean / numberOf;
        return mean;
    }
    /**
     * The median function.
     *
     * @param arrayOfIntes the collection of integers
     * @param numberOf the number of integers in the array
     * @return the median of the integers
     */
    public static double median(final Integer[] arrayOfInts,
        final double numberOf) {
        double median = 0;
        final double ex = 0.5;
        Arrays.sort(arrayOfInts);
        if (numberOf % 2 == 0) {
            median = arrayOfInts[(int)(numberOf / 2.0)];
        } else {
            median = ((arrayOfInts[(int)(numberOf / 2 - ex)]) +
                (arrayOfInts[(int)(numberOf / 2 + ex)])) / 2;
        }
        return median;
    }
    /**
     * The starting main function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        // Variables
        Integer tempNum;
        Integer numbVal = 0;
        // Making an array.
        final ArrayList < Integer > listNumb = new ArrayList < Integer > ();
        final Path filePath = Paths.get("./", args[0]);
        final Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(
            filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNum = Integer.parseInt(line);
                listNumb.add(tempNum);
                numbVal = numbVal + 1;
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }
        final Integer[] arrayNumb = listNumb.toArray(new Integer[0]);
        Arrays.sort(arrayNumb);
        System.out.println(Arrays.toString(arrayNumb));

        System.out.println("\nCalculating stats...");
        final double mean = mean(arrayNumb, numbVal);
        final double median = median(arrayNumb, numbVal);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);

        System.out.println("\nDone.");
    }
}
