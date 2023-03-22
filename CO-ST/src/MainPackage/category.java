package MainPackage;
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


    // this method let user choose with category the expenses going to be saved in.
    // this method will write the expenses and save it into the file in choosen category.
    public void chooseCategory(String expense){
    
        do{ 
            // this loop will keep looping if the user put in invalid input.
            // this loop has a flag that is set to true and will run until the flag turn false.

            System.out.println("housing(0), utilities(1), groceries(2), personal(3), entertainment(4)"); //Asking a user which category the expenses going to be saved in.
            System.out.print("");

            switch (scnr.nextInt()){ //the switch case will evaluate user input to choose which category file will be used to save the expensesaved.

                case 0:
                try { // will try to execute this block of code.
                    FileWriter myWriter = new FileWriter("housing.txt", true); // Define and open a file that will be written in. in this case "housing.txt".The append is set to true so it will add data instead of overwriting it.
                    myWriter.write("\n"); // add a new line before adding new data.
                    myWriter.write(expense);  // write the data that will be saved in the file.                                                   
                    myWriter.close();         //close the file.
                } catch (IOException e) {     // if its failed this block of code will be execute instead.
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                flag = false; // the flag value to false thus will break the do while loop.
                break;        // break out from switch case.

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
                System.out.println("PLease choose within given categories"); // in case that the user key in invalid input, this will be print out.
                continue; // instead of breaking out from the switch statement, continue will start the do while loop all over again.
                
            }

            
        }while (flag == true);

    }


    // this method will get the sum of expenses in each of the categories.
    // this method will read the expensess in the file and calculate the sum of each category.

    public void getSumCategory(){
        try{


            //////////////read housing file//////////////////////
            File housingFile = new File("housing.txt"); // open the file that mentioned in the pathman so it can be read.
            Scanner readHouse = new Scanner(housingFile);        // using scanner class to read the file.
            while(readHouse.hasNextLine()) {                     // while the file has a line, the code will keep reading the next line until no line left.
                double dataHouse = readHouse.nextDouble();       // though the input of the is in string, it can be read out as other data type as long as it valid, in this case double.
                sumHousing += dataHouse;                         // adding up the data of each line to get the sum of expenses in the category.
            }
            System.out.printf("housing : $ %.2f\n", sumHousing); // print out the sum of the category in such format($##.##)
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

    
    // this methoed will calculate the percentage of the total expenses by the category
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
        
        DecimalFormat ft = new DecimalFormat("#.##"); //DecimalFormat class is used to easlly setup the format that is going to be used later in the code block.
        totalexpense = sumHousing + sumGroceries + sumUtilities + sumPersonal + sumEntertainment; // adding up all of the expenses from all category.

        double perHousing = sumHousing/totalexpense*100;  // dividing the sum of the category by the total and multiply it by 100 to get the percentage of each category.
        System.out.println("Housing : " + ft.format(perHousing) + "%");  // print out the percentage of the category in such format (##.##$%)
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
