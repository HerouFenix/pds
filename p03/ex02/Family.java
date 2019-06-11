package p03.ex02;

import java.util.ArrayList;
import java.util.List;

public class Family implements Comparable<Family> {
    /**
     * ATTRIBUTES
     */
    private List<String> familyMembers;
    private List<Integer> familyDoors;
    private int lastDoor;
    private int firstDoor;


    /**
     * CONSTRUCTORS
     */
    public Family(String name, int firstDoor, int lastDoor) {
        this.familyMembers = new ArrayList<>();
        this.familyMembers.add(name);

        List<Integer> doors = new ArrayList<>();
        for (int i = firstDoor; i < lastDoor + 1; i++) {
            doors.add(i);
        }

        this.familyDoors = doors;
        this.lastDoor = lastDoor;
        this.firstDoor = firstDoor;
    }


    /**
     * METHODS
     */
    public int getFamilySize() {
        return this.familyMembers.size();
    }

    public int getLastDoor() {
        return this.lastDoor;
    }

    public int getFirstDoor() {
        return this.firstDoor;
    }

    public String personInfoToString(String name) {
        if (contains(name))
            return name + " " + firstDoor + " " + lastDoor;
        return null;
    }

    public int getDoorsSize() {
        return this.familyDoors.size();
    }

    public List<Integer> getFamilyDoors() {
        return this.familyDoors;
    }

    public List<String> getFamilyMembers() {
        return this.familyMembers;
    }

    public void add(String name) {
        if (!this.familyMembers.contains(name))
            this.familyMembers.add(name);
        else {
            System.err.println("ERROR: Member already exists!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : this.familyMembers) {
            sb.append(name).append(" ");
        }
        return sb.toString();
    }

    public boolean contains(String name) {
        return this.familyMembers.contains(name);
    }

    public void remove(String name) {
        this.familyMembers.remove(name);
    }

    // Implementation of isEmpty function to this class
    public boolean isEmpty() {
        return this.familyMembers.isEmpty();
    }

    @Override
    public int compareTo(Family otherFamily) {
        return this.familyDoors.size() < otherFamily.familyDoors.size() ? -1 : 1;
    } 
}
