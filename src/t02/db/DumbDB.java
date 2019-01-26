package t02.db;

import t02.Employee;

import java.util.HashMap;

public class DumbDB {
    private int id;

    private HashMap<Integer, Employee> dumbDB = new HashMap<>();

    /**
     * add new employee to database
     * @param name name of the new employee
     * @see Employee#Employee(String, int)
     */
    public void addEmployee(String name) {
        dumbDB.put(++id, new Employee(name, id));
        System.out.println("Employee " + name + " added to database. His ID = " + id + ".");
    }

    /**
     * give stationery to the employee
     * @param employeeID ID of the employee
     * @param what stationery you want to give him
     * @param howMuch how much of this stationery you want to give him
     */
    public void giveStationeryToEmployee(int employeeID, String what, int howMuch) {
        dumbDB.get(employeeID).addStationery(what, howMuch);
    }

    /**
     * take stationery from the employee
     * @param employeeID ID of the employee
     * @param what stationery you want to take from him
     * @param howMuch how much of this stationery you want to take from him
     */
    public void takeStationeryFromEmployee(int employeeID, String what, int howMuch) {
        dumbDB.get(employeeID).removeStationery(what, howMuch);
    }

    /**
     * check if database contains employee with this ID
     * @param employeeID ID of the employee you want to check
     * @return true if contains; else otherwise
     */
    public boolean containsEmployee(int employeeID) {
        return dumbDB.containsKey(employeeID);
    }

    /**
     * get a certain employee from database
     * @param employeeID ID of the employee you want to get
     * @return a copy of that employee
     */
    public Employee getEmployee(int employeeID) {
        return new Employee(dumbDB.get(employeeID));
    }

    /**
     * get all employees from database
     * @return an array that contains the copies of all employees
     */
    public Employee[] getAll() {
        Employee[] all = new Employee[dumbDB.size()];
        int j = 0;
        for (int i : dumbDB.keySet()) {
            all[j++] = getEmployee(i);
        }
        return all;
    }

}
