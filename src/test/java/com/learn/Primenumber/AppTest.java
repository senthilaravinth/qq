package com.learn.Primenumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testIsPrimeWithValidPrimes() {
        // These should return true
        assertTrue(App.isPrime(2), "2 should be prime");
        assertTrue(App.isPrime(7), "7 should be prime");
        assertTrue(App.isPrime(13), "13 should be prime");
        assertTrue(App.isPrime(29), "29 should be prime");
    }

    @Test
    public void testIsPrimeWithNonPrimes() {
        // These should return false
        assertFalse(App.isPrime(1), "1 is not prime");
        assertFalse(App.isPrime(4), "4 is not prime");
        assertFalse(App.isPrime(10), "10 is not prime");
        assertFalse(App.isPrime(-5), "Negative numbers are not prime");
    }
}
