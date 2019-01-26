package t02.ui;

import t02.Stationery;
import t02.db.SmartDB;

class EmployeeMenu extends MenuTemplate {

    EmployeeMenu(SmartDB smartDB) {
        super(smartDB);
    }

    /**
     * print menu and wait for reaction
     */
    void createMenu() {
        int action = 0;
        int id = getId();
        String[] commands = new String[] {
                "show info about employee",
                "give employee a stationery",
                "take a stationery from employee",
                "back"
        };
        while (action != 4) {
            commandPrinter(commands);
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    showEmployeeInfo(id);
                    break;
                case 2:
                    giveStationeryToEmployee(id);
                    break;
                case 3:
                    takeStationeryFromEmployee(id);
            }
        }

    }

    private void showEmployeeInfo(int id) {
        smartDB.showEmployeeInfo(id);
        smartDB.showTotalEmployeeCost(id);
    }

    private void giveStationeryToEmployee(int id) {
        System.out.println("You can give him the following :");
        for (Stationery stationery : Stationery.values()) {
            System.out.print(stationery.toString() + "   ");
        }

        String stationery = getStationery();
        int amount = getAmount();

        smartDB.giveStationeryToEmployee(id, stationery, amount);
    }

    private void takeStationeryFromEmployee(int id) {
        smartDB.showEmployeeInfo(id);
        System.out.println("You can take one of items above.");

        String stationery = getStationery();
        int amount = getAmount();

        smartDB.takeStationeryFromEmployee(id, stationery, amount);
    }
}
