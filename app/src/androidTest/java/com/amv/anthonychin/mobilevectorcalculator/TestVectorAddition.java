package com.amv.anthonychin.mobilevectorcalculator;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.util.Vector;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestVectorAddition extends ApplicationTestCase<Application> {
    public TestVectorAddition() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    //Valid Domain Tests follow

    @MediumTest
    protected void testVectorAddition2ValidInput() {
        getContext();
    }

    @MediumTest
    protected void testVectorAddition2ValidBoundaryInput() {
        getContext();
    }

    @MediumTest
    protected void testVectorAddition3ValidInput() {
        getContext();
    }

    @MediumTest
    protected void testVectorAddition3ValidBoundaryInput() {
        getContext();
    }
}