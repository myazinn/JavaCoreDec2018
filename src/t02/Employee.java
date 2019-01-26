package t02;

import java.util.HashMap;

/**
 * Describes employees
 */
public class Employee {
    private int id;
    private String name;
    private HashMap<Stationery, Integer> stuff = new HashMap<>();

    /**
     * @param name Name of a new employee
     * @param ID His ID
     * @see #Employee(Employee)
     */
    public Employee(String name, int ID) {
        this.name = name;
        this.id = ID;
    }

    /**
     * Create new employee based on existing
     * @param employee existing employee
     * @see #Employee(String, int)
     */
    public Employee(Employee employee) {
        this.name = employee.name;
        this.id = employee.id;
        this.stuff = new HashMap<>(employee.stuff);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * allows to give employee the stationery
     * @param stationery what exactly you want to give him
     * @param amount amount of stationery
     * @see #addStationery(String, int)
     */
    public void addStationery(Stationery stationery, int amount) {
        if (stuff.containsKey(stationery)) {
            stuff.put(stationery, stuff.get(stationery) + amount);
        } else {
            stuff.put(stationery, amount);
        }
    }

    /**
     * allows to give employee the stationery
     * @param stationery what exactly you want to give him (case insensitive)
     * @param amount amount of stationery
     * @see #addStationery(Stationery, int)
     */
    public void addStationery(String stationery, int amount) {
        addStationery(Stationery.valueOf(stationery.toUpperCase()), amount);
    }

    /**
     * allows to take the stationery from employee
     * @param stationery what exactly you want to take from him
     * @param amount amount of stationery
     * @see #removeStationery(String, int)
     */
    public void removeStationery(Stationery stationery, int amount) {
        if (stuff.containsKey(stationery) && stuff.get(stationery) >= amount) {
            addStationery(stationery, -amount);
            if (stuff.get(stationery) == 0) {
                stuff.remove(stationery);
            }
        } else {
            System.out.println("Can't remove more than exist nor what does not exist");
        }
    }

    /**
     * allows to take the stationery from employee
     * @param stationery what exactly you want to take from him
     * @param amount amount of stationery
     * @see #removeStationery(Stationery, int)
     */
    public void removeStationery(String stationery, int amount) {
        removeStationery(Stationery.valueOf(stationery.toUpperCase()), amount);
    }

    /**
     * prints every stationery that employee have in format STATIONERY: amount
     */
    public void getAllStationery() {
        for (Stationery stationery : stuff.keySet()) {
            System.out.println(stationery + ": " + stuff.get(stationery) + " pc(s).");
        }
    }

    /**
     * @return total cost of all stationery
     */
    public int totalCost() {
        int sum = 0;
        for (Stationery stationery : stuff.keySet()) {
            sum += stuff.get(stationery) * stationery.getPrice();
        }
        return sum;
    }

    /**
     * @return String if format "Name (ID = id)"
     */
    @Override
    public String toString(){
        return name + " (ID = " + id + ")";
    }
}
