package simulator.model;

public class Environment {

    private Domain domain;

    public Environment() {
        System.out.println("Init Environment");
        domain = new Domain();
    }

    public void progressEnvironment() {
        domain.progressDomain();
    }
}
