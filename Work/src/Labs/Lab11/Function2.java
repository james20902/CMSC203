package Labs.Lab11;

import java.text.DecimalFormat;

public class Function2 extends Function{

    @Override
    public String answerString(double optVal, double x, double y, double z) {
        DecimalFormat myFormat = new DecimalFormat("#.00");;
        return "Minimum time is " + myFormat.format(optVal) + " to jump in the ocean at a point "
                + myFormat.format(x) + "m from the start point";
    }

    @Override
    public double fnValue(double x) {
        return (x/3) + (2 *  Math.sqrt((x * x)- 8 * x + 25));
    }

    @Override
    public double getXVal(double x) {
        return x;
    }

    @Override
    public double getYVal(double x) {
        return -1;
    }

    @Override
    public double getZVal(double x) {
        return -1;
    }

    @Override
    public String toString() {
        return "Minimize the time it takes a dog to run and swim to retrieve a ball in the ocean";
    }

}
