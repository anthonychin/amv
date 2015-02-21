//Author: Andrew Walker - 260481626

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
        double i = this.x + v1.getX();
        double j = this.y + v1.getY();
        return new Vector(i,j);
    }

    //Adds this vector to two other vectors and returns the resultant vector
    public Vector add(Vector v1, Vector v2) {
        double i = this.x + v1.getX() + v2.getX();
        double j = this.y + v1.getY() + v2.getY();
        return new Vector(i,j);
    }

    //Returns dot (scalar) product of this vector and another
    public double dot(Vector v1) {
        return (this.x * v1.getX() + this.y * v1.getY());
    }

    /* Returns cross (vector) product of this vector and another.
     * The result of the cross product of 2d vectors is of the form (0, 0, k),
     * instead we are returning it as (0, k) for the sake of simplicity.
     */
    public Vector cross(Vector v1) {
        double k = this.x * v1.getY() - this.y * v1.getX();
        return new Vector(0,k);
    }
}
