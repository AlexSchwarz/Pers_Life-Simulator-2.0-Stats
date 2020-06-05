package simulator.model;

public class Environment {

    private Domain domain;

    public Environment() {
        System.out.println("Init Environment");
        domain = new Domain(Config.NUMBER_OF_AREAS, Config.MAX_ORGANISMS_IN_AREA, Config.INIT_PLANTS, Config.INIT_RABBITS, Config.INIT_WOLFS);
    }

    public boolean stepEnvironment() {
        return domain.stepDomain();
    }

    public void progressEnvironment(int steps) {
        domain.progressDomain(steps);
    }

    public int getCurrentArea() {
        return domain.getCurrentArea();
    }

    public String getAreaString(int areaNumber) {
        return domain.getAreaOrgString(areaNumber);
    }

    public String getCurrentAreaString() {
        return domain.getCurrentAreaOrgString();
    }

    public String getMoveList() {
        return domain.getMoveOrgList();
    }
}
