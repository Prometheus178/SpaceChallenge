import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int phase1 = 1;
        final int phase2 = 2;

        long u1Cost;
        long u2Cost;
        int phase1Rockets;
        int phase2Rockets;
        ArrayList<Item> phase1Item;
        ArrayList<Item> phase2Item;
        Simulation simulation = new Simulation();
        phase1Item = simulation.loadItems(phase1);
        phase2Item = simulation.loadItems(phase2);
        System.out.println("Start simulation for rocket U1");
        simulation.runSimulation(simulation.loadU1(phase1Item),1);
        System.out.println("Simulation done");
        phase1Rockets = U1.getRocketU1Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);

        simulation.runSimulation(simulation.loadU1(phase2Item),1);
        System.out.println("Simulation done");
        phase2Rockets = U1.getRocketU1Counter() - phase1Rockets;
        System.out.println("Rockets used for phase 2: " + phase2Rockets);

        System.out.println("A total of " + U1.getRocketU1Counter() + " rockets was used.");
        u1Cost = totalCost(1);
        System.out.println("Start simulation for rocket U2");
        simulation.runSimulation(simulation.loadU2(phase1Item), 2);

        phase1Rockets = U2.getRocketU2Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);
        System.out.println("Simulation done");

        simulation.runSimulation(simulation.loadU2(phase2Item), 2);

        phase2Rockets = U2.getRocketU2Counter() - phase1Rockets;
        System.out.println("Rockets used for phase 2: " + phase2Rockets);

        System.out.println("A total of " + U2.getRocketU2Counter() + " rockets was used." + "\n");
        u2Cost = totalCost(2);

        System.out.println("Total budget needed for U1 rockets is: " + u1Cost);
        System.out.println("Total budget needed for U2 rockets is: " + u2Cost);

        if (u1Cost > u2Cost) {
            System.out.println("Using U2 rockets is cheaper in this simulation");
        } else {
            System.out.println("Using U1 rockets is cheaper in this simulation");
        }

    }
    public static long totalCost(int i) {
        return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();
    }
}
