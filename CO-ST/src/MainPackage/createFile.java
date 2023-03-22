package MainPackage;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileWriter;

//this class will create the file that we going to use to store and categorize the expenses


public class createFile {

    public void buildFile(){

    try {
        File house = new File("housing.txt");
        if (house.createNewFile()) {
          System.out.println("File created: " + house.getName());
        } else {
          System.out.println("File already exists.");
        }
        FileWriter myWriter = new FileWriter("housing.txt", true);
          myWriter.write("0.00");
          myWriter.close();

        File utilities = new File("utilities.txt");
        if (utilities.createNewFile()) {
          System.out.println("File created: " + utilities.getName());
        } else {
          System.out.println("File already exists.");
        }
        FileWriter myWriter2 = new FileWriter("utilities.txt", true);
          myWriter2.write("0.00");
          myWriter2.close();

        File groceries = new File("groceries.txt");
        if (groceries.createNewFile()) {
          System.out.println("File created: " + groceries.getName());
        } else {
          System.out.println("File already exists.");
        }
        FileWriter myWriter3 = new FileWriter("groceries.txt", true);
          myWriter3.write("0.00");
          myWriter3.close();

        File personal = new File("personal.txt");
        if (personal.createNewFile()) {
          System.out.println("File created: " + personal.getName());
        } else {
          System.out.println("File already exists.");
        }
        FileWriter myWriter4 = new FileWriter("personal.txt", true);
          myWriter4.write("0.00");
          myWriter4.close();

        File entertainment = new File("entertainment.txt");
        if (entertainment.createNewFile()) {
          System.out.println("File created: " + entertainment.getName());
        } else {
          System.out.println("File already exists.");
        }
        FileWriter myWriter5 = new FileWriter("entertainment.txt", true);
          myWriter5.write("0.00");
          myWriter5.close();

      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}
    

