package t01;

import java.util.Objects;

/**
 * Describes a regular pen with specified color and type.
 *
 * Pen can be any defined in {@link t01.Colors Colors} color and any defined in {@link t01.Types Types} type.
 * Since an amount of ink in a pen is limited, you can write only limited amount of letters.
 *
 */
public class Pen {
    private Colors color;
    private Types type;
    private int inkRemain;

    public Pen(Colors color, Types type) {
        this.color = color;
        this.type = type;
        this.inkRemain = 1000;
    }
    public Pen(Pen pen) {
        this(pen.color, pen.type);
    }
    public Pen(String color, String type) {
        this(Colors.valueOf(color.toUpperCase()), Types.valueOf(type.toUpperCase()));
    }
    public Pen() {
        this(Colors.BLUE, Types.BALLPOINT);
    }

    public int getInkRemain() {
        return inkRemain;
    }
    public Colors getColor() {
        return color;
    }
    public Types getType() {
        return type;
    }

    /**
     * Allows you to write a word using this pen
     * @param phrase the phrase you want to write
     * @return the amount of letters you can write
     * @throws EmptyPenException
     */
    public int write(String phrase) throws EmptyPenException {

        long amountOfLetters = phrase
                .chars()
                .filter((ch) -> ch != ' ')
                .count();

        if (amountOfLetters <= inkRemain) {
            System.out.println(phrase);
            inkRemain -= amountOfLetters;
            return inkRemain;
        } else {
            throw new EmptyPenException(inkRemain);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return inkRemain == pen.inkRemain &&
                color == pen.color &&
                type == pen.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, inkRemain);
    }

    @Override
    public String toString() {
        return "This is a "
                + color.toString().toLowerCase() + " "
                + type.toString().toLowerCase() + " pen "
                + "using which you can write " + inkRemain + " letter(s)";
    }
}
