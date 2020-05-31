package simulator.model;

public class Wolf extends Animal{
    public Wolf() {
        super(Config.WOLF_FEED_CHANCE, Config.WOLF_MATE_CHANCE);
        //System.out.println("New Wolf");
    }

    @Override
    public String toString() {
        return "Wolf{" + getID() + "}";
    }
}
