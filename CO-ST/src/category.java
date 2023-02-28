import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class category {

    String currentCategory;
    Scanner scnr = new Scanner(System.in);
    Scanner scnr2 = new Scanner(System.in);
    boolean flag = true;

    double sumHousing = 0;
    double sumUtilities = 0;
    double sumGroceries = 0;
    double sumPersonal = 0;
    double sumEntertainment = 0;
    double totalexpense = 0;

    /* 
    ArrayList<Double> housing = new ArrayList<Double>();
    ArrayList<Double> utilities = new ArrayList<Double>();
    ArrayList<Double> groceries = new ArrayList<Double>();
    ArrayList<Double> personal = new ArrayList<Double>();
    ArrayList<Double> entertainment = new ArrayList<Double>();
    */

    public void chooseCategory(String expense){
    
        do{
            System.out.println("housing(0), utilities(1), groceries(2), personal(3), entertainment(4)");
            System.out.print("");

            switch (scnr.nextInt()){

                case 0:
                try {
                    FileWriter myWriter = new FileWriter("housing.txt", true);
                    myWriter.write("\n");
                    myWriter.write(expense);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false;
                break;

                case 1:
                try {
                    FileWriter myWriter = new FileWriter("utilities.txt", true);
                    myWriter.write("\n");
                    myWriter.write(expense);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false;
                break;

                case 2:
                try {
                    FileWriter myWriter = new FileWriter("groceries.txt", true);
                    myWriter.write("\n");
                    myWriter.write(expense);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false;
                break;

                case 3:
                try {
                    FileWriter myWriter = new FileWriter("personal.txt", true);
                    myWriter.write("\n");
                    myWriter.write(expense);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false;
                break;

                case 4:
                try {
                    FileWriter myWriter = new FileWriter("entertainment.txt", true);
                    myWriter.write("\n");
                    myWriter.write(expense);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false;
                break;

                default:
                System.out.println("PLease choose within given categories");
                continue;
                
            }

            System.out.print("Add more expenses y/n : ");
            String answer = scnr2.nextLine();
            
            if (answer.equals("y"))
                flag = true;
            else
                flag = false;
            
        }while (flag == true);

    }

    public void getSumCategory(){
        try{

            DecimalFormat ft2 = new DecimalFormat("#.##");
            //////////////read housing file//////////////////////
            File housingFile = new File("housing.txt");
            Scanner readHouse = new Scanner(housingFile);
            while(readHouse.hasNextLine()) {
                double dataHouse = readHouse.nextDouble();
                sumHousing += dataHouse;
            }
            System.out.printf("housing : $ %.2f\n", sumHousing);
            readHouse.close();

            //////////////read utilities/////////////////////////
            File utilitiesFile = new File("utilities.txt");
            Scanner readUtilities = new Scanner(utilitiesFile);
            while(readUtilities.hasNextLine()) {
                double dataUtilities = readUtilities.nextDouble();
                sumUtilities += dataUtilities;
            }
            System.out.printf("utilities : $ %.2f\n", sumUtilities);
            readUtilities.close();

            //////////////read groceries/////////////////////////
            File groceriesFile = new File("groceries.txt");
            Scanner readGroceries = new Scanner(groceriesFile);
            while(readGroceries.hasNextLine()) {
                double dataGroceries = readGroceries.nextDouble();
                sumGroceries += dataGroceries;
            }
            System.out.printf("groceries : $ %.2f\n", sumGroceries);
            readGroceries.close();

            //////////////read personal/////////////////////////
            File personalFile = new File("personal.txt");
            Scanner readPersonal = new Scanner(personalFile);
            while(readPersonal.hasNextLine()) {
                double dataPersonal = readPersonal.nextDouble();
                sumPersonal += dataPersonal;
            }
            System.out.printf("personal : $ %.2f\n", sumPersonal);
            readPersonal.close();

            //////////////read entertainment/////////////////////////
            File entertainmentFile = new File("entertainment.txt");
            Scanner readEntertainment = new Scanner(entertainmentFile);
            while(readEntertainment.hasNextLine()) {
                double dataEntertainment = readEntertainment.nextDouble();
                sumEntertainment += dataEntertainment;
            }
            System.out.printf("entertainment : $ %.2f\n", sumEntertainment);
            readEntertainment.close();

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

            //////////////get percentage/////////////////////////
    public void getPercentages(){

        try{

            //////////////read housing file//////////////////////
            File housingFile = new File("housing.txt");
            Scanner readHouse = new Scanner(housingFile);
            while(readHouse.hasNextLine()) {
                double dataHouse = readHouse.nextDouble();
                sumHousing += dataHouse;
            }
            readHouse.close();

            //////////////read utilities/////////////////////////
            File utilitiesFile = new File("utilities.txt");
            Scanner readUtilities = new Scanner(utilitiesFile);
            while(readUtilities.hasNextLine()) {
                double dataUtilities = readUtilities.nextDouble();
                sumUtilities += dataUtilities;
            }
            readUtilities.close();

            //////////////read groceries/////////////////////////
            File groceriesFile = new File("groceries.txt");
            Scanner readGroceries = new Scanner(groceriesFile);
            while(readGroceries.hasNextLine()) {
                double dataGroceries = readGroceries.nextDouble();
                sumGroceries += dataGroceries;
            }
            readGroceries.close();

            //////////////read personal/////////////////////////
            File personalFile = new File("personal.txt");
            Scanner readPersonal = new Scanner(personalFile);
            while(readPersonal.hasNextLine()) {
                double dataPersonal = readPersonal.nextDouble();
                sumPersonal += dataPersonal;
            }
            readPersonal.close();

            //////////////read entertainment/////////////////////////
            File entertainmentFile = new File("entertainment.txt");
            Scanner readEntertainment = new Scanner(entertainmentFile);
            while(readEntertainment.hasNextLine()) {
                double dataEntertainment = readEntertainment.nextDouble();
                sumEntertainment += dataEntertainment;
            }
            readEntertainment.close();

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
        DecimalFormat ft = new DecimalFormat("#.##");
        totalexpense = sumHousing + sumGroceries + sumUtilities + sumPersonal + sumEntertainment;

        double perHousing = sumHousing/totalexpense*100;
        System.out.println("Housing : " + ft.format(perHousing) + "%");
        double perGroceries = sumGroceries/totalexpense*100;
        System.out.println("Groceries : " + ft.format(perGroceries) + "%");
        double perUtilities = sumUtilities/totalexpense*100;
        System.out.println("Utilities : " + ft.format(perUtilities) + "%");
        double perPersonal = sumPersonal/totalexpense*100;
        System.out.println("Personal : " + ft.format(perPersonal) + "%");
        double perEntertainment = sumEntertainment/totalexpense*100;
        System.out.println("Entertainment : " + ft.format(perEntertainment) + "%");
          
    }

}
