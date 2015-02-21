//Author: Andrew Walker - 260481626

package com.amv.anthonychin.mobilevectorcalculator;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestPolarVectorAddition extends InstrumentationTestCase {
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
    //Test Case 9
    public void testVectorAddition2ValidInput() {
        Vector v1 = new Vector(1,0);
        Vector v2 = new Vector(0,1);
        Vector v3 = new Vector(1,1);
        Vector v = v1.add(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 10
    public void testVectorAddition2ValidBoundaryInput() {
        Vector v1 = new Vector(DOUBLE_MAX_VALUE,0);
        Vector v2 = new Vector(0,1);
        Vector v3 = new Vector(DOUBLE_MAX_VALUE,1);
        Vector v = v1.add(v2);
        vectorAssertEquals(v3, v);
    }

    @MediumTest
    //Test Case 11
    public void testVectorAddition3ValidInput() {
        Vector v1 = new Vector(1,0);
        Vector v2 = new Vector(0,1);
        Vector v3 = new Vector(1,1);
        Vector v4 = new Vector(2,2);
        Vector v = v1.add(v2, v3);
        vectorAssertEquals(v4, v);
    }

    @MediumTest
    //Test Case 12
    public void testVectorAddition3ValidBoundaryInput() {
        Vector v1 = new Vector(DOUBLE_MAX_VALUE,0);
        Vector v2 = new Vector(0,-1);
        Vector v3 = new Vector(0,1);
        Vector v4 = new Vector(DOUBLE_MAX_VALUE,0);
        Vector v = v1.add(v2, v3);
        vectorAssertEquals(v4, v);
    }
}
