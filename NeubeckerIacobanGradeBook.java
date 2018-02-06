import java.io.*;
import java.util.Scanner;

/**
 * In this class we will be reading in from a .txt file and saving the data into two arrays
 * With the information saved we will manipulate it to then compute score averages, determine their letter grades,
 * and save the new data acquired into a different .txt file.
 * Tyler Neubecker, Jacob Iacoban
 * 1/30/18
 */

class NeubeckerIacobanGradeBook extends External1{
    
        public static void calculateAverages (String [] str, double [][] studentscores){
          //computes the averages for each student
          System.out.println();
          System.out.println("\nComputing averages...");
          double total;
          //declares the increments for loops
          int j;
          int i;
          //this loop will cycle through all of the students and print their averages.
          for(i=0; i<studentscores[i].length; i++){
           total=0.0;
           for (j=0; j<studentscores[i].length-1;j++)
           {
            total = total + studentscores[i][j];
           }
           if (j==studentscores[i].length-1){
            studentscores[i][3]=total/3;
            System.out.println("Average for "+str[i]+" is "+(total/3));
           }
          }
    }
    
    //determiens the lettergrade using a new array called letter, and a loop.
    public static void letterGrade(String[] grade,double[][] studentscores){
          //because we know there are more than one students getting grades, its done in a loop to make things easier.
          for(int i = 0;i<grade.length;i++){
              
           if(studentscores[i][3] >= 89.5){
            grade[i] = "A";
            
           }else if(studentscores[i][3] >= 79.5){
            grade[i] = "B";
            
           }else if(studentscores[i][3] >= 69.5){
            grade[i] = "C";
            
           }else if(studentscores[i][3] >= 59.5){
            grade[i] = "D";
            
           }else{
            grade[i] = "F";
            
           }
          }
    }

    public static void displayData (String [] names,double [] [] studentscores){
          // Displays the student names and scores for each student in a nice format
          
          System.out.print("\nDisplaying data as stored:\n");
          displayDivider(60);
          System.out.println();
          System.out.printf("%16s %8s %9s %9s %9s\n", "Name", "Score1", "Score2", "Score3", "Average");
          displayDivider(60);
          System.out.println();
          
          //prints all of the info from a loop, instead of as hard code
          for (int n=0; n< names.length; n++){
           System.out.printf("%16s", names[n]);
           for (int h=0; h<studentscores[h].length-1; h++){
            System.out.printf("%9.2f ", studentscores[n][h]);
           }
           System.out.println();
          }
    }
    
    public static void displayData2(String [] names, double [][] studentscores, String [] grade){
          // Displays the student names, scores, average and letter grade for each student neatly
          
          displayDivider(60);
          System.out.println();
          System.out.printf("%16s %8s %9s %9s %9s %6s\n", "Name", "Score1", "Score2", "Score3", "Average", "Grade");
          displayDivider(60);
          System.out.println();
          
          //same code as the above method, but this just posts the letter grade as well
          for (int h=0; h< names.length; h++){
           System.out.printf("%16s", names[h]);
           for (int j=0; j<studentscores[h].length; j++){
            System.out.printf("%9.2f ", studentscores[h][j]);
           }
           System.out.printf("%5s", grade[h]);
           System.out.println();
          }
          System.out.println();
    }
    
    
    //this adds more style to the sheet and whats printed. 
        public static void displayDivider(int divider){
          for (int i = 1; i < divider; i++){
           System.out.print("=");
          }
    }
    
    
    
    /* all of the required arays are created in the main method. not above as public because it will run into a 
       non-static variable issue.
       we then call onto all of the required methods. I could have used super() for this because this is
       an extension of the external class, but i decided not to just to be safe and wanted to make sure everything worked good
       
    */
    
    public static void main(String[] args) {
          String[] names = new String[5];
          double[][] studentscores = new double[5][4];
          String[] grade = new String[5];
          readFile(names,studentscores);
          displayData(names,studentscores);
          calculateAverages(names,studentscores);
          letterGrade(grade,studentscores);
          displayData2(names,studentscores,grade);
          writeData(names,studentscores,grade);
    }
}
