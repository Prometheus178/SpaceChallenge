import java.util.Random;

public class U2 extends Rocket {
    private final int cost = 120000000;
    private final int weightOfRocket = 18000;
    private int maxCargo = 11000;
    private double chanceExploded;
    private double chanceCrushed;
    @Override
    public boolean launch() {
        Random randomNum = new Random();
        double chanceLaunched = randomNum.nextDouble();
        chanceExploded = 0.04 * (getTotalWeight() / getMaxCargo());
        if (chanceExploded >= chanceLaunched){
            System.out.println("Rocket U2 exploded");
            return false;
        } else {
            System.out.println("Rocket U2 launched succesfully");
            return true;
        }
    }

    @Override
    public boolean land() {
        Random randomNum = new Random();
        double chanceLanded = randomNum.nextDouble();
        chanceCrushed = 0.08 * (getTotalWeight() / getMaxCargo());
        if (chanceCrushed >= chanceLanded){
            System.out.println("Rocket U2 crushed");
            return false;
        } else {
            System.out.println("Rocket U2 landed successfully");
            return true;
        }
    }
}
