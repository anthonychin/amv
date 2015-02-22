//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarCrossProduct extends InstrumentationTestCase {

    private final double DOUBLE_MIN_VALUE = 4.9E-324;
    private final double PRECISION = 1E-5;

    private void vectorAssertEquals(PolarVector v1, PolarVector v2) {
        assertEquals(v1.getR(), v2.getR(), PRECISION);
        assertEquals(v1.getT(), v2.getT(), PRECISION);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //Valid Domain Tests follow

    @MediumTest
    //Test Case 15
    public void testCrossProductValidInput() {
        PolarVector v1 = new PolarVector(1.9,135);
        PolarVector v2 = new PolarVector(1.3,45);
        PolarVector v3 = new PolarVector(0,2.47);
        PolarVector v = v1.cross(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 16
    public void testCrossProductValidBoundaryInput() {
        PolarVector v1 = new PolarVector(DOUBLE_MIN_VALUE*2,37.2);
        PolarVector v2 = new PolarVector(0.5,127.2);
        PolarVector v3 = new PolarVector(0,-DOUBLE_MIN_VALUE);
        PolarVector v = v1.cross(v2);
        vectorAssertEquals(v3, v);
    }
}
