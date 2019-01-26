package t02.db;

import t02.Employee;

import java.util.Arrays;

public class SmartDB extends DumbDB {
    /**
     * prints Name, ID and all stationery of a certain employee
     * @param employeeID ID of a certain employee
     */
    public void showEmployeeInfo(int employeeID) {
        if (containsEmployee(employeeID)) {
            Employee employee = getEmployee(employeeID);
            System.out.println();
            System.out.println("Stationery of employee "
                    + employee
                    + " :");
            employee.getAllStationery();
        } else {
            System.out.println("There is no such employee");
        }
    }

    /**
     * prints total cost of all stationery of a certain employee
     * @param employeeID ID of a certain employee
     * @see Employee#totalCost()
     */
    public void showTotalEmployeeCost(int employeeID) {
        if (containsEmployee(employeeID)) {
            Employee employee = getEmployee(employeeID);
            System.out.println("Total cost of all stationery of the "
                    + employee
                    + " - " + employee.totalCost()
                    + " roubles");
        } else {
            System.out.println("There is no such employee");
        }
    }

    /**
     * print name and ID of every employee
     * @see Employee#toString()
     */
    public void showAllEmployees() {
        Arrays
                .stream(getAll())
                .forEach(System.out::println);
    }
}
