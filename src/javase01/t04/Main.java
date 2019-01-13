package javase01.t04;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //create an array
        Array array = new Array(getLength());
        //fill it with values
        array.fill();
        // print the maximum sum
        System.out.println(array.maxSum());
    }

    // to create an array we must know its length
    // getLength returns the length of array
    private static int getLength() {
        int n = 0;
        while (n <= 0){
            System.out.println("Enter the length of the array (n > 0)");
            System.out.print("n = ");
            n = scanner.nextInt();
        }
        return n;
    }
}
