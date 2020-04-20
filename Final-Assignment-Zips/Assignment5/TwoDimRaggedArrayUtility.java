package Implementations.Assignment5;

import java.io.*;
import java.util.Arrays;

/**
 * Utility class to more efficiently process 2D arrays
 *
 * @author James Pham
 */
public class TwoDimRaggedArrayUtility {

    /**
     * Iterate through whole array and get sum of all elements
     * @param array data to process
     * @return the total of all elements in array
     */
    public static double getTotal(double[][] array){
        double sum = 0;
        for(double[] nestedArray : array){
            for(double element : nestedArray){
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Iterate through whole array and get average of all elements
     * @param array data to process
     * @return the average of all elements in array
     */
    public static double getAverage(double[][] array){
        double sum = 0;
        double count = 0;
        for(double[] nestedArray : array){
            for(double element : nestedArray){
                sum += element;
                count++;
            }
        }
        return sum / count;
    }

    /**
     * Iterate through specific column to find total
     * @param array data to process
     * @param col column to analyze
     * @return the total of all elements in specific column
     */
    public static double getColumnTotal(double[][] array, int col){
        double sum = 0;
        for (double[] doubles : array) {
            try {
                sum += doubles[col];
                //if a specific row isnt long enough to hit the column just ignore it
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
        return sum;
    }

    /**
     * Iterate through specific row to find total
     * @param array data to process
     * @param row row to analyze
     * @return the total of all elements in specific row
     */
    public static double getRowTotal(double[][] array, int row){
        double sum = 0;
        for(int i = 0; i < array[row].length; i++){
            sum += array[row][i];
        }
        return sum;
    }

    /**
     * Iterate through array to find highest element
     * @param array data to process
     * @return Highest element present in array
     */
    public static double getHighestInArray(double[][] array){
        double targetValue = array[0][0];
        for(double[] nestedArray : array){
            for(double element : nestedArray){
                if(element > targetValue){
                    targetValue = element;
                }
            }
        }
        return targetValue;
    }

    /**
     * Iterate through array to find lowest element
     * @param array data to process
     * @return Lowest element present in array
     */
    public static double getLowestInArray(double[][] array){
        double targetValue = array[0][0];
        for(double[] nestedArray : array){
            for(double element : nestedArray){
                if(element < targetValue){
                    targetValue = element;
                }
            }
        }
        return targetValue;
    }

    /**
     * Iterate through array to find the index of the highest element in specified row
     * @param array data to process
     * @param row row to analyze
     * @return The index of the highest element in specific row
     */
    public static int getHighestInRowIndex(double[][] array, int row){
        int index = 0;
        double targetValue = array[row][0];
        for(int i = 0; i < array[row].length; i++){
            if(array[row][i] > targetValue){
                index = i;
                targetValue = array[row][i];
            }
        }
        return index;
    }

    /**
     * Iterate through array to find the index of the lowest element in specified row
     * @param array data to process
     * @param row row to analyze
     * @return The index of the lowest element in specific row
     */
    public static int getLowestInRowIndex(double[][] array, int row){
        int index = 0;
        double targetValue = array[row][0];
        for(int i = 0; i < array[row].length; i++){
            if(array[row][i] < targetValue){
                index = i;
                targetValue = array[row][i];
            }
        }
        return index;
    }

    /**
     * Iterate through array to find the index of the highest element in specified column
     * @param array data to process
     * @param col column to analyze
     * @return The index of the highest element in specific column
     */
    public static int getHighestInColumnIndex(double[][] array, int col){
        int index = 0;
        double targetValue = array[0][col];
        for(int i = 0; i < array.length; i++){
            try {
                if(array[i][col] > targetValue){
                    index = i;
                    targetValue = array[i][col];
                }
                //if a specific row isnt long enough to hit the column just ignore it
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }
        return index;
    }

    /**
     * Iterate through array to find the index of the lowest element in specified column
     * @param array data to process
     * @param col column to analyze
     * @return The index of the lowest element in specific column
     */
    public static int getLowestInColumnIndex(double[][] array, int col){
        int index = 0;
        double targetValue = array[0][col];
        for(int i = 0; i < array.length; i++){
            try {
                if(array[i][col] < targetValue){
                    index = i;
                    targetValue = array[i][col];
                }
                //if a specific row isnt long enough to hit the column just ignore it
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }
        return index;
    }

    /**
     * Get the highest element in specified row
     * @param array data to process
     * @param row row to analyze
     * @return the element at the specified row and the column containing the highest index
     */
    public static double getHighestInRow(double[][] array, int row){
        return array[row][getHighestInRowIndex(array, row)];
    }

    /**
     * Get the lowest element in specified row
     * @param array data to process
     * @param row row to analyze
     * @return the element at the specified row and the column containing the lowest index
     */
    public static double getLowestInRow(double[][] array, int row){
        return array[row][getLowestInRowIndex(array, row)];
    }

    /**
     * Get the highest element in specified column
     * @param array data to process
     * @param col column to analyze
     * @return the element at the specified column and the row containing the highest index
     */
    public static double getHighestInColumn(double[][] array, int col){
        return array[getHighestInColumnIndex(array, col)][col];
    }

    /**
     * Get the lowest element in specified column
     * @param array data to process
     * @param col column to analyze
     * @return the element at the specified column and the row containing the lowest index
     */
    public static double getLowestInColumn(double[][] array, int col){
        return array[getLowestInColumnIndex(array, col)][col];
    }

    /**
     * Create a 2D array with a given text file as data
     * @param file data to process
     * @return a 2D array of double elements
     */
    public static double[][] readFile(File file){
        try {
            //create an array of strings with each index representing a line
            String[] stringArray = new BufferedReader(new FileReader(file)).lines().toArray(String[]::new);
            //allocate enough memory for each line as a row
            double[][] result = new double[stringArray.length][0];
            //for every row
            for(int i = 0; i < result.length; i++){
                //replace the null array by parsing each string generated by the split as a double and
                //reconstructing an a new array from a stream
                result[i] = Arrays.stream(stringArray[i].split(" ")).mapToDouble(Double::parseDouble).toArray();
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Given a 2D array and file, write the contents of the array to the file
     * @param data data to process
     * @param outputFile The file to write the array to
     */
    public static void writeToFile(double[][] data, File outputFile){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            StringBuilder build = new StringBuilder();
            //for every array
            for(double[] line : data){
                //for every element in row
                for(double element : line){
                    //construct new string
                    build.append(element).append(" ");
                }
                //write line
                writer.write(build.toString());
                writer.flush();
                //clear buffer
                build.setLength(0);
                writer.newLine();
            }
        } catch (IOException ignored) {}
    }





}
