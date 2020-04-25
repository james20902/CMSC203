package Labs.Lab11;

import java.text.DecimalFormat;

public class Function3 extends Function{

    @Override
    public String answerString(double optVal, double x, double y, double z) {
        DecimalFormat myFormat = new DecimalFormat("#.00");;
        return "Minimum distance to (0,1) is " + myFormat.format(optVal) + " at the points (" +
                myFormat.format(x) + ","+ myFormat.format(y) + ") and (" + myFormat.format(-x) + "," + myFormat.format(y) + ")";
    }

    @Override
    public double fnValue(double x) {
        return Math.sqrt(Math.pow(x, 4) - Math.pow(x, 2) + 1);
    }

    @Override
    public double getXVal(double x) {
        return x;
    }

    @Override
    public double getYVal(double x) {
        return x*x;
    }

    @Override
    public double getZVal(double x) {
        return -1;
    }

    @Override
    public String toString() {
        return "Find the minimum distance between the function f(x) = x^2 and the point (0.1)\n"
                + "This distance is described by the function d(x) = sqrt(x^4-x^2+1)";
    }

}
