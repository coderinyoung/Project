public abstract class Plant implements Comparable<Plant> {

    //Variables
    private String name;
    private int daysToGrow;
    private int currentGrowth;
    private boolean watered = false;
    private double seedCost;

    // Constructor
    public Plant(String name, int daysToGrow, double seedCost){
        this.name = name;
        this.daysToGrow = daysToGrow;
        this.currentGrowth = 0;
        this.seedCost = seedCost;
    }

    //Getter and Setters
    public String getName(){return name;}
    public int getDaysToGrow(){return daysToGrow;}
    public boolean getWaterStatus() {return watered;}
    public int getCurrentGrowth() {return currentGrowth;}
    public double getSeedCost() {return seedCost;}

    public void setCurrentGrowth(int currentGrowth) {this.currentGrowth = currentGrowth;}


    // Resets water
    public void resetWaterStatus(){
        watered = false;
    }

    // Waters plant
    public void water(){
        watered = true;
    }

    // Helps grow plant if watered
    public void grow(){
        if (watered){
            currentGrowth++;
            watered = false;
        }
    }

    //Checks if ready to harvest
    public boolean isReadyToHarvest(){
        return currentGrowth >= daysToGrow;
    }

    // create abstract method
    public abstract double harvest();

    // Overides compareTo to base it on day to grow
    @Override
    public int compareTo(Plant other){
        return this.daysToGrow - other.daysToGrow;
    }

    // Overides equals 
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
