//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

public class PolarVector {
    private double r; //magnitude
    private double t; //angle in degrees

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

    //Adds this vector to another and returns the resultant vector
    public PolarVector add(PolarVector v1) {
        return null;
    }

    //Adds this vector to two other vectors and returns the resultant vector
    public PolarVector add(PolarVector v1, PolarVector v2) {
        return null;
    }

    //Returns dot (scalar) product of this vector and another
    public double dot(PolarVector v1) {
        return 0.0;
    }

    /* Returns cross (vector) product of this vector and another.
     * The result of the cross product of 2d vectors is of the form (0, 0, k),
     * instead we are returning it as (0, k) for the sake of simplicity.
     */
    public PolarVector cross(PolarVector v1) {
        return null;
    }
}
