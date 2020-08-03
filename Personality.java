// Jessica Hsieh
// 5/23/17
// CSE142
// TA: Alex Demeo
// Assignment #7
//
// This program computes the scores and overall result for each person and shows
// the personality type"\"" + (3 + 3 * 3 + "" + 3 + 3 * 3 + "\"")"\"" + (3 + 3 * 3 + "" + 3 + 3 * 3 + "\"") in the output file.

import java.io.*;
import java.util.*;

public class Personality {
   public static final int DIMENSION = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      introduction();
      Scanner console = new Scanner(System.in);
      String inputFile = askInput(console);
      String outputFile = askOutput(console);
      Scanner input = new Scanner(new File(inputFile));
      PrintStream output = new PrintStream(new File(outputFile));
      while (input.hasNextLine()) {
         String name = input.nextLine();
         String answer = input.nextLine();
         int[] percent = calculate(answer);
         ProcessFile(output, name, percent);
      } 
   }
   
   // Gives the user an introduction of this program.
   public static void introduction() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Asks the user the name of input file.
   // Takes a Scanner that allows the user to type the input file name
   // as a paramter, and returns it as a String.
   public static String askInput(Scanner console) {
      System.out.print("input file name? ");
      String inputFile = console.next();
      return inputFile;
   }
   
   // Asks the user the name of the output file.
   // Takes a Scanner that allows the user to type the output file name
   // as a paramter, and returns it as a String.
   public static String askOutput(Scanner console) {
      System.out.print("output file name? ");
      String outputFile = console.next();
      return outputFile; 
   }
   
   // Counts how many A's or B's for each dimension.
   // Parameters: String answer (70 answers for the questions), and char a
   // (letter either A or B). 
   // Returns an array for the number of characters in each dimension.
   public static int[] count(String answer, char a) {
      int[] counting = new int[DIMENSION];
      for (int i = 0; i < answer.length(); i++) {
         char letter = answer.toUpperCase().charAt(i);
         if (letter == a) {
            if (i % 7 == 0) {
               counting[0]++;
            } else if (i % 7 == 1 || i % 7 == 2) {
               counting[1]++;
            } else if (i % 7 == 3 || i % 7 == 4) {
               counting[2]++;
            } else { // (i % 7 == 5 || i % 7 == 6)
               counting[3]++;
            }
         }
      }
      return counting;
   }
   
   // Calculates the percentage of B answers the user gave for that dimension.
   // Parameter: String answer (70 answers from the user).
   // Returns the array that contains percentage of B for each dimension.
   public static int[] calculate(String answer) {
      int[] percent = new int[DIMENSION];
      int[] countA = count(answer, 'A');
      int[] countB = count(answer, 'B');
      for (int i = 0; i < DIMENSION; i++) {
         double percentage = countB[i] * 100.0 / (countA[i] + countB[i]);
         percent[i] = (int) Math.round(percentage);
      }
      return percent;
   }
   
   // Processes the given input file, and sends the information to the output.
   // Parameters: PrintStream output (generates output file), String name (user's name),
   // int[] percent (array that contains percentage of B for each dimension).
   public static void ProcessFile(PrintStream output, String name, int[] percent) {
      String person = "";      
      char[] type = {'E', 'S', 'T', 'J'};
      char[] type2 = {'I', 'N', 'F', 'P'};
      for (int i = 0; i < DIMENSION; i++) {
         if (percent[i] > 50) {
            person += type2[i];
         } else if (percent[i] < 50) {
            person += type[i];
         } else { // percent[i] = 50
            person += "X";
         }
      }
      output.println(name + ": " + Arrays.toString(percent) + " = " + person);
   }
}