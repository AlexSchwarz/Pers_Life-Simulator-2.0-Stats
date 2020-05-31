package simulator.model;

public class Rabbit extends Animal{
    public Rabbit() {
        super(Config.RABBIT_FEED_CHANCE, Config.RABBIT_MATE_CHANCE);
        //System.out.println("New Rabbit");
    }

    @Override
    public String toString() {
        return "Rabbit{"+ getID() +"}";
    }
}
