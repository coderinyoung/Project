import java.util.ArrayList;
import java.util.Collections;

public class Farm {

    // Variable 
    private int day;
    private ArrayList <Plant> plants; 
    private double money;

    //Constructor
    public Farm(){
        this.day = 1;
        this.money = 20;
        plants = new ArrayList<Plant>();
    }

    // Getters
    public int getDays() {return day;}
    public double getMoney() {return money;}

    // Allows users to buy and plant crops
    public void plantSeeds(Plant p){
        //Check if you have enough money to buy plant
        if(money >= p.getSeedCost()){
            money -= p.getSeedCost();
            plants.add(p);
        }
        else{
            System.out.print(String.format("You don't have enough money to buy %s",p.getName()));
        }
    }

    // Allows users to individual water unwatered plants
    public void water(int plantIndex){
        //Checks if index exist in planted plants
       if(plantIndex >= 0 && plantIndex < plants.size()){
            if(!(plants.get(plantIndex).getWaterStatus())){
                plants.get(plantIndex).water();
            }
       }
    }

    // Helps with day end logic
    public void nextDay(){
        day += 1;

        ArrayList <Plant> updatedPlant = new ArrayList<Plant>();

        //Loops through plant by plant to excute logic
        for(int i = 0; i < plants.size() ;i++){
            Plant p = plants.get(i);
            //Checks if the plant has not been watered
            if(!(p.getWaterStatus())){
                p.setCurrentGrowth(0);
                System.out.println(String.format("%s died cause you didn't water it\n", p.getName()));
            }
            //Checks if plant is too late to harvest
            else if(p.isReadyToHarvest()){
                p.setCurrentGrowth(0);
                p.resetWaterStatus();
                System.out.println(String.format("%s rotted cause you didn't harvest it\n", p.getName()));
            }
            else{
                p.grow();
                p.resetWaterStatus();
                updatedPlant.add(p);
            }
        }

        plants = updatedPlant;
    }
    //Allows user to harvest crops that are ready
    public void harvestPlants(int plantIndex){
        if(plantIndex >= 0 && plantIndex < plants.size()){
            //Checks if plant is ready to harvest
            if(plants.get(plantIndex).isReadyToHarvest()){
                money += plants.get(plantIndex).harvest();
                plants.remove(plantIndex);
            }
            else{
                System.out.println("You can't harvest");
            }
        }
    }

    //Sorts the array of Plants
    public ArrayList<Plant> sortPlants(){
        Collections.sort(plants);
        return plants;
    }

}