// Jessica Hsieh
// 4/25/17
// CSE142
// TA: Alex Demeo
// Assignment #4
//
// This program will compare the scores of two applicants and see which person seems stronger.

import java.util.*;

public class Admit {
   public static void main(String[] args) {
      introduction();
      Scanner console = new Scanner(System.in);
      double score1 = getScores(console, 1);
      double gpa1 = getGPA(console);
      double score2 = getScores(console, 2);
      double gpa2 = getGPA(console);
      result(score1, score2, gpa1, gpa2);
   }
   
   // This method introduces the program to the user.
   public static void introduction() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
   }
   
   // This method gathers the two applicants' scores.
   // The parameter includes scanner console, and applicant is the number that represents the applicant.
   // Returns getSAT or getACT.  
   public static double getScores(Scanner console, int applicant) {
      System.out.println();
      System.out.println("Information for applicant #" + applicant + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int test = console.nextInt();
      if (test == 1) {
         return getSAT(console);  
      } else { // test == 2
         return getACT(console);
      }
   }
   
   // Gathers the applicant's SAT score, includes scanner console in the parameter.
   // Returns the exam score of SAT.
   public static double getSAT(Scanner console) {
      System.out.print("    SAT math? ");
      int math = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      double score1 = examScoreSAT(math, writing, reading);
      return score1;
   }
   
   // Gathers the applicant's ACT score, includes scanner console in the parameter.
   // Returns the exam score of ACT.
   public static double getACT(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int math = console.nextInt();
      System.out.print("    ACT reading? ");
      int reading = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      double score2 = examScoreACT(english, math, reading, science);
      return score2;
   }

   // Calculates the exam score by using SAT.
   // Paramter: math is the math score; reading is the reading score; writing is the writing score.
   // Returns the calculation of the exam score by using SAT.
   public static double examScoreSAT(int math, int reading, int writing) {
      double scoreSAT = 0.0;
      scoreSAT = (2 * math + reading + writing) / 32.0;
      System.out.print("    exam score = " + round(scoreSAT));
      System.out.println();
      return scoreSAT;
   }
   
   // Calculates the exam score by using ACT.
   // Parameter: english is the English score; math is the math score; reading is the reading score; science is the science score.
   // Returns the calculation of the exam score by using ACT.
   public static double examScoreACT(int english, int math, int reading, int science) {
      double scoreACT = 0.0;
      scoreACT = (english + 2 * math + reading + science) / 1.8;
      System.out.print("    exam score = " + round(scoreACT));
      System.out.println();
      return scoreACT;
   }
   
   // Gathers the two applicants'GPA scores, includes scanner console in the parameter.
   // Returns GPA.
   public static double getGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double overallGPA = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGPA = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double transcriptMultiplier = console.nextDouble();
      double gpa = gpaScore(overallGPA, maxGPA, transcriptMultiplier);
      return gpa;  
   }
   
   // Calculates the GPA scores.
   // Paramter: overallGPA is the overall GPA of the applicant; maxGPA is the max GPA of the applicant; transciptMultiplier is the transcript multiplier.
   // Returns the calculation of GPA.
   public static double gpaScore(double overallGPA, double maxGPA, double transcriptMultiplier) {
      double calcGPA = 0.0;
      calcGPA = (overallGPA / maxGPA) * 100 * transcriptMultiplier;
      System.out.println("    GPA score = " + round(calcGPA));
      return calcGPA;
   }
   
   // Shows the result of the comparison.
   // Parameter: score1 and gpa1 are the score and GPA of applicant #1, score2 and gpa2 are the score and GPA of applicant #2.
   // Prints out the result of the comparison.
   public static void result(double score1, double score2, double gpa1, double gpa2) {
      System.out.println();
      double overall1 = score1 + gpa1;
      double overall2 = score2 + gpa2;
      System.out.println("First applicant overall score  = " + round(overall1));
      System.out.println("Second applicant overall score = " + round(overall2));
      if (overall1 < overall2) {
         System.out.println("The second applicant seems to be better");
      } else if (overall1 == overall2) {
         System.out.println("The two applicants seem to be equal");
      } else { // overall1 > overall2
         System.out.println("The first applicant seems to be better");
      }
   }

   // Parameter includes a double that needs to round up.
   // Returns the result of rounding n to one decimal place.
   public static double round(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}