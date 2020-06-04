package simulator.model;

public abstract class Animal extends Organism{

    private final double chanceToFeed;
    private final double chanceToMate;
    private final double chanceToMove;
    private final Class pray;
    private final int mateTimeDelay;
    private final int feedTimeDelay;
    private int mateTimer;
    private int feedTimer;

    public Animal(int startEnergy, int maxEnergy, int maxAge, int mateTimeDelay, int feedTimeDelay,  double chanceToFeed, double chanceToMate, double chanceToMove, Class pray) {
        super(startEnergy, maxEnergy, maxAge);
        this.chanceToFeed = chanceToFeed;
        this.chanceToMate = chanceToMate;
        this.chanceToMove = chanceToMove;
        this.pray = pray;
        this.mateTimeDelay = mateTimeDelay;
        this.feedTimeDelay = feedTimeDelay;
        resetMateTimer();
        resetFeedTimer();
    }

    public double getChanceToFeed() {
        return chanceToFeed;
    }

    public double getChanceToMate() {
        return chanceToMate;
    }

    public double getChanceToMove() {
        return  chanceToMove;
    }

    public Class getPray () {
        return pray;
    }

    public void resetMateTimer() {
        mateTimer = mateTimeDelay;
    }

    public void resetFeedTimer() {
        feedTimer = feedTimeDelay;
    }

    public boolean canMate() {
        boolean canMate = false;
        if(mateTimer == 0){
            canMate = true;
        }
        return canMate;
    }

    public boolean canFeed() {
        boolean canFeed = false;
        if(feedTimer == 0){
            canFeed = true;
        }
        return canFeed;
    }

    public void countDownTimer() {
        feedTimer = Math.max(feedTimer-1, 0);
        mateTimer = Math.max(mateTimer-1, 0);
    }
}
