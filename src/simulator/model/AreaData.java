package simulator.model;

public class AreaData {

    private final int plantCount;
    private final int rabbitCount;
    private final int wolfCount;

    public AreaData(int plantCount, int rabbitCount, int wolfCount) {
        this.plantCount = plantCount;
        this.rabbitCount = rabbitCount;
        this.wolfCount = wolfCount;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public int getRabbitCount() {
        return rabbitCount;
    }

    public int getWolfCount() {
        return wolfCount;
    }
}
