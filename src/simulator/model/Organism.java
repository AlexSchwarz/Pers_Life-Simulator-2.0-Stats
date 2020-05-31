package simulator.model;

import java.util.Objects;

public class Organism {

    /*
    todo: add energy attribute. Only increase on feed. Death at 0. (Nothing to do with mating).
    todo: add gender boolean attribute (or some other way of telling gender).

    todo: add different chances passed through constructor. i.e feed chance -> probability = actor find pray chance - pray escape chance

    todo: add boolean for hasMated, hasFed, hasMoved to stop iteration in area
     */

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
