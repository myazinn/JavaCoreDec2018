package t01;

class PenDemo {
    public static void main(String[] args) {
        Pen redPen = new Pen("red", "fountain");
        Pen bluePen = new Pen(Colors.BLUE, PenTypes.GEL);

        try {
            redPen.write("I'm done!");
        } catch (EmptyPenException exc) {
            System.out.println(exc);
        }

        System.out.println(redPen);
        System.out.println(bluePen);
    }
}
