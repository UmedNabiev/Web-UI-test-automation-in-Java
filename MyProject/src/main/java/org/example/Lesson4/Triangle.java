package org.example.Lesson4;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws checkNumbersException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first side a = ");
        int a = sc.nextInt();
        System.out.print("Enter the second side b = ");
        int b = sc.nextInt();
        System.out.print("Enter the third side c = ");
        int c = sc.nextInt();
        sc.close();

        checkNumbers(a, b, c);

        if (isTriangle(a, b, c)) {
            System.out.println("The sides do not form a triangle");
        } else {
            System.out.println("Area of a triangle (main): " + areaTriangle(a, b, c));
        }
    }

    public static double areaTriangle(int a, int b, int c) {
    // Heron's formula is used to find the area of a triangle
    //  S = √(p*(p-a)*(p-b)*(p-c)), //where a, b, c - sides of a triangle,
    //p - semi-perimeter and equal to P = (a+b+c)/2
    double p = (double) (a + b + c) / 2;

    return (isTriangle(a, b, c)) ? 0 : Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static boolean isTriangle(int a, int b, int c) {
        // check if it's a triangle
        return (a + b < c || a + c < b || b + c < a);
    }

    // creating Exception checkNumbersException to check characters as a successor from Exception
    public static class checkNumbersException extends Exception {
        public checkNumbersException(String message) {
            super(message);
        }
    }

    // checking not null or negative
    public static void checkNumbers(int a, int b, int c) throws checkNumbersException {
        if (a <= 0 || b <= 0 || c <= 0) throw new checkNumbersException("The number cannot be zero or negative!");
    }
}
