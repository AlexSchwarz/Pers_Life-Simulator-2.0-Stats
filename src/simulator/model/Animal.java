package simulator.model;

public class Animal extends Organism{

    private final double chanceToFeed;
    private final double chanceToMate;

    public Animal(double chanceToFeed, double chanceToMate) {
        this.chanceToFeed = chanceToFeed;
        this.chanceToMate = chanceToMate;
    }

    public double getChanceToFeed() {
        return chanceToFeed;
    }

    public double getChanceToMate() {
        return chanceToMate;
    }


}
