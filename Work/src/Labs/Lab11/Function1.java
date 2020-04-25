package Labs.Lab11;

import java.text.DecimalFormat;

public class Function1 extends Function{

    @Override
    public String answerString(double optVal, double x, double y, double z) {
        DecimalFormat myFormat = new DecimalFormat("#.00");;
        return "Minimum cost is $" + myFormat.format(optVal) + " with height = " + myFormat.format(y)
                + "cm and radius = " + myFormat.format(x) + "cm";
    }

    @Override
    public double fnValue(double x) {
        if (x <= 0.0)
            return Double.MAX_VALUE;
        else
            return (0.8 * Math.PI * (x * x)) + (800/x);
    }

    @Override
    public double getXVal(double x) {
        return x;
    }

    @Override
    public double getYVal(double x) {
        return 2000/(Math.PI * (x * x));
    }

    @Override
    public double getZVal(double x) {
        return -1.0;
    }

    @Override
    public String toString() {
        return "Minimize the cost of a can that will hold 2 liters of liquid";
    }

}
