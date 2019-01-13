package javase01.t03;

public class Main {
    public static void main(String[] args) {

        double epsilon = 1E-8;

        MyScanner myScanner = new MyScanner();

        // ask user for interval borders and step
        double a = myScanner.getVal('a');
        double b = myScanner.getVal('b');
        double h = myScanner.getVal('h');
        // check the borders
        if (a > b) {
            System.out.println("b should be greater than a");
            return;
        }

        System.out.println("arg\t\t\tval");

        // print the values of the function within [a, b] using step h
        // +epsilon needed to avoid problems with floating point numbers
        for (double i = a; i <= b+epsilon; i += h) {
            System.out.printf("%4.2f %10.2f %n", i, tanFunc(i));
        }
    }

    // function from the task
    static double tanFunc(double x) {
        return Math.tan(2 * x) - 3;
    }
}
