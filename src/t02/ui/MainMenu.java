package t02.ui;

import t02.Stationery;
import t02.db.SmartDB;

class MainMenu extends MenuTemplate {

    MainMenu(SmartDB smartDB) {
        super(smartDB);
    }

    /**
     * print menu and wait for reaction
     */
    void createMenu() {
        String[] commands = new String[]{
                "add an employee",
                "to a certain employee",
                "show all employees",
                "show all stationery",
                "exit"};
        int action = 0;
        while (action != 5) {
            commandPrinter(commands);
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    addEmployeeMenu();
                    break;
                case 2:
                    EmployeeMenu employeeMenu = new EmployeeMenu(smartDB);
                    employeeMenu.createMenu();
                    break;
                case 3:
                    showAllEmployees();
                    break;
                case 4:
                    showStationeryInfo();
                    break;
            }
        }
    }

    private void addEmployeeMenu(){
        System.out.println("Enter the name of new employee");
        String name = scanner.next();
        smartDB.addEmployee(name);
        System.out.println();
    }

    private void showAllEmployees() {
        smartDB.showAllEmployees();
    }


    private void showStationeryInfo() {
        for (Stationery stationery : Stationery.values()) {
            System.out.println(stationery.toString().toLowerCase()
                    + " costs "
                    + stationery.getPrice()
                    + " roubles");
        }
    }
}
