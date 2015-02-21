//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarCrossProduct extends InstrumentationTestCase {

    private final double DOUBLE_MAX_VALUE = 1.7976931348623157E308;

    private void vectorAssertEquals(Vector v1, Vector v2) {
        assertEquals(v1.getX(), v2.getX());
        assertEquals(v1.getY(), v2.getY());
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //Valid Domain Tests follow

    @MediumTest
    //Test Case 15
    public void testCrossProductValidInput() {
        Vector v1 = new Vector(1,2);
        Vector v2 = new Vector(2,1);
        Vector v3 = new Vector(0,-3);
        Vector v = v1.cross(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 16
    public void testCrossProductValidBoundaryInput() {
        Vector v1 = new Vector(DOUBLE_MAX_VALUE,1);
        Vector v2 = new Vector(1,1);
        Vector v3 = new Vector(0,DOUBLE_MAX_VALUE);
        Vector v = v1.cross(v2);
        vectorAssertEquals(v3, v);
    }
}
