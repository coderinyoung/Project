public class Crop extends Plant {

    private double sellPrice;
    
    public Crop(String name, int daysToGrow, double seedCost , double sellPrice){

        super(name, daysToGrow,seedCost);
        this.sellPrice = sellPrice;
    }

    public double getSellPrice(){return sellPrice;}

    public double harvest(){
        if(this.isReadyToHarvest()){
            return sellPrice;
        }
        return 0;
    }


    @Override
    public String toString(){
        return String.format("Name: %s | Watered: %b | Growth: %d/%d ", getName(),getWaterStatus(),getCurrentGrowth(),getDaysToGrow());
    }

}