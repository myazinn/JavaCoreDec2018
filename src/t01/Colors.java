package t01;

public enum Colors {
    BLUE, BLACK, RED, GREEN, YELLOW, PURPLE, ORANGE;

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}

