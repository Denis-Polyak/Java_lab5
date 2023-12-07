package com.example.lab5_try2;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Logic {
    public int count(double begin, double end, double h) {
        return (int) Math.round((end - begin) / h) + 1;
    }

    public double[] createX(double begin, double end, double h) {
        return new double[count(begin, end, h)];
    }

    public double functionY(double x, double a, double p) {
        double eps = 1.0E-4;
        double y;
        if (x<1.3-eps) return p*x*x-7/(x*x);
        else if (x>1.3+eps) return Math.log(x)+7*sqrt(abs(x+p));
        else return a*x*x*x+7*sqrt(x);
    }

    public double[] createFillX(double begin, double end, double h) {
        double[] xVal = createX(begin, end, h);
        for (int i = 0; i < xVal.length; i++) {
            xVal[i] = begin + i * h;
        }
        return xVal;
    }

    public double[] createFillY(double[] xVal, double a, double p) {
        double[] y = new double[xVal.length];
        for (int i = 0; i < y.length; ++i) {
            y[i] = functionY(xVal[i], a, p);
        }
        return y;
    }

    public double maxYNumber(double[] y) {
        double maxYNumber = 0;
        for (int k = 0; k < y.length; ++k) {
            if (y[k] > maxYNumber) {
                maxYNumber = y[k];
            }
        }
        return maxYNumber;
    }

    public double maxXNumber(double[] xVal) {
        double maxXNumber = 0;
        for (int k = 0; k < xVal.length; ++k) {
            if (xVal[k] > maxXNumber) {
                maxXNumber = xVal[k];
            }
        }
        return maxXNumber;
    }

    public double minYNumber(double[] y) {
        double minYNumber = 0.0;
        for (int i = 1; i < y.length; ++i) {
            if (y[i] < minYNumber) {
                minYNumber = y[i];
            }
        }
        return minYNumber;
    }

    public double minXNumber(double[] xVal) {
        double minXNumber = 0.0;
        for (int i = 1; i < xVal.length; ++i) {
            if (xVal[i] < minXNumber) {
                minXNumber = xVal[i];
            }
        }
        return minXNumber;
    }

    public double Sum(double[] y) {
        double Sum = 0.0;
        for (int i = 1; i < y.length; ++i) {
            Sum += y[i];
        }
        return Sum;
    }

    public double average(double[] y) {
        double avar = 0.0;
        for (int i = 0; i < y.length; ++i) {
            avar += y[i];
        }
        avar /= (double) y.length;
        return avar;
    }
}