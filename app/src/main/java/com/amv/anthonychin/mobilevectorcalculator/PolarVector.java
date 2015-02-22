//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PolarVector {
    private double r; //magnitude
    private double t; //angle in degrees

    private static final double PRECISION = 1E-5;

    private NumberFormat formatter = new DecimalFormat("0.00000");

    public PolarVector(double r, double t) {
        this.r = r;
        this.t = t;
    }

    public double getR() {
        return r;
    }

    public double getT() {
        return t;
    }

    public Vector polar2cart(PolarVector v) {
        double rads = Math.toRadians(v.getT());
        double cos = Double.parseDouble(formatter.format(Math.cos(rads)));
        double sin = Double.parseDouble(formatter.format(Math.sin(rads)));
        return new Vector(v.getR() * cos, v.getR() * sin);
    }

    public PolarVector cart2polar (Vector v) {
        double t = 0;
        if(Math.abs(v.getX())>=PRECISION && Math.abs(v.getY())>=PRECISION) {
            t = Math.toDegrees(Math.atan(v.getY() / v.getX()));
        } else if (Math.abs(v.getY())<PRECISION) {
            if (v.getX() < 0) {
                t = 180;
            }
        } else {
            if (v.getY() > 0) {
                t = 90;
            } else if(v.getY() < 0) {
                t = 270;
            }
        }
        double r;
        if (t==0) {
            r = v.getX();
        } else if (t==90) {
            r = v.getY();
        } else if (t==180) {
            r = -v.getX();
        } else if (t==270) {
            r = -v.getY();
        } else {
            r = Math.sqrt(v.dot(v));
        }
        return new PolarVector(r,t);
    }

    //Adds this vector to another and returns the resultant vector
    public PolarVector add(PolarVector v1) {
        Vector va = polar2cart(this);
        Vector vb = polar2cart(v1);
        Vector vres = va.add(vb);
        return cart2polar(vres);
    }

    //Adds this vector to two other vectors and returns the resultant vector
    public PolarVector add(PolarVector v1, PolarVector v2) {
        Vector va = polar2cart(this);
        Vector vb = polar2cart(v1);
        Vector vc = polar2cart(v2);
        Vector vres = va.add(vb,vc);
        return cart2polar(vres);
    }

    //Returns dot (scalar) product of this vector and another
    public double dot(PolarVector v1) {
        double rads = Math.toRadians(this.getT() - v1.getT());
        return this.r * v1.getR() * Double.parseDouble(formatter.format(Math.cos(rads)));
    }

    /* Returns cross (vector) product of this vector and another.
     * The result of the cross product of 2d vectors is of the form (0, 0, k),
     * instead we are returning it as (0, k) for the sake of simplicity.
     */
    public PolarVector cross(PolarVector v1) {
        double rads = Math.toRadians(this.getT() - v1.getT());
        double k = this.r * v1.getR() * Double.parseDouble(formatter.format(Math.sin(rads)));
        return new PolarVector(0, k);
    }
}
