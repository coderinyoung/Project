public abstract class Plant implements Comparable<Plant> {
    private String name;
    private int daysToGrow;
    private int currentGrowth;
    private boolean watered = false;


    public Plant(String name, int daysToGrow, double price){
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.currentGrowth = 0;
    }

    public Plant(String name){
        this(name,5,10.00);
    }

    public String getname(){return name;}
    public int getDaysToGrow(){return daysToGrow;}
    public boolean getWaterStatus() {return watered;}
    public int getCurrentGrowth() {return currentGrowth;}


    public void water(){
        watered = true;
    }

    public void grow(){
        if (watered == true){
            currentGrowth++;
        }
    }

    public boolean isReadyToHarvest(){
        if(currentGrowth >= daysToGrow){
            return true;
        }
        return false;
    }

    public abstract void harvest();

    @Override
    public String toString(){
        return String.format("Name: %s | Watered: %b | Growth: %d/%d | Price: %d", name,watered,currentGrowth,daysToGrow,price);
    }

    @Override
    public int compareTo(Plant other){
        return this.daysToGrow - other.daysToGrow;

    }
    

}
