package simulator.model;

public class DomainData {

    private int day;
    private int plantCount;
    private int rabbitCount;
    private int wolfCount;

    public DomainData(int day) {
        this.day = day;
        reset();
    }

    public void update(int plantCount, int rabbitCount, int wolfCount) {
        this.plantCount += plantCount;
        this.rabbitCount += rabbitCount;
        this.wolfCount += wolfCount;
    }

    public int getDay() {
        return day;
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

    public void checkTerminate() {
        if(Config.CHECK_WOLF_TERMINATION && wolfCount <= 0 && day > Config.WOLF_INTRODUCTION_DAY) {
            throw new IllegalStateException("Terminated");
        }else if(plantCount >= Config.TERMINATION_THRESHOLD || rabbitCount >= Config.TERMINATION_THRESHOLD || wolfCount >= Config.TERMINATION_THRESHOLD) {
            throw new IllegalStateException("Terminated");
        }
    }

    public void reset() {
        plantCount = 0;
        rabbitCount = 0;
        wolfCount = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Day;").append(day).append(";P;").append(plantCount).append(";R;").append(rabbitCount).append(";W;").append(wolfCount);
        return sb.toString();
    }
}
