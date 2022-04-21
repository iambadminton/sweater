package com.example.sweater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class YetAnotherTest {
    @Test
    public void test1() {
        assertEquals(3, 3);
    }

    @Test
    public void test2() {
        assumeTrue("123".equals("123"));
    }
}
