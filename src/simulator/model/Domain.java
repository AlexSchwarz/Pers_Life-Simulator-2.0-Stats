package simulator.model;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domain {

    private final List<Area> areaList;
    private Random random = new Random();
    private final int numberOfAreas;
    private List<Animal> moveOrgList = new ArrayList<>();
    private int currentArea = 1;
    private List<DomainData> dataList = new ArrayList<>();
    private int dayCounter = 1;
    private DomainData currentData = new DomainData(dayCounter);
    private int totalPlants = 0;
    private int totalRabbits = 0;
    private int totalWolfs = 0;


    public Domain(int numberOfAreas, int sizeOfAreas, int initNumberPlants, int initNumberRabbits, int initNumberWolfs) {
        //System.out.println("DOMAIN: Init -------------------------------------------------------");
        areaList = new ArrayList<>();
        this.numberOfAreas = numberOfAreas;
        initAreaList(numberOfAreas, sizeOfAreas);
        initOrganismsInAreas(numberOfAreas, initNumberPlants, initNumberRabbits, initNumberWolfs);
        //System.out.println("DOMAIN: Init Complete ----------------------------------------------");
    }

    public List<DomainData> getDataList() {
        return dataList;
    }

    public int getCurrentArea() {
        return currentArea;
    }

    public String getAreaInfoString(int areaNumber) {
        return areaList.get(areaNumber -1).getAreaInfoString();
    }

    public String getMoveOrgList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Move list:\n");
        for(Animal animal : moveOrgList) {
            sb.append(animal + "\n");
        }
        return sb.toString();
    }

    private void initAreaList(int numberOfAreas, int sizeOfAreas) {
        int counter = 1;
        while(counter <= numberOfAreas) {
            Area area = new Area(sizeOfAreas);
            //System.out.println("Adding new Area " + area.toString());
            areaList.add(area);
            counter++;
        }
    }

    private void initOrganismsInAreas(int numberOfAreas, int initNumberPlants, int initNumberRabbits, int initNumberWolfs) {
        List<Organism> organismList = new ArrayList<>();
        organismList.addAll(initOrganismsByTypeAndNumber(Config.OrganismType.PLANT, initNumberPlants));
        organismList.addAll(initOrganismsByTypeAndNumber(Config.OrganismType.RABBIT, initNumberRabbits));
        organismList.addAll(initOrganismsByTypeAndNumber(Config.OrganismType.WOLF, initNumberWolfs));
        for(Organism organism : organismList) {
            int attempts = 0;
            boolean searching = true;
            while(searching && attempts <= Config.MAX_ATTEMPTS) {
                //try {
                    int areaNumber = random.nextInt(numberOfAreas);
                    areaList.get(areaNumber).addOrganism(organism);
                    searching = false;
                    //System.out.println("Placed " + organism + " in area " + (areaNumber+1));
                //}catch (Exception e ) {
                    attempts++;
                //}
            }
            if(searching) {
                throw new RuntimeException("Passed number of attempts");
            }
        }
    }

    private List<Organism> initOrganismsByTypeAndNumber(Config.OrganismType type, int numberOf) {
        List<Organism> orgList = new ArrayList<>();
        int counter = 1;
        while(counter <= numberOf) {
            orgList.add(Organism.newInstanceFromType(type));
            counter++;
        }
        return orgList;
    }

    public boolean stepDomain() {
        Area area = areaList.get(currentArea-1);
        moveOrgList.addAll(area.progressArea());
        updateDomainData(area.getAreaData());
        return switchToNextArea();
    }

    private boolean switchToNextArea() {
        boolean areasLeft = true;
        int nextArea = currentArea + 1;
        if(nextArea > numberOfAreas) {
            finalizeAreaCycle();
            areasLeft = false;
            //System.out.println("DOMAIN: -> Progression complete------------------------------------------");
        } else {
            currentArea = nextArea;
        }
        return areasLeft;
    }

    private void finalizeAreaCycle() {
        currentArea = 1;
        dayCounter++;
        moveAnimals(moveOrgList);
        moveOrgList.clear();
        initOrganismsInAreas(numberOfAreas, Config.PLANT_REGROWTH,0,0);
        if(dayCounter == Config.WOLF_INTRODUCTION_DAY) {
            initOrganismsInAreas(numberOfAreas,0,0, Config.INTRODUCTION_WOLF );
        }
        //System.out.println(currentData);
        dataList.add(currentData);
        currentData.checkTerminate();
        currentData = new DomainData(dayCounter);
    }

    public void runDomain(int progressions) {
        int i = 1;
        while( i <= progressions) {
            boolean dayRunning = true;
            while(dayRunning) {
                dayRunning = stepDomain();
            }
            i++;
        }
    }

    private void moveAnimals(List<Animal> moveList) {
        //System.out.println("DOMAIN: Moving animals...");
        for(Animal animal : moveList) {
            int attempts = 0;
            boolean searching = true;
            while(searching && attempts <= Config.MAX_ATTEMPTS) {
                //try {
                    int areaIndex = random.nextInt(Config.NUMBER_OF_AREAS);
                    areaList.get(areaIndex).addOrganism(animal);
                    //System.out.println("Moved " + animal + " to area " + (areaIndex+1));
                    searching = false;
                //} catch (Exception e) {
                    attempts++;
                //}
            }
            if(searching) {
                throw new RuntimeException("Passed number of attempts");
            }
        }
    }

    public void updateDomainData(AreaData areaData) {
        currentData.update(areaData.getPlantCount(), areaData.getRabbitCount(), areaData.getWolfCount());
    }
}
