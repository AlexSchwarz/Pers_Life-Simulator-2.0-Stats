package simulator.model;

public final class Config {

    public static final int NUMBER_OF_AREAS =       25;
    public static final int MAX_ORGANISMS_IN_AREA = 200;
    public static final int DAILY_ENERGY_COST =     1;
    //public static final int ENERGY_GAIN =         3;
    public static final int MAX_ATTEMPTS =          5;
    public static final int TERMINATION_THRESHOLD = 500;
    public static final boolean CHECK_WOLF_TERMINATION = false;
    public static final int PROGRESSION_STEPS =    1000;
    public static final int RABBIT_INTRODUCTION_DAY = 10;
    public static final int WOLF_INTRODUCTION_DAY = 200;

    public static final int INIT_PLANTS =   30;
    public static final int INIT_RABBITS =  40;
    public static final int INIT_WOLFS =    0;
    public static final int INTRODUCTION_RABBIT = 30;
    public static final int INTRODUCTION_WOLF = 5;

    public static final int PLANT_REGROWTH =        30;
    public static final int PLANT_START_ENERGY =    5;
    public static final int PLANT_MAX_ENERGY =      3;
    public static final int PLANT_MAX_AGE =         1;

    public static final double RABBIT_MATE_CHANCE =     1;
    public static final double RABBIT_FEED_CHANCE =     1;
    public static final double RABBIT_MOVE_CHANCE =     0.5;
    public static final int RABBIT_START_ENERGY =       10;
    public static final int RABBIT_MAX_ENERGY =         40;
    public static final int RABBIT_ENERGY_TO_MATE =     30;
    public static final int RABBIT_ENERGY_MATE_COST =   20;
    public static final int RABBIT_MAX_AGE =            80;
    public static final int RABBIT_AGE_TO_MATE =        10;
    public static final int RABBIT_FEED_TIME_DELAY =    1;
    public static final int RABBIT_MATE_TIME_DELAY =    1;


    public static final double WOLF_MATE_CHANCE =   0.5;
    public static final double WOLF_FEED_CHANCE =   0.05;
    public static final double WOLF_MOVE_CHANCE =   0.5;
    public static final int WOLF_START_ENERGY =     20;
    public static final int WOLF_MAX_ENERGY =       80;
    public static final int WOLF_ENERGY_TO_MATE =   50;
    public static final int WOLF_ENERGY_MATE_COST = 40;
    public static final int WOLF_MAX_AGE =          160;
    public static final int WOLF_AGE_TO_MATE =      20;
    public static final int WOLF_FEED_TIME_DELAY =  1;
    public static final int WOLF_MATE_TIME_DELAY =  1;

    public enum OrganismType {
        PLANT, RABBIT, WOLF;
    }

}
