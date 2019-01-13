package javase01.t04;

import java.util.Scanner;

class Array {
    private Scanner scanner = new Scanner(System.in);
    private double[] array;
    private int length;

    // create an array of given length
    Array(int length) {
        array = new double[length];
        this.length = length;
    }

    // fill array with values from user
    void fill() {
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextDouble();
        }
    }

    // find the maximum sum of symmetrically arranged elements
    double maxSum() {
        // initial value;
        double max = array[0] + array[length-1];

        for (int i = 0; i < length/2; i++) {
            max = Math.max(max, array[i]+array[length-1 - i]);
        }
        return max;
    }


}
