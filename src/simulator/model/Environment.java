package simulator.model;

import java.util.List;

public class Environment {

    private Domain domain;

    public Environment() {
        System.out.println("Init Environment");
        domain = new Domain(Config.NUMBER_OF_AREAS, Config.MAX_ORGANISMS_IN_AREA, Config.INIT_PLANTS, Config.INIT_RABBITS, Config.INIT_WOLFS);
    }

    public boolean stepEnvironment() {
        return domain.stepDomain();
    }

    public List<DomainData> runEnvironment(int steps) {
        try {
            domain.runDomain(steps);
        }catch( IllegalStateException e) {
            System.out.println("Terminated");
        }
        for (DomainData data : domain.getDataList()) {
            System.out.println(data);
        }
        return domain.getDataList();
    }

    public int getCurrentArea() {
        return domain.getCurrentArea();
    }

    public String getAreaString(int areaNumber) {
        return domain.getAreaInfoString(areaNumber);
    }

    public String getMoveList() {
        return domain.getMoveOrgList();
    }
}
