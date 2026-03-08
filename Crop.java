public class Crop extends Plant {

    //Variable
    private double sellPrice;

    //Dynamic Constructor
    public Crop(String name, int daysToGrow, double seedCost , double sellPrice){

        super(name, daysToGrow,seedCost);
        this.sellPrice = sellPrice;
    }
    public Crop(String name){
        this(name,2,3,6);
    }

    //Getter
    public double getSellPrice(){return sellPrice;}
    

    //Determines if plant is ready for harvest and returns sell price
    public double harvest(){
        if(this.isReadyToHarvest()){
            return sellPrice;
        }
        return 0;
    }


    // Helps format how the crop object is printed
    @Override
    public String toString(){
        return String.format("Name: %s | Watered: %b | Growth: %d/%d | Seed Cost: %.2f | Sell Price: %.2f ", getName(),getWaterStatus(),getCurrentGrowth(),getDaysToGrow(), getSeedCost(), getSellPrice());
    }

}