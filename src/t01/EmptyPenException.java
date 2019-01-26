package t01;

class EmptyPenException extends Exception {
    private int remain;
    EmptyPenException(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString(){
        return "NOT ENOUGH INK.\nYou can't write more than " + remain + " letter(s) using this pen";
    }
}
