import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Project1 {

    public static void main(String[] args) {

        boolean gameState = true;

        // Intializes an instance Farm Class 
        Farm farm = new Farm();

        // Intializes all crop objects 
        Crop tomato = new Crop( "tomato");
        Crop lettuce = new Crop ("lettuce",4,4,10);
        Crop basil = new Crop("basil", 3, 3,8);

        System.out.println("Welcome to the farm, In this game, you're a farmer with the goal to make the most money buying, growing and selling crops");
        System.out.println("You start from humble beginnings you have $20 to buy the seeds you need");

        // Loops through game  
        while (gameState) {

            //Displays Game Menu
            System.out.println(String.format("\nWelcome to Day %d", farm.getDays()));
            System.out.println(String.format("Bank Account: %.2f", farm.getMoney()));

            System.out.println("1. Plant Seeds");
            System.out.println("2. Water Plant");
            System.out.println("3. Harvest crop");
            System.out.println("4. Display Planted Crops");
            System.out.println("5. Skip to next day");
            System.out.println("6. End Game");

            System.out.println("Enter Selection:");

            // Accepts user selection 
            Scanner input = new Scanner(System.in);

            int user = input.nextInt();

            //Checks if selection is alid
            if(user < 1 || user < 6){
                System.out.println("Enter a value from  1 - 6");
                continue;
            }

            //Checks the users selections and calls the needed function from the class
            switch (user) {
                case 1:
                    System.out.println("Selection:");
                    System.out.println("1. " + tomato);
                    System.out.println("2. " + lettuce);
                    System.out.println("3 ." + basil); 
                    System.out.println("Enter Selection (1 - 3): ");
                    int slct = input.nextInt();
                    switch (slct) {
                        case 1:
                            farm.plantSeeds(tomato);
                            break;
                        case 2:
                             farm.plantSeeds(lettuce);
                             break;
                        case 3:
                             farm.plantSeeds(basil);
                             break;
                    }
                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());
                    
                    break;
                case 2:
                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());

                    System.out.println("\nEnter the index plant: ");
                    int wslct = input.nextInt();

                    farm.sortPlants().get(wslct - 1).water();

                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());
                    break;
                case 3:
                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());

                    System.out.println("\nEnter the index plant: ");
                    int hslct = input.nextInt();

                    farm.harvestPlants(hslct - 1);

                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());

                case 4:
                    System.out.println("Planted Crops:");
                    PlantedCrops(farm.sortPlants());
                    break;

                case 5:
                    farm.nextDay();
                    break;
                case 6:
                    gameState = false;
                    break;

            }
            
            input.close();
        }


    }

    // Function to help display the crops in the array
    public static void PlantedCrops( ArrayList<Plant> plants){
        for (Plant i : plants){
            System.out.println(String.format("%d. %s (%d/%d) | Watered: %b", plants.indexOf(i) + 1, i.getName(), i.getCurrentGrowth(),i.getDaysToGrow(), i.getWaterStatus()));
        }

    }
}