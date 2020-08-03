// Jessica Hsieh
// 5/16/17
// CSE142
// TA: Alex Demeo
// Assignment #6
//
// This program displays the children's names, their meanings, and popularities

import java.util.*;
import java.io.*;
import java.awt.*;

public class names {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      String name = findNames(console);
      String gender = findGender(console);
      
      Scanner input = new Scanner(new File("names.txt"));
      String data = search(input, name, gender);
      
      Scanner input2 = new Scanner(new File("meanings.txt"));
      String meaning = search(input2, name, gender);
      print(data, meaning);
   
   }
   
   public static String findNames(Scanner console) {
      System.out.print("Name: ");
      String name = console.next().toLowerCase();
      return name;
   }
   
   public static String findGender(Scanner console) {
      System.out.print("Gender (M or F): ");
      String gender = console.next().toLowerCase();
      return gender;
   }
   
   public static String search(Scanner input, String name, String gender) {
      while (input.hasNextLine()) {
         String first = input.next();
         String rest = input.nextLine();
         String data = first + rest;
         if (first.toLowerCase().equals(name) && 
            rest.toLowerCase().contains(gender)) {
            return data;
         }

      }

      String ans = name.substring(0, 1).toUpperCase() + name.substring(1);
      return "\"" + ans + "\"" + " not found.";
   
   }
   
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
   

   

   
}