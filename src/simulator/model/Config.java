package simulator.model;

public final class Config {

    public static final int NUMBER_OF_AREAS = 16;
    public static final int MAX_ORGANISMS_IN_AREA = 16;
    public static final int DAILY_ENERGY_COST = 1;
    public static final int ENERGY_GAIN = 5;

    public static final double RABBIT_MATE_CHANCE = 0.50;
    public static final double RABBIT_FEED_CHANCE = 0.50;
    public static final double RABBIT_MOVE_CHANCE = 0.50;

    public static final double WOLF_MATE_CHANCE = 0.25;
    public static final double WOLF_FEED_CHANCE = 0.25;
    public static final double WOLF_MOVE_CHANCE = 0.25;

    public static final int PLANT_START_ENERGY = 3;
    public static final int RABBIT_START_ENERGY = 3;
    public static final int WOLF_START_ENERGY = 3;

    public static final int PLANT_MAX_ENERGY = 5;
    public static final int RABBIT_MAX_ENERGY = 5;
    public static final int WOLF_MAX_ENERGY = 5;

    public static final int WOLF_MAX_AGE = 10;
    public static final int RABBIT_MAX_AGE = 10;
    public static final int PLANT_MAX_AGE = 10;

    public static final int WOLF_MATE_TIME_DELAY = 2;
    public static final int RABBIT_MATE_TIME_DELAY = 2;

    public static final int WOLF_FEED_TIME_DELAY = 2;
    public static final int RABBIT_FEED_TIME_DELAY = 2;

    public static final int INIT_PLANTS = 2;
    public static final int INIT_RABBITS = 2;
    public static final int INIT_WOLFS = 2;

    public enum OrganismType {
        PLANT, RABBIT, WOLF;
    }

}
