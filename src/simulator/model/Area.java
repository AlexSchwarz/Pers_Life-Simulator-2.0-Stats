package simulator.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Area {

    private static int counter = 0;

    private List<Organism> organismList;
    private final int ID;
    private Random random;

    public Area(List<Organism> organismList) {
        System.out.println("AREA: Init with " + organismList);
        random = new Random();
        Objects.requireNonNull(organismList);
        this.organismList = organismList;
        ID = counter++;
    }

    public List<Organism> getAllOrganisms() {
        return organismList;
    }

    public void progressArea() {
        System.out.println("AREA: " + toString() + " Progress organisms... " + organismList);
        progressPlants();
        progressRabbits();
        progressWolfs();
        System.out.println("AREA: -> Progression organisms complete " + organismList);
    }

    private void progressPlants() {
        System.out.println("AREA: Progress Plants...");
        Iterator<Organism> it = getOrganismsByInstance(Plant.class).iterator();
        while(it.hasNext()) {
            Plant plant = (Plant) it.next();
            System.out.println("AREA: Progress Plant " + plant.toString());
            plant.increaseAge();
        }
    }

    private void progressRabbits() {
        System.out.println("AREA: Progress Rabbits...");
        Iterator<Organism> it = getOrganismsByInstance(Rabbit.class).iterator();
        while(it.hasNext()) {
            Rabbit rabbit = (Rabbit) it.next();
            System.out.println("AREA: Progress Rabbit " + rabbit.toString() + "**********");
            animalFeed(rabbit, getOrganismsByInstance(Plant.class));
            animalMate(rabbit, getOrganismsByInstance(Rabbit.class));
            rabbit.increaseAge();
        }
    }

    private void progressWolfs() {
        System.out.println("AREA: Progress Wolfs...");
        Iterator<Organism> it = getOrganismsByInstance(Wolf.class).iterator();
        while(it.hasNext()) {
            Wolf wolf = (Wolf) it.next();
            System.out.println("AREA: Progress Wolf " + wolf.toString());
            animalFeed(wolf, getOrganismsByInstance(Rabbit.class));
            animalMate(wolf, getOrganismsByInstance(Wolf.class));
            wolf.increaseAge();
        }
    }

    private void animalFeed(Animal animal, List<Organism> organismsToFeedOn) {
        System.out.println("Attempting feed on " + organismsToFeedOn);
        for(Organism organism : organismsToFeedOn) {
            if(!animal.equals(organism)) {
                System.out.println("Animal feed chance " + animal.getChanceToFeed());
                double chance = random.nextDouble();
                System.out.println("Chance " + chance);
                if (animal.getChanceToFeed() >= chance) {
                    System.out.println("SUCCESS feed " + organism);
                } else {
                    System.out.println("FAILURE feed " + organism);
                }
            }
        }
    }

    private void animalMove(Animal animal) {
        //todo: run chance for move. If pass, add to seperate move list with getter and removed from org list. Called upon once all areas
        //are done progressing. Make sure to clear move list a start of area progression.
    }

    private void animalMate(Animal animal, List<Organism> organismsToMateWith) {
        //todo: add way to add new org of actor type to orgList
        System.out.println("Attempting mate with " + organismsToMateWith);
        for(Organism organism : organismsToMateWith) {
            if(!animal.equals(organism)) {
                System.out.println("Animal mate chance " + animal.getChanceToMate());
                double chance = random.nextDouble();
                System.out.println("Chance " + chance);
                if (animal.getChanceToMate() >= chance) {
                    System.out.println("SUCCESS Mate " + organism);
                } else {
                    System.out.println("FAILURE Mate " + organism);
                }
            }
        }
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
                ID +
                '}';
    }
}
