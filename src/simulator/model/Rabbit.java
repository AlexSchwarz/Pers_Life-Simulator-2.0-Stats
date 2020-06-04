package simulator.model;

public class Rabbit extends Animal{
    public Rabbit() {
        super(Config.RABBIT_START_ENERGY, Config.RABBIT_MAX_ENERGY, Config.RABBIT_MAX_AGE, Config.RABBIT_MATE_TIME_DELAY, Config.RABBIT_FEED_TIME_DELAY, Config.RABBIT_FEED_CHANCE, Config.RABBIT_MATE_CHANCE, Config.RABBIT_MOVE_CHANCE, Plant.class);
        //System.out.println("New Rabbit");
    }

    @Override
    public Organism newInstance() {
        return new Rabbit();
    }

    @Override
    public String toString() {
        return "Rabbit{"+ getID() + ";E" + getEnergy() + ";A" + getAge() + "}";
    }
}
