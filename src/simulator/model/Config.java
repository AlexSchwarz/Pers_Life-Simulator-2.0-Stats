package simulator.model;

public final class Config {

    public static final int NUMBER_OF_AREAS =       25;
    public static final int MAX_ORGANISMS_IN_AREA = 100;
    public static final int DAILY_ENERGY_COST =     1;
    //public static final int ENERGY_GAIN =         3;
    public static final int MAX_ATTEMPTS =          5;
    public static final int PROGRESSION_STEPS =     600;
    public static final int RABBIT_INTRODUCTION_DAY = 10;
    public static final int WOLF_INTRODUCTION_DAY = 100;

    public static final int INIT_PLANTS =   30;
    public static final int INIT_RABBITS =  10;
    public static final int INIT_WOLFS =    0;
    public static final int INTRODUCTION_RABBIT = 30;
    public static final int INTRODUCTION_WOLF = 5;

    public static final int PLANT_REGROWTH =        30;
    public static final int PLANT_START_ENERGY =    5;
    public static final int PLANT_MAX_ENERGY =      5;
    public static final int PLANT_MAX_AGE =         100;

    public static final double RABBIT_MATE_CHANCE =     0.75;
    public static final double RABBIT_FEED_CHANCE =     0.75;
    public static final double RABBIT_MOVE_CHANCE =     0.5;
    public static final int RABBIT_START_ENERGY =       3;
    public static final int RABBIT_MAX_ENERGY =         15;
    public static final int RABBIT_ENERGY_TO_MATE =     10;
    public static final int RABBIT_ENERGY_MATE_COST =   5;
    public static final int RABBIT_MAX_AGE =            30;
    public static final int RABBIT_AGE_TO_MATE =        10;
    public static final int RABBIT_FEED_TIME_DELAY =    1;
    public static final int RABBIT_MATE_TIME_DELAY =    1;


    public static final double WOLF_MATE_CHANCE =   0.75;
    public static final double WOLF_FEED_CHANCE =   0.2;
    public static final double WOLF_MOVE_CHANCE =   0.5;
    public static final int WOLF_START_ENERGY =     5;
    public static final int WOLF_MAX_ENERGY =       30;
    public static final int WOLF_ENERGY_TO_MATE =   20;
    public static final int WOLF_ENERGY_MATE_COST = 10;
    public static final int WOLF_MAX_AGE =          60;
    public static final int WOLF_AGE_TO_MATE =      20;
    public static final int WOLF_FEED_TIME_DELAY =  1;
    public static final int WOLF_MATE_TIME_DELAY =  1;

    public enum OrganismType {
        PLANT, RABBIT, WOLF;
    }

}
