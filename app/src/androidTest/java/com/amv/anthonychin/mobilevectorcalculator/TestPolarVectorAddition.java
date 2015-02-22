//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarVectorAddition extends InstrumentationTestCase {
    private final double DOUBLE_MAX_VALUE = 1.7976931348623157E308;
    private final double PRECISION = 1E-5;

    private void vectorAssertEquals(PolarVector v1, PolarVector v2) {
        assertEquals(v1.getR(), v2.getR(), PRECISION);
        assertEquals(v1.getT(), v2.getT(), PRECISION);
    }

    private void vectorAssertEquals(Vector v1, Vector v2) {
        assertEquals(v1.getX(), v2.getX(), PRECISION);
        assertEquals(v1.getY(), v2.getY(), PRECISION);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //Valid Domain Tests follow

    @MediumTest
    //Test Case 9
    public void testPolarVectorAddition2ValidInput() {
        PolarVector v1 = new PolarVector(1,0);
        PolarVector v2 = new PolarVector(1,90);
        PolarVector v3 = new PolarVector(Math.sqrt(2),45);
        PolarVector v = v1.add(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 10
    public void testPolarVectorAddition2ValidBoundaryInput() {
        PolarVector v1 = new PolarVector(DOUBLE_MAX_VALUE/2.0,0);
        PolarVector v2 = new PolarVector(DOUBLE_MAX_VALUE/2.0,0);
        PolarVector v3 = new PolarVector(DOUBLE_MAX_VALUE,0);
        PolarVector v = v1.add(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 11
    public void testPolarVectorAddition3ValidInput() {
        PolarVector v1 = new PolarVector(1,0);
        PolarVector v2 = new PolarVector(1,90);
        PolarVector v3 = new PolarVector(Math.sqrt(2),45);
        PolarVector v4 = new PolarVector(2*Math.sqrt(2),45);
        PolarVector v = v1.add(v2, v3);
        vectorAssertEquals(v4, v);
    }

    @MediumTest
    //Test Case 12
    public void testPolarVectorAddition3ValidBoundaryInput() {
        PolarVector v1 = new PolarVector(DOUBLE_MAX_VALUE,0);
        PolarVector v2 = new PolarVector(DOUBLE_MAX_VALUE,180);
        PolarVector v3 = new PolarVector(DOUBLE_MAX_VALUE,270);
        PolarVector v4 = new PolarVector(DOUBLE_MAX_VALUE,270);
        PolarVector v = v1.add(v2, v3);
        vectorAssertEquals(v4, v);
    }
}
