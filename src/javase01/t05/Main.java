package javase01.t05;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // create new array of given size
        Array array = new Array(getSize());

        // print that array
        array.print();
    }

    // to create an array we must know its size
    // getLength returns the size of array
    private static int getSize() {
        int n = 0;
        while (n <= 0){
            System.out.println("Enter the size of the array (n > 0)");
            System.out.print("n = ");
            n = scanner.nextInt();
        }

        return n;
    }
}
