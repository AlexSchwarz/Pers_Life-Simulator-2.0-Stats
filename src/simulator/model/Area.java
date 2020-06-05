package simulator.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Area {

    private static int counter = 1;

    private List<Organism> organismList;
    private final int id;
    private Random random;
    private boolean isRunning = true;
    private final int size;
    private int numberOfPlants = 0;
    private int numberOfRabbits = 0;
    private int numberOfWolfs = 0;

    public Area(int size) {
        //System.out.println("> AREA: Init");
        this.size = size;
        random = new Random();
        organismList = new ArrayList<>();
        id = counter++;
        updateOrganismCount();
    }

    private List<Organism> getAllOrganisms() {
        return organismList;
    }

    public int getNumberOfPlants() {
        return numberOfPlants;
    }

    public int getNumberOfRabbits() {
        return numberOfRabbits;
    }

    public int getNumberOfWolfs() {
        return numberOfWolfs;
    }

    private boolean isFull() {
        boolean isFull = false;
        if(organismList.size() == size) {
            isFull = true;
            System.out.println("FULL");
            throw new RuntimeException("Area is full");
        }
        return isFull;
    }

    public void addOrganism(Organism organism) throws Exception {
        if(isFull()) {
            throw new Exception("Full");
        }else {
            organismList.add(organism);
        }
        assert organismList.size() <= size;
    }

    public List<Animal> progressArea() {
        //System.out.println("> AREA: " + toString() + " Progress organisms... " + organismList);
        progressPlants();
        progressAnimals(Rabbit.class);
        progressAnimals(Wolf.class);
        countTimerAllAnimals();
        updateOrganismCount();
        List <Animal> moveList = moveAnimals();
        //System.out.println("> AREA: -> Progression organisms complete. Staying " + organismList + " Moving " + moveList);
        return moveList;
    }

    private void progressPlants() {
        Iterator<Organism> it = getOrganismsByInstance(Plant.class).iterator();
        while(it.hasNext()) {
            Plant plant = (Plant) it.next();
            //System.out.println("> AREA: Progress Plant " + plant.toLongString());
            plant.increaseAge();
            if(plant.isDead()) {
                //System.out.println("---DEATH: " + plant);
                organismList.remove(plant);
            }
            //System.out.println("Complete " + plant.toLongString());
        }
    }

    private void progressAnimals(Class animalClass) {
        Iterator<Organism> it = getOrganismsByInstance(animalClass).iterator();
        while(it.hasNext()) {
            Animal animal = (Animal) it.next();
            //System.out.println("> AREA: Progress " + animal.toLongString());
            animalFeed(animal, getOrganismsByInstance(animal.getPray()));
            animalMate(animal, getOrganismsByInstance(animal.getClass()));
            animal.increaseAge();
            animal.decreaseEnergy(Config.DAILY_ENERGY_COST);
            if(animal.isDead()) {
                //System.out.println("---Death: " + animal);
                organismList.remove(animal);
            }
            //System.out.println("Complete " + animal.toLongString());
        }
    }

    private void animalFeed(Animal animal, List<Organism> organismsToFeedOn) {
        Iterator<Organism> it = organismsToFeedOn.iterator();
        while(animal.canFeed() && it.hasNext()) {
            Organism organism = it.next();
            if(!animal.equals(organism)) {
                double chance = random.nextDouble();
                if (animal.getChanceToFeed() >= chance) {
                    //System.out.println("---FEED: Success on " + organism + ", " + animal.getChanceToFeed() + " vs " + chance);
                    animal.increaseEnergy(Config.ENERGY_GAIN);
                    animal.resetFeedTimer();
                    organismList.remove(organism);
                } else {
                    //System.out.println("---FEED: Failure on " + organism + ", " + animal.getChanceToFeed() + " vs " + chance);
                }
            }
        }
    }

    private void animalMate(Animal animalActor, List<Organism> organismsToMateWith) {
        Iterator<Organism> it = organismsToMateWith.iterator();
        while(animalActor.canMate() && it.hasNext()) {
            Animal animalTarget = (Animal) it.next();
            if(!animalActor.equals(animalTarget) && animalTarget.canMate()) {
                double chance = random.nextDouble();
                if (animalActor.getChanceToMate() >= chance && !isFull()) {
                    animalActor.resetMateTimer();
                    Animal newAnimal = (Animal) animalActor.newInstance();
                    //System.out.println("---MATE: Success with " + animalTarget + ", " + animalActor.getChanceToMate() + " vs " + chance + ", result " + newAnimal.toString());
                    organismList.add(newAnimal);
                } else {
                    //System.out.println("---MATE: Failure with " + animalTarget + ", " + animalActor.getChanceToMate() + " vs " + chance);
                }
            }
        }
    }

    private List<Animal> moveAnimals() {
        List<Animal> moveList = new ArrayList<>();
        //System.out.println("> AREA: Moving animals... ");
        for(Organism organism : getOrganismsByInstance(Animal.class)) {
            Animal animal = (Animal) organism;
            double chance = random.nextDouble();
            if(animal.getChanceToMove() >= chance) {
                //System.out.println("---MOVE: Success " + animal + " " + animal.getChanceToMove() + " vs " + chance);
                moveList.add(animal);
                organismList.remove(animal);
            }else {
                //System.out.println("---MOVE: Failure " + animal + " " + animal.getChanceToMove() + " vs " + chance);
            }
        }
        return moveList;
    }

    private void countTimerAllAnimals() {
        getOrganismsByInstance(Animal.class).forEach(animal -> ((Animal) animal).countDownTimer());
    }

    private List<Organism> getOrganismsByInstance(Class organismClass) {
        return getOrganismsByPredicate(organismClass::isInstance);
    }

    private List<Organism> getOrganismsByPredicate(Predicate<Organism> filterPredicate) {
        return getAllOrganisms().stream().filter(filterPredicate).collect(Collectors.toList());
    }

    public String getOrgListString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString() + "\n");
        for(Organism organism : organismList) {
            sb.append(organism.toLongString() + "\n");
        }
        return sb.toString();
    }

    private void updateOrganismCount() {
        numberOfPlants = getOrganismsByInstance(Plant.class).size();
        numberOfRabbits = getOrganismsByInstance(Rabbit.class).size();
        numberOfWolfs = getOrganismsByInstance(Wolf.class).size();
    }

    @Override
    public String toString() {
        return "Area{" + id + '}';
    }
}
