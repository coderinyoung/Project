import java.util.ArrayList;
import java.util.Collections;

public class Farm {

    private int day;
    private ArrayList <Plant> plants; 
    private double money;

    public Farm(){
        this.day = 1;
        this.money = 20;
        plants = new ArrayList<Plant>();
    }

    public int getDays() {return day;}
    public double getMoney() {return money;}


    public void plantSeeds(Plant p){
        if(money >= p.getSeedCost()){
            money -= p.getSeedCost();
            plants.add(p);
        }
    }

    public void water(int plantIndex){
       if(plantIndex >= 0 && plantIndex < plants.size()){
            if(!(plants.get(plantIndex).getWaterStatus())){
                plants.get(plantIndex).water();
            }
       }
    }

    public String nextDay(){
        String report = "";
        day += 1;

        ArrayList <Plant> updatedPlant = new ArrayList<Plant>();

        for(int i = 0; i < plants.size() ;i++){
            Plant p = plants.get(i);
            if(!(p.getWaterStatus())){
                report += String.format("%s died cause you didn't water it\n", p.getName());
            }
            else if(p.isReadyToHarvest()){
                report += String.format("%s rotted cause you didn't harvest it\n", p.getName());
            }
            else{
                p.grow();
                p.resetWaterStatus();
                updatedPlant.add(p);
            }
        }

        plants = updatedPlant;

        return report;
    }

    public void harvestPlants(int plantIndex){
        if(plantIndex >= 0 && plantIndex < plants.size()){
            if(plants.get(plantIndex).isReadyToHarvest()){
                money += plants.get(plantIndex).harvest();
                plants.remove(plantIndex);
            }
        }
    }

    public ArrayList<Plant> sortPlants(){
        Collections.sort(plants);
        return plants;
    }

}