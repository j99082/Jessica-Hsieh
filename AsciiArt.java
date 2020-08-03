// Jessica Hsieh
// 4/11/17
// CSE142
// TA: Alex Demeo
// Assignment #2 Part A
// 
// This program will print out a hourglass I designed.

public class AsciiArt {
   public static void main(String[] args) {
      line();
      top();
      middle();
      bottom();
      line();
   }
   
   // Prints out the top and bottom line of the hourglass.
   public static void line() {
      for (int i = 1; i <= 20; i++) {
         System.out.print("=");
      }
      System.out.println();
   }
   
   // Prints out the top half of the hourglass.
   public static void top() {
      for (int line = 1; line <= 4; line++) {
         for (int space = 1; space <= line; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int figure = 1; figure <= (-1 * line + 9); figure++) {
            System.out.print("+.");
         }
         System.out.println("|"); 
      }  
   }
   
   // Prints out the middle part of the hourglass.
   public static void middle() {
      for (int line = 1; line <= 2; line++) {
         for (int space = 1; space <= 5; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int z = 1; z <= 8; z++) {
            System.out.print("z");
         }
         System.out.println("|");
      }
   }
   
   // Prints out the bottom half of the hourglass.
   public static void bottom() {
      for (int line = 4; line >= 1; line--) {
         for (int space = 1; space <= line; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int figure = 1; figure <= (-1 * line + 9); figure++) {
            System.out.print("+.");
         }
         System.out.println("|"); 
      }  
   }
}