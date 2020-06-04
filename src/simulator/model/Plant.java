package simulator.model;

public class Plant extends Organism{

    public Plant() {
        super(Config.PLANT_START_ENERGY, Config.PLANT_MAX_ENERGY, Config.PLANT_MAX_AGE);
        //System.out.println("New Plant");
    }

    @Override
    public String toString() {
        return "Plant{"+ getID() + ";E" + getEnergy() + ";A" + getAge() + "}";
    }

    @Override
    public Organism newInstance() {
        return new Plant();
    }
}
