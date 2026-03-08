public abstract class Plant implements Comparable<Plant> {
    private String name;
    private int daysToGrow;
    private int currentGrowth;
    private boolean watered = false;
    private double seedCost;


    public Plant(String name, int daysToGrow, double seedCost){
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.currentGrowth = 0;
        this.seedCost = seedCost;
    }

    public Plant(String name){
        this(name,5,10);
    }

    public String getName(){return name;}
    public int getDaysToGrow(){return daysToGrow;}
    public boolean getWaterStatus() {return watered;}
    public int getCurrentGrowth() {return currentGrowth;}
    public double getSeedCost() {return seedCost;}

    public void resetWaterStatus(){
        watered = false;
    }

    public void water(){
        watered = true;
    }

    public void grow(){
        if (watered){
            currentGrowth++;
            watered = false;
        }
    }

    public boolean isReadyToHarvest(){
        return currentGrowth >= daysToGrow;
    }
    public abstract double harvest();

    @Override
    public String toString(){
        return String.format("Name: %s | Watered: %b | Growth: %d/%d ", name,watered,currentGrowth,daysToGrow);
    }

    @Override
    public int compareTo(Plant other){
        return this.daysToGrow - other.daysToGrow;
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if (!(other instanceof Plant)){
            return false;
        }

        Plant o = (Plant) other; 

        if(this.name.equals(o.name) && this.daysToGrow == o.daysToGrow){
            return true;
        }

        return false;
    }
    

}
