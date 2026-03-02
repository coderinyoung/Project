public class Plant {
    private String name;
    private int daysToGrow;
    private double price;
    private int currentGrowth;
    private boolean watered;


    public Plant(String name, int daysToGrow, double price){
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.price = price;
        this.currentGrowth = 0;
    }

    public Plant(String name){
        this(name,5,10.00);
    }
     
    

}
