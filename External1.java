import java.util.*;
import java.io.*;

/**
 * Write a description of class External1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class External1
{
    
    //this adds more style to the display and printed outcomes.
        public static void displayDivider(int divider){
          for (int i = 1; i < divider; i++){
           System.out.print("=");
          }
    }
    
    //this method will read the file that is given. in this case project2IN.txt
    public static void readFile(String[] names,double[][] stuscores){
        System.out.println("Reading from input file project2IN.txt");
           try{
              Scanner scanner = new Scanner(new File("project2IN.txt"));
              int i = 0;
              String first,last;
              //this while look will cycle through all of the scores given in the txt file.
              //this part is extended to the gradebook class
              //so the stuscores is actually an array created in the gradebook class, which then takes that as one of the
              //pramaters. afterwards the variables are saved to it from this class.
                while(scanner.hasNext()){
                    first = scanner.next();
                    //because we know that its first name first, and then last, we create temp variables called first and last
                    //and later switch them around to whats required. 
                    last = scanner.next();
                    names[i] = last+", "+first;
                    stuscores[i][0] = scanner.nextDouble();
                    stuscores[i][1] = scanner.nextDouble();
                    stuscores[i][2] = scanner.nextDouble();
                    i++;
                    //so as not to overload the array, we go until the column has been reached. in this case 5.
                    if(i == 5){
                        break;
                    }
                }
              System.out.println("Closing Input File");
              scanner.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
    }
    
    //this method will write the data into the txt file that we have. in this case project2OUT.txt
    public static void writeData(String [] names, double [][] stuscores, String [] letter){
          // Writest the data out to the .txt file neatly and in an organized fashion.
          System.out.println("Writting to output file project2OUT.txt");
        try{
           PrintWriter writer = new PrintWriter(new File("project2OUT.txt"));
           //this displayDivider adds the divider so it is easier for the user to read
           displayDivider(60);
           System.out.println();
           writer.printf("%16s %8s %9s %9s %9s %6s\n", "Name", "Score1", "Score2", "Score3", "Average", "Grade");;
           displayDivider(60);
           writer.println();
           System.out.println();
           //this look cycles through all of the names and posts them, with their scores and average, and also their letter grade
           for (int h=0; h< names.length; h++){
               writer.printf("%16s", names[h]);
                for (int j=0; j<stuscores[h].length; j++){
                    writer.printf("%9.2f ", stuscores[h][j]);
               }
               writer.printf("%4s", letter[h]);
               writer.println();
           }
           writer.println();
           System.out.println("Closing Output File");
           writer.close();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
}
