package Implementations.Assignment5;

/**
 * Utility class for computing the holiday bonus for stores
 *
 * @author James Pham
 */
public class HolidayBonus {

    /**
     * Given a 2D array compute the holiday bonuses for each store based on categories
     * @param data data to process
     * @param high high value bonus
     * @param low low value bonus
     * @param other default value bonus
     * @return an array representing each stores bonus by category
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other){
        double[] bonuses = new double[data.length];

        //find max # of categories
        int maxCol = 0;
        for (int i = 0;i < data.length;i++) {
            if (maxCol < data[i].length) {
                maxCol = data[i].length;
            }
        }
        //iterate through array
        for (int j = 0;j < maxCol;j++) {
            //add all bonuses
            for (int i = 0;i < data.length;i++) {
                bonuses[i] += other;
            }
            //assuming the high bonus will always be greater than other
            //and the low bonus will always be less than other
            //add or subtract to factor in bonus
            bonuses[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j)] += (high - other);
            bonuses[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j)] -= (other - low);
        }
        return bonuses;
    }

    /**
     * Given a 2D array compute the holiday bonuses for each store based on categories
     * @param data data to process
     * @param high high value bonus
     * @param low low value bonus
     * @param other default value bonus
     * @return an array representing each stores bonus by category
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other){
        double total = 0;
        for(double element : calculateHolidayBonus(data, high, low, other)){
            total += element;
        }
        return total;
    }

}
