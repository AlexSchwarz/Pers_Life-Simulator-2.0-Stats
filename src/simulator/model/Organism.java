package simulator.model;

import java.util.Objects;

public class Organism {

    private static int counter = 0;

    private final int ID;
    private int age = 0;

    public Organism() {
        //System.out.println("Init Organism");
        ID = counter++;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public void increaseAge() {
        age++;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organism organism = (Organism) o;
        return ID == organism.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
