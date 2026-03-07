public class Crop extends Plant implements Comparable<Plant>{

    private double seedCost;
    private double sellPrice;


    public Crop(String name, int daysToGrow, double price, double seedCost , double sellPrice){

        super(name, daysToGrow, price);
        this.seedCost = seedCost;
        this.sellPrice = sellPrice;
    }

    

    public void harvest(){

    }

}