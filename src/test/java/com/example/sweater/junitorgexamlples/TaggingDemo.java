package com.example.sweater.junitorgexamlples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("fast")
@Tag("model")
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Learning JUnit5")
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class TaggingDemo {

    @Test
    @Tag("method_1")
    @Order(1)
    void testingTaxCalculation() {
        assertEquals(2+1, 3);
    }

    @Test
    @Tag("method_2")
    @Order(3)
    void anySumTest() {
        assertEquals(2*5, 10);
    }

    @BeforeAll
    static void init() {
        System.out.println("Call init() method.");
    }

    @Test
    @Order(2)
    public void getEnvTest() {
        assumeTrue(System.getenv("ENV").equals("TEST"));
    }

    @Test
    @EnabledIf("customCondition")
    public void printSentence() {
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
    }

    boolean customCondition() {
        return false;
    }

}
