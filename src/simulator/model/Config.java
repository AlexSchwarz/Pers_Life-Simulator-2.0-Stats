package simulator.model;

public final class Config {

    public static final int NUMBER_OF_AREAS = 9;
    public static final int MAX_ORGANISMS_IN_AREA = 9;
    public static final int DAILY_ENERGY_COST = 1;

    public static final double RABBIT_MATE_CHANCE = 0.75;
    public static final double RABBIT_FEED_CHANCE = 0.75;
    public static final double RABBIT_MOVE_CHANCE = 0.75;

    public static final double WOLF_MATE_CHANCE = 0.30;
    public static final double WOLF_FEED_CHANCE = 0.30;
    public static final double WOLF_MOVE_CHANCE = 0.30;

    public static final int PLANT_START_ENERGY = 2;
    public static final int RABBIT_START_ENERGY = 2;
    public static final int WOLF_START_ENERGY = 2;

    public static final int PLANT_MAX_ENERGY = 8;
    public static final int RABBIT_MAX_ENERGY = 8;
    public static final int WOLF_MAX_ENERGY = 8;

    public static final int WOLF_MAX_AGE = 10;
    public static final int RABBIT_MAX_AGE = 10;
    public static final int PLANT_MAX_AGE = 10;

    public static final int WOLF_AGE_TO_MATE = 0;
    public static final int RABBIT_AGE_TO_MATE = 0;

    public static final int WOLF_ENERGY_TO_MATE = 4;
    public static final int RABBIT_ENERGY_TO_MATE = 4;
}
