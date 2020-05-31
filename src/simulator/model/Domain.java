package simulator.model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    private final List<Area> areaList;



    public Domain() {
        System.out.println("Domain: Init");
        areaList = new ArrayList<>();
        initAreaList();
    }

    private void initAreaList() {
        for(int i = 0; i < Config.NUMBER_OF_AREAS; i++) {
            if(i == 2 || i == 5) {
                areaList.add(new Area(newOrgList()));
            }else {
                areaList.add(new Area(newEmptyList()));
            }
        }
    }

    private List<Organism> newOrgList() {
        List<Organism> list = new ArrayList<>();
        list.add(new Plant());
        list.add(new Rabbit());
        list.add(new Rabbit());
        list.add(new Wolf());
        return list;
    }

    private List<Organism> newEmptyList() {
        return new ArrayList<Organism>();
    }

    public void progressDomain() {
        System.out.println("DOMAIN: Progress...");
        for(Area area : areaList) {
            area.progressArea();
        }
        System.out.println("DOMAIN: -> Progression complete");
    }
}
