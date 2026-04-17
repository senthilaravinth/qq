package com.learn.Primenumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testPrimes() {
        // Syntax: assertTrue(condition, "message")
        assertTrue(App.isPrime(7), "7 should be prime");
        assertTrue(App.isPrime(13), "13 should be prime");
    }

    @Test
    public void testNonPrimes() {
        assertFalse(App.isPrime(4), "4 is not prime");
        assertFalse(App.isPrime(10), "10 is not prime");
        assertFalse(App.isPrime(1), "1 is not prime");
    }
}