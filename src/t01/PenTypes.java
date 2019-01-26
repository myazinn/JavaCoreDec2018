package t01;

public enum PenTypes {
    BALLPOINT, ROLLERBALL, FOUNTAIN, GEL;

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
