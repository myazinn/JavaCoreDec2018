package t06;

import java.util.Scanner;

public class NuclearSubmarineDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a codename of the nuclear submarine");
        String codename = scanner.nextLine();

        System.out.println("Enter a power of submarine engine (from 0 to 100)");
        int power = scanner.nextInt();
        System.out.println();

        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine(power, codename);
        Thread submarineThread = new Thread(nuclearSubmarine);

        System.out.println("Nuclear submarine is departing.");
        submarineThread.start();
        System.out.println("You can stop her at any moment. Type \'stop\' to stop her");

        while (submarineThread.isAlive()) {
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("stop")) {
                nuclearSubmarine.stop();
                try {
                    submarineThread.join();
                } catch (InterruptedException exc){}
                System.out.println("Bye!");
            }
        }
    }
}
