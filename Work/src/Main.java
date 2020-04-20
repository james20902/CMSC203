import Implementations.Assignment5.TwoDimRaggedArrayUtility;
import Labs.Lab3.MovieDriver;

import java.io.File;

public class Main {
    //this class is only for testing, no important code here

    public static void main(String[] args){
        double[][] dataSet1 = {
                {1,2,3},
                {4,5},
                {6,7,8}
        };

        System.out.println(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0));
    }
}
