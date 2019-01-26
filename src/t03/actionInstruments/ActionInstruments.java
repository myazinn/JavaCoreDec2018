package t03.actionInstruments;

import t03.StationeryClass;

abstract class ActionInstruments extends StationeryClass {
    ActionInstruments(int price, String name, String action) {
        super(price, name);
        this.action = action;
    }
    private String action;

    public String getAction() {
        return action;
    }
}
