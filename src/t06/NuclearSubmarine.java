package t06;

public class NuclearSubmarine implements Runnable {

    private NuclearSubmarineEngine engine;
    private String code;
    private boolean stop = false;

    NuclearSubmarine(int power, String codename) {
        power = Math.abs(power) > 100 ? 100 : Math.abs(power);
        engine = new NuclearSubmarineEngine(power);
        code = codename;
    }

    public void run() {
        while (!stop) {
            int sleepTime = 20 * (150 - engine.getPower());
            sendStatus(code);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
        System.out.println("Ok, I'm going home");
    }

    public void stop() {
        stop = true;
    }

    private void sendStatus(String code) {
        System.out.println(code + " is alive");
    }


    class NuclearSubmarineEngine {

        private int power;

        NuclearSubmarineEngine(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }
}
