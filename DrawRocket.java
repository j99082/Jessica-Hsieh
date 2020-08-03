// Jessica Hsieh
// 4/11/17
// CSE142
// TA: Alex Demeo
// Assignment #2 Part B
// 
// This program will draw a rocket of different sizes.

public class DrawRocket {
   public static final int SIZE = 3;
   public static void main(String[] args) {
      triangle();
      straightLine();
      topHalf();
      bottomHalf();
      straightLine();
      bottomHalf();
      topHalf();
      straightLine();
      triangle();
   }
   
   // Prints the top and the bottom figures, which looks like a triangle.
   public static void triangle() {
      for (int line = 1; line <= (2 * SIZE - 1); line++) {
         for (int space = 1; space <= line * -1 + (2 * SIZE); space++) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= line; slash++) { 
            System.out.print("/");
         }
         System.out.print("**");
         for (int backSlash = 1; backSlash <= line; backSlash++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   // Prints out a straight line.
   public static void straightLine() {
      System.out.print("+");
      for (int i = 1; i <= (SIZE * 2); i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   // Prints out the first half of the body of the rocket.
   public static void topHalf() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         for (int figure = 1; figure <= line; figure++) {
            System.out.print("/\\");
         }
         for (int dot = 1; dot <= (-2 * line + (2 * SIZE)); dot++) {
            System.out.print(".");
         }
         for (int figure = 1; figure <= line; figure++) {
            System.out.print("/\\");
         }
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   // Prints out another half of the body of the rocket.
   public static void bottomHalf() {
      for (int line = SIZE; line >= 1; line--) {
         System.out.print("|");
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         for (int figure = 1; figure <= line; figure++) {
            System.out.print("\\/");
         }
         for (int dot = 1; dot <= (-2 * line + (2 * SIZE)); dot++) {
            System.out.print(".");
         }
         for (int figure = 1; figure <= line; figure++) {
            System.out.print("\\/");
         }
         for (int dot = 1; dot <= (-1 * line + SIZE); dot++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
}
