//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarDotProduct extends InstrumentationTestCase {

    private final double DOUBLE_MAX_VALUE = 1.7976931348623157E308;
    private final double PRECISION = 1E-5;

    private NumberFormat formatter = new DecimalFormat("0.00000");

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //Valid Domain Tests follow

    @MediumTest
    //Test Case 13
    public void testDotProductValidInput() {
        PolarVector v1 = new PolarVector(3.4,0);
        PolarVector v2 = new PolarVector(2.6,30);
        Double exp = 4.42*Math.sqrt(3);
        Double res = v1.dot(v2);
        assertTrue(Math.abs(exp-res)/exp < PRECISION);
    }

    @MediumTest
    //Test Case 14
    public void testDotProductValidBoundaryInput() {
        PolarVector v1 = new PolarVector(Math.sqrt(DOUBLE_MAX_VALUE),0);
        PolarVector v2 = new PolarVector(Math.sqrt(DOUBLE_MAX_VALUE),0);
        Double exp = DOUBLE_MAX_VALUE;
        Double res = v1.dot(v2);
        assertTrue(Math.abs(exp-res)/exp < PRECISION);
    }
}
