package simulator.model;

public abstract class Animal extends Organism{

    private final double chanceToFeed;
    private final double chanceToMate;
    private final double chanceToMove;
    private boolean hasNotMated;
    private boolean hasNotFed;
    private final int ageToMate;
    private final int energyToMate;

    public Animal(int startEnergy, int maxEnergy, int maxAge, int ageToMate, int energyToMate,  double chanceToFeed, double chanceToMate, double chanceToMove) {
        super(startEnergy, maxEnergy, maxAge);
        this.chanceToFeed = chanceToFeed;
        this.chanceToMate = chanceToMate;
        this.chanceToMove = chanceToMove;
        hasNotMated = true;
        hasNotFed = true;
        this.ageToMate = ageToMate;
        this.energyToMate = energyToMate;
    }

    public double getChanceToFeed() {
        return chanceToFeed;
    }

    public double getChanceToMate() {
        return chanceToMate;
    }

    public double getChanceToMove() {
        return  chanceToMove;
    }

    public boolean getWantsToMate() {
        return hasNotMated && getAge() >= ageToMate && getEnergy() >= energyToMate;
    }

    public void setHasFed() {
        hasNotFed = false;
    }

    public void setHasMated() {
        hasNotMated = false;
    }

    public boolean getWantsToFeed() {
        return hasNotFed;
    }

    public void resetStatus() {
        hasNotFed = true;
        hasNotMated = true;
    }

    public abstract Animal getNewInstance();
}
