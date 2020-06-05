package simulator;

import simulator.model.Config;
import simulator.model.Environment;

public class Main {

    public static void main(String[] args) {
        Environment environment = new Environment();
        environment.runEnvironment(Config.PROGRESSION_STEPS);
        //environment.stepEnvironment();
        //environment.stepEnvironment();
    }
}
