//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarDotProduct extends InstrumentationTestCase {

    private final double DOUBLE_MAX_VALUE = 1.7976931348623157E308;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //Valid Domain Tests follow

    @MediumTest
    //Test Case 13
    public void testDotProductValidInput() {
        Vector v1 = new Vector(1.1,3.5);
        Vector v2 = new Vector(-1,2);
        Double exp = 5.9;
        Double res = v1.dot(v2);
        assertEquals(exp, res);
    }

    @MediumTest
    //Test Case 14
    public void testDotProductValidBoundaryInput() {
        Vector v1 = new Vector(DOUBLE_MAX_VALUE/2.0,DOUBLE_MAX_VALUE/2.0);
        Vector v2 = new Vector(1,1);
        Double exp = DOUBLE_MAX_VALUE;
        Double res = v1.dot(v2);
        assertEquals(exp, res);
    }
}
