// Jessica Hsieh
// 4/4/17
// CSE142
// TA: Alex Demeo
// Assignment #1
// 
// This program will print out a cumulative song.

public class Song {
   public static void main(String[] args) {
      verseOne();
      verseTwo();
      verseThree();
      verseFour();
      verseFive();
      verseSix();
      verseSeven();
   }
   
   public static void fly() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   public static void spider() {
      System.out.println("She swallowed the spider to catch the fly,");
      fly(); 
   }
   
   public static void bird() {
      System.out.println("She swallowed the bird to catch the spider,");
      spider();
   }

   public static void cat() {
      System.out.println("She swallowed the cat to catch the bird,");
      bird();
   }

   public static void dog() {
      System.out.println("She swallowed the dog to catch the cat,");
      cat();
   }   
   
   public static void monkey() {
      System.out.println("She swallowed the monkey to catch the dog,");
      dog();
   } 
   
   public static void verseOne() {
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
   }
   
   public static void verseTwo() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
   }
   
   public static void verseThree() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
   }
   
   public static void verseFour() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat();
   }
   
   public static void verseFive() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog();
   }
   
   public static void verseSix() {
      System.out.println("There was an old woman who swallowed a monkey,");
      System.out.println("How big is her mouth to swallow a monkey?");
      monkey();
   }
   
   public static void verseSeven() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }     
}