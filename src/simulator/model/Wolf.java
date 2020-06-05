package simulator.model;

import javax.crypto.spec.OAEPParameterSpec;

public class Wolf extends Animal{
    public Wolf() {
        super(Config.WOLF_START_ENERGY, Config.WOLF_MAX_ENERGY, Config.WOLF_MAX_AGE, Config.WOLF_AGE_TO_MATE, Config.WOLF_MATE_TIME_DELAY, Config.WOLF_FEED_TIME_DELAY, Config.WOLF_FEED_CHANCE, Config.WOLF_MATE_CHANCE, Config.WOLF_MOVE_CHANCE, Rabbit.class);
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
