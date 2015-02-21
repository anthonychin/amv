package com.amv.anthonychin.mobilevectorcalculator;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //Adds this vector to another and returns the resultant vector
    public Vector add(Vector v1) {
        return null;
    }

    //Adds this vector to two other vectors and returns the resultant vector
    public Vector add(Vector v1, Vector v2) {
        return null;
    }

    //Returns dot (scalar) product of this vector and another
    public double dot(Vector v1) {
        return 0.0;
    }

    /* Returns cross (vector) product of this vector and another.
     * The result of the cross product of 2d vectors is of the form (0, 0, k),
     * instead we are returning it as (0, k) for the sake of simplicity.
     */
    public Vector cross(Vector v1) {
        return null;
    }
}