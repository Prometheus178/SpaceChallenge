public class Rocket implements SpaceShip{
    private int cost;
    private int currentWeight;
    private int weightOfRocket;
    private int maxCargo;
    private double totalWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return false;
    }

    public void carry(Item item) {

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getWeight() {
        return weightOfRocket;
    }

    public void setWeight(int weight) {
        this.weightOfRocket = weight;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;
    }

    public double getTotalWeight() {
        totalWeight = getCurrentWeight() + getWeight();
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
