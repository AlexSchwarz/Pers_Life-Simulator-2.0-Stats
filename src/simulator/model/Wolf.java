package simulator.model;

import javax.crypto.spec.OAEPParameterSpec;

import static simulator.model.Config.*;

public class Wolf extends Animal{
    public Wolf() {
        super(WOLF_START_ENERGY, WOLF_MAX_ENERGY, WOLF_ENERGY_TO_MATE, WOLF_ENERGY_MATE_COST, WOLF_MAX_AGE, WOLF_AGE_TO_MATE, WOLF_MATE_TIME_DELAY, WOLF_FEED_TIME_DELAY, WOLF_FEED_CHANCE, WOLF_MATE_CHANCE, WOLF_MOVE_CHANCE, Rabbit.class);
        //System.out.println("New Wolf");
    }

    @Override
    public Organism newInstance() {
        return new Wolf();
    }

    @Override
    public String toLongString() {
        return "Wolf{" + getID() + ";E" + getEnergy() + ";A" + getAge() + ";F(" + canFeed() + ");M(" + canMate() + ")}";
    }

    @Override
    public String toString() {
        return "Wolf{" + getID()+ ")}";
    }
}
