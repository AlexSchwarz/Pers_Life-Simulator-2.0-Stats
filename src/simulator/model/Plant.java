package simulator.model;

public class Plant extends Organism{
    public Plant() {
        //System.out.println("New Plant");
    }

    @Override
    public String toString() {
        return "Plant{"+ getID() +"}";
    }
}
