import java.util.Random;

public class U1 extends Rocket{

    private static final int cost = 100000000;
    private final int weightOfRocket = 10000;
    private int maxCargo = 8000;
    private double chanceExploded;
    private double chanceCrushed;
    private static int rocketU1Counter;
    public U1() {
        this(0);
    }

    public U1(int lastWeight) {
        setMaxCargo(maxCargo);
        setCost(cost);
        setWeight(weightOfRocket);
        setCurrentWeight(lastWeight);
        rocketU1Counter++;
    }

    public static int getRocketU1Counter() {
        return rocketU1Counter;
    }

    public static void setRocketU1Counter(int rocketU1Counter) {
        U1.rocketU1Counter = rocketU1Counter;
    }


    @Override
    public boolean launch() {
        Random randomNum = new Random();
        double chanceLaunched = randomNum.nextDouble();
        chanceExploded = 0.05 * getTotalWeight() / getMaxCargo();
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
        chanceCrushed = 0.01 * getTotalWeight() / getMaxCargo();
        if (chanceCrushed >= chanceLanded){
            System.out.println("Rocket U1 crushed");
            return false;
        } else {
            System.out.println("Rocket U1 landed successfully");
            return true;
        }
    }
    public static long getTotalCost(){
        return getRocketU1Counter() * cost;
    }
}
