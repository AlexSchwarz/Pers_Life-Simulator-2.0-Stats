package simulator.model;

import static simulator.model.Config.*;

public class Rabbit extends Animal{
    public Rabbit() {
        super(RABBIT_START_ENERGY, RABBIT_MAX_ENERGY, RABBIT_ENERGY_TO_MATE, RABBIT_ENERGY_MATE_COST, RABBIT_MAX_AGE, RABBIT_AGE_TO_MATE, RABBIT_MATE_TIME_DELAY, RABBIT_FEED_TIME_DELAY, RABBIT_FEED_CHANCE, RABBIT_MATE_CHANCE, RABBIT_MOVE_CHANCE, Plant.class);
        //System.out.println("New Rabbit");
    }

    @Override
    public Organism newInstance() {
        return new Rabbit();
    }

    @Override
    public String toLongString() {
        return "Rabbit{" + getID() + ";E" + getEnergy() + ";A" + getAge() + ";F(" + canFeed() + ");M(" + canMate() + ")}";
    }

    @Override
    public String toString() {
        return "Rabbit{" + getID() + "}";
    }
}
