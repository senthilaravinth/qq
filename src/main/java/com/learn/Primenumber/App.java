package com.learn.Primenumber;

public class App {

    // Logic to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numberToCheck = 29; // You can change this number to test others
        
        System.out.println("--- Prime Number Checker ---");
        
        if (isPrime(numberToCheck)) {
            System.out.println(numberToCheck + " is a Prime Number.");
        } else {
            System.out.println(numberToCheck + " is NOT a Prime Number.");
        }
        
        System.out.println("----------------------------");
    }
}