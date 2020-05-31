package simulator.model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    /*
    todo: Add area init with Config values
    for example init all starting animals and map with random number between 0 and Area_Number.
    Then init areas with list of animals corresponding to its Area ID.

    todo: Add method to relocate animals
    Area generates list of animals that want to move. Domain gets list and for each animal generates
    a new number between 0 and Area_Number then puts the orgs in those areas
    To be done AFTER all areas progress.

    todo: Add method to add new plants after all areas done progressing
    either with fixed amount each turn or with a fixed amount in each area
    fixed amount each domain progression makes more sense
     */

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
