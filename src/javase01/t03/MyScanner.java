package javase01.t03;

import java.util.Scanner;

/* this class exists only because I wanted to practice
and to use my own class; It can read new values from a user and nothing more
 */
class MyScanner {

    private Scanner scanner;

    MyScanner() {
        scanner = new Scanner(System.in);
    }

    double getVal(char ch){
        System.out.print(ch + " = ");
        return scanner.nextDouble();
    }
}
