package simulator.model;

public class Wolf extends Animal{
    public Wolf() {
        super(Config.WOLF_START_ENERGY, Config.WOLF_MAX_ENERGY, Config.WOLF_MAX_AGE, Config.WOLF_AGE_TO_MATE, Config.WOLF_ENERGY_TO_MATE, Config.WOLF_FEED_CHANCE, Config.WOLF_MATE_CHANCE, Config.WOLF_MOVE_CHANCE);
        //System.out.println("New Wolf");
    }

    @Override
    public Animal getNewInstance() {
        return new Wolf();
    }

    @Override
    public String toString() {
        return "Wolf{" + getID() + ";E" + getEnergy() + ";A" + getAge() + "}";
    }
}
