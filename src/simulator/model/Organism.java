package simulator.model;

import java.util.Objects;

public abstract class Organism {

    /*
    todo: add gender boolean attribute (or some other way of telling gender).

    todo: add different chances passed through constructor. i.e feed chance -> probability = actor find pray chance - pray escape chance
     */

    private static int counter = 0;

    private final int ID;
    private int age = 0;
    private int energy;
    private final int maxEnergy;
    private final int maxAge;

    public Organism(int startEnergy, int maxEnergy, int maxAge) {
        //System.out.println("Init Organism");
        ID = counter++;
        energy = startEnergy;
        this.maxEnergy = maxEnergy;
        this.maxAge = maxAge;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void increaseAge() {
        age++;
    }

    public void increaseEnergy(int amount) {
        if(amount < 0) throw new IllegalArgumentException("Int amount cannot be negative");
        int calcEnergy = energy + amount;
        energy = Math.min(calcEnergy, maxEnergy);
    }

    public void decreaseEnergy(int amount) {
        if(amount < 0) throw new IllegalArgumentException("Int amount cannot be negative");
        int calcEnergy = energy - amount;
        energy = Math.max(calcEnergy, 0);
    }

    public boolean isDead() {
        boolean status = false;
        if(energy <= 0 || age > maxAge) {
            status = true;
        }
        return status;
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
