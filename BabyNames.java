// Jessica Hsieh
// 5/16/17
// CSE142
// TA: Alex Demeo
// Assignment #6
//
// This program allows the user to search for baby's names and 
// displays the name's meaning and popularity.

import java.util.*;
import java.io.*;
import java.awt.*;

public class BabyNames {
   public static final int YEAR = 1890;
   public static final int WIDTH = 60;
   public static final int HEIGHT = 30;

   public static void main(String[] args) throws FileNotFoundException {
      introduction();
      Scanner console = new Scanner(System.in);
      String name = findNames(console);
      String gender = findGender(console);
      Scanner input = new Scanner(new File("names.txt"));
      String data = search(input, name, gender);
      Scanner input2 = new Scanner(new File("meanings.txt"));
      String meaning = search(input2, name, gender);
      print(data, meaning);
      if (!data.contains("not found")) {
         Graphics g = createWindow();
         drawBars(g, data, meaning);
      }
   }
   
   // Gives introduction to the user.
   public static void introduction() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + YEAR + ".");
      System.out.println();
   }
   
   // Allows the user to type the name.
   // Takes a Scanner that allows the user to type baby's name as parameter.
   // Returns the name.
   public static String findNames(Scanner console) {
      System.out.print("Name: ");
      String name = console.next();
      return name;
   }
   
   // Allows the user to type the gender.
   // Takes a Scanner that allows the user to type baby's gender as parameter.
   // Returns the gender.
   public static String findGender(Scanner console) {
      System.out.print("Gender (M or F): ");
      String gender = console.next().toLowerCase();
      return gender;
   }
   
   // Search the name user typed from the Social Security Administration.
   // Takes a Scanner that scan the file and two strings as paramters.
   // Returns data when name is found from the file.
   // Returns not found when name is not found from the file.
   public static String search(Scanner input, String name, String gender) {
      while (input.hasNextLine()) {
         String first = input.next();
         String rest = input.nextLine();
         String data = first + rest;
         if (first.toLowerCase().equals(name.toLowerCase()) && 
            rest.toLowerCase().contains(gender)) {
            return data;
         }
      }
      return "\"" + name + "\"" + " not found.";
   }
   
   // Prints the data out to the user.
   // Takes two strings as paramters.
   public static void print(String data, String meaning) {
      Scanner lineScan = new Scanner(data);
      String name = lineScan.next();
      String genderNumber = "";
      Scanner lineScan2 = new Scanner(meaning);
      String name2 = lineScan2.next();
      String genderMeaning = "";
      while (lineScan.hasNextLine() && lineScan2.hasNextLine()) {
         genderNumber += lineScan.nextLine();
         genderMeaning += lineScan2.nextLine();
      }
      System.out.println(name + genderNumber);
      if (!genderNumber.contains("not found")) {
         System.out.println(name2 + genderMeaning);
      }
   }
   
   // Creates a drawing panel window.
   // Returns Graphics g.
   public static Graphics createWindow() {
      DrawingPanel panel = new DrawingPanel(780, 500 + 2 * HEIGHT);
      panel.setBackground(Color.WHITE);
      Graphics g = panel.getGraphics(); 
      drawSquares(g);
      return g;
   }
   
   // Draws two rectangles along the window's top and bottom.
   // Takes in graphics g that draws graph as a parameter.
   public static void drawSquares(Graphics g) {
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 0, 780, HEIGHT);
      g.fillRect(0, 500 + HEIGHT, 780, HEIGHT);
      g.setColor(Color.BLACK);
      g.drawLine(0, 500 + HEIGHT, 780, 500 + HEIGHT);
      g.drawLine(0, HEIGHT, 780, HEIGHT);
   }
   
   // Draws the bars and decades.
   // Takes a Graphic g and two strings as parameters.
   public static void drawBars(Graphics g, String data, String meaning) {
      g.drawString(meaning, 0, 16);
      Scanner lineScan = new Scanner(data);
      String s = lineScan.next() + lineScan.next();
      int y = 0;
      int i = 0;
      int count = 0;
      while (lineScan.hasNextInt()) {
         g.setColor(Color.BLACK);
         String year = "" + (10 * i + YEAR);
         g.drawString(year, WIDTH * i, 492 + 2 * HEIGHT);
         int rank = lineScan.nextInt();
            if (rank == 0) {
               y = 500 + HEIGHT;
            } else {
               y = rank / 2 + HEIGHT;
            }
         g.drawString("" + rank, WIDTH * i, y);
         g.setColor(Color.GREEN);
         g.fillRect(WIDTH * i, y, WIDTH / 2, 500 + HEIGHT - y);
         count++;
         i++;
      }
   }
}