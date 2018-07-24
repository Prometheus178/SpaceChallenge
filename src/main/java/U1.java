import java.util.Random;

public class U1 extends Rocket{

    private final int cost = 100000000;
    private final int weightOfRocket = 10000;
    private int maxCargo = 8000;
    private double chanceExploded;
    private double chanceCrushed;

    @Override
    public boolean launch() {
        Random randomNum = new Random();
        double chanceLaunched = randomNum.nextDouble();
        chanceExploded = 0.05 * (getTotalWeight() / getMaxCargo());
        if (chanceExploded >= chanceLaunched){
            System.out.println("Rocket U1 exploded");
            return false;
        } else {
            System.out.println("Rocket U1 launched succesfully");
            return true;
        }
    }

    @Override
    public boolean land() {
        Random randomNum = new Random();
        double chanceLanded = randomNum.nextDouble();
        chanceCrushed = 0.01 * (getTotalWeight() / getMaxCargo());
        if (chanceCrushed >= chanceLanded){
            System.out.println("Rocket U1 crushed");
            return false;
        } else {
            System.out.println("Rocket U1 landed successfully");
            return true;
        }
    }
}
