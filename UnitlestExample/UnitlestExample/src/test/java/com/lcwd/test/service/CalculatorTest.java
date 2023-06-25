package com.lcwd.test.service;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void addTwoNumberTest(int a,int b){
        int result = Calculator.addTwoNumber(12, 45);
        int expected=57;
        Assert.assertEquals(expected,result);
    }
}
