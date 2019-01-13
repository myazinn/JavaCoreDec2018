package javase01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // find epsilon
        double eps = getEps();

        // find n from the inequality
        double nDouble = Math.sqrt(1 / eps) - 1;
        // find the smallest integer n
        int n = (int) nDouble + 1; // can be shortened to int n = (int) Math.sqrt(1 / eps);
        // print n
        System.out.println("n = " + n);
        // prints every ai
        printAi(n);

    }

    private static double getEps() {
        // ask user for epsilon and make sure that it's correct
        Scanner scanner = new Scanner(System.in);
        System.out.print("epsilon = ");
        double eps = scanner.nextDouble();
        System.out.println();
        if (eps < 0) {
            System.out.println("There is no such n");
        }
        return eps;
    }


    private static void printAi(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("a" + i + ": " + (1 / Math.pow(i+1, 2)));
        }
    }
}
