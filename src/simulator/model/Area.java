package simulator.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Area {

    private static int counter = 0;

    private List<Organism> organismList;
    private final int id;
    private Random random;
    private boolean isRunning = true;

    public Area(List<Organism> organismList) {
        System.out.println("AREA: Init with " + organismList);
        random = new Random();
        Objects.requireNonNull(organismList);
        this.organismList = organismList;
        id = counter++;
    }

    private List<Organism> getAllOrganisms() {
        return organismList;
    }

    private boolean isFull() {
        boolean isFull = false;
        if(organismList.size() == Config.MAX_ORGANISMS_IN_AREA) {
            isFull = true;
        }
        return isFull;
    }

    public void addOrganism(Organism organism) throws Exception {
        if(isFull()) {
            throw new Exception("Full");
        }else {
            organismList.add(organism);
        }
        assert organismList.size() <= Config.MAX_ORGANISMS_IN_AREA;
    }

    public List<Animal> progressArea() {
        System.out.println("AREA: " + toString() + " Progress organisms... " + organismList);
        progressPlants();
        progressAnimals(Rabbit.class);
        progressAnimals(Wolf.class);
        countTimerAllAnimals();
        List <Animal> moveList = moveAnimals();
        updateRunningStatus();
        System.out.println("AREA: -> Progression organisms complete. Staying " + organismList + " Moving " + moveList);
        return moveList;
    }

    private void progressPlants() {
        //System.out.println("AREA: Progress Plants...");
        Iterator<Organism> it = getOrganismsByInstance(Plant.class).iterator();
        while(it.hasNext()) {
            Plant plant = (Plant) it.next();
            System.out.println("AREA: Progress Plant " + plant.toString() + "**********");
            plant.increaseAge();
            if(plant.isDead()) {
                System.out.println("DEATH: " + plant);
                organismList.remove(plant);
            }
        }
    }

    private void progressAnimals(Class animalClass) {
        Iterator<Organism> it = getOrganismsByInstance(animalClass).iterator();
        while(it.hasNext()) {
            Animal animal = (Animal) it.next();
            System.out.println("AREA: Progress " + animal.toString()  + "**********");
            animalFeed(animal, getOrganismsByInstance(animal.getPray()));
            animalMate(animal, getOrganismsByInstance(animal.getClass()));
            animal.increaseAge();
            animal.decreaseEnergy(Config.DAILY_ENERGY_COST);
            if(animal.isDead()) {
                System.out.println("Death: " + animal);
                organismList.remove(animal);
            }
        }
    }

    private void progressRabbits() {
        //System.out.println("AREA: Progress Rabbits...");
        Iterator<Organism> it = getOrganismsByInstance(Rabbit.class).iterator();
        while(it.hasNext()) {
            Rabbit rabbit = (Rabbit) it.next();
            System.out.println("AREA: Progress Rabbit " + rabbit.toString() + "**********");
            animalFeed(rabbit, getOrganismsByInstance(Plant.class));
            animalMate(rabbit, getOrganismsByInstance(Rabbit.class));
            rabbit.increaseAge();
            rabbit.decreaseEnergy(Config.DAILY_ENERGY_COST);
            if(rabbit.isDead()) {
                System.out.println("DEATH: " + rabbit);
                organismList.remove(rabbit);
            }
        }
    }

    private void progressWolfs() {
        //System.out.println("AREA: Progress Wolfs...");
        Iterator<Organism> it = getOrganismsByInstance(Wolf.class).iterator();
        while(it.hasNext()) {
            Wolf wolf = (Wolf) it.next();
            System.out.println("AREA: Progress Wolf " + wolf.toString() + "**********");
            animalFeed(wolf, getOrganismsByInstance(Rabbit.class));
            animalMate(wolf, getOrganismsByInstance(Wolf.class));
            wolf.increaseAge();
            wolf.decreaseEnergy(Config.DAILY_ENERGY_COST);
            if(wolf.isDead()) {
                System.out.println("DEATH: " + wolf);
                organismList.remove(wolf);
            }
        }
    }

    private void animalFeed(Animal animal, List<Organism> organismsToFeedOn) {
        //System.out.println("Attempting feed on " + organismsToFeedOn);
        Iterator<Organism> it = organismsToFeedOn.iterator();
        while(animal.canFeed() && it.hasNext()) {
            Organism organism = it.next();
            //System.out.println("Checking " + organism.toString());
            if(!animal.equals(organism)) {
                //System.out.println("Animal feed chance " + animal.getChanceToFeed());
                double chance = random.nextDouble();
                //System.out.println("Chance " + chance);
                if (animal.getChanceToFeed() >= chance) {
                    System.out.println("FEED:" + organism);
                    animal.increaseEnergy(organism.getEnergy());
                    animal.resetFeedTimer();
                    organismList.remove(organism);
                } else {
                    //System.out.println("FAILURE feed " + organism);
                }
            }
        }
    }

    private void animalMate(Animal animalActor, List<Organism> organismsToMateWith) {
        //System.out.println("Attempting mate with " + organismsToMateWith);
        Iterator<Organism> it = organismsToMateWith.iterator();
        //System.out.println("Animal Actor wants to mate " + animalActor.getWantsToMate());
        while(animalActor.canMate() && it.hasNext()) {
            Animal animalTarget = (Animal) it.next();
            if(!animalActor.equals(animalTarget) && animalTarget.canMate()) {
                //System.out.println("Animal mate chance " + animalActor.getChanceToMate());
                double chance = random.nextDouble();
                //System.out.println("Chance " + chance);
                if (animalActor.getChanceToMate() >= chance && !isFull()) {
                    //System.out.println("SUCCESS Mate " + animalTarget);
                    animalActor.resetMateTimer();
                    //System.out.println("Adding " + newAnimal);
                    Animal newAnimal = (Animal) animalActor.newInstance();
                    System.out.println("MATE: " + animalActor + " with " + animalTarget + " result " + newAnimal);
                    organismList.add(newAnimal);
                } else {
                    //System.out.println("FAILURE Mate " + animalTarget);
                }
            }
        }
    }

    private List<Animal> moveAnimals() {
        List<Animal> moveList = new ArrayList<>();
        //System.out.println("AREA: Moving animals... ");
        for(Organism organism : getOrganismsByInstance(Animal.class)) {
            Animal animal = (Animal) organism;
            //System.out.println("Checking move for " + animal.toString());
            //System.out.println("Animal move chance " + animal.getChanceToMove());
            double chance = random.nextDouble();
            //System.out.println("Chance " + chance);
            if(animal.getChanceToMove() >= chance) {
                System.out.println("MOVE: " + organism);
                moveList.add(animal);
                organismList.remove(animal);
            }else {
                //System.out.println("FAILURE Move");
            }
        }
        //System.out.println("Returning " + moveList);
        return moveList;
    }

    private void updateRunningStatus() {
        isRunning = !getOrganismsByInstance(Animal.class).isEmpty();
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

    @Override
    public String toString() {
        return "Area{" +
                id +
                '}';
    }
}
