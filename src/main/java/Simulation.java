import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {
    private boolean hasLanded = true;
    private long budgetNeeded = 0;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Rocket> rocketU1 = new ArrayList<Rocket>();
    private ArrayList<Rocket> rocketU2 = new ArrayList<Rocket>();
    File phase1 = new File("src/main/java/Phase-1");
    File phase2 = new File("src/main/java/Phase-2");

    public ArrayList<Item> loadItems(int phase) throws FileNotFoundException {
        if (phase ==1){
            loadPerPhaseItems(phase1);
        }else {
            loadPerPhaseItems(phase2);
        }return items;

    }
    public void loadPerPhaseItems(File file) throws FileNotFoundException {
        items = new ArrayList();
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String string = fileScanner.nextLine();
            String[] separated = string.split("=");

            Item item = new Item(separated[0], Integer.parseInt(separated[1]));
            items.add(item);
        }
    }
    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsU1){
        System.out.println("Load U1 started");
        Rocket rocket  = new U1();
        Iterator iterator = itemsU1.iterator();

        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)){
                rocket.carry(item);
            } else{
                rocketU1.add(rocket);
                rocket = new U1();
                System.out.println("New rocket U1 created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()){
                rocketU1.add(rocket);
            }
        }
        return rocketU1;
    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsU2){
        System.out.println("Load U2 started");
        Rocket rocket = new U2();
        Iterator iterator = itemsU2.iterator();
        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)){
                rocket.carry(item);
            } else {
                rocketU2.add(rocket);
                rocket = new U2();
                System.out.println("New rocket U2 created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()){
                rocketU2.add(rocket);
            }
        }
        return rocketU2;
    }
    public void runSimulation(ArrayList<Rocket> rockets, int i){
        for (Rocket rocket : rockets) {

            while (!rocket.launch()) {
                launchSimulation(i);
            }

            while (!rocket.land()) {
                while (!rocket.launch()) {
                    launchSimulation(i);
                }
                landSimulation(i);
            }

        }

    }
    public void launchSimulation(int i) {

        if (i == 1) {
            int counter1 = U1.getRocketU1Counter();
            counter1++;
            U1.setRocketU1Counter(counter1);

        } else {
            int counter1 = U2.getRocketU2Counter();
            counter1++;
            U2.setRocketU2Counter(counter1);

        }
    }
    public void landSimulation(int i) {
        if (i == 1) {
            int counter = U1.getRocketU1Counter();
            counter++;
            U1.setRocketU1Counter(counter);

        } else {
            int counter = U2.getRocketU2Counter();
            counter++;
            U2.setRocketU2Counter(counter);
        }
        hasLanded = false;
    }

}
