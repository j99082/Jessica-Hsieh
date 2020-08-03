/* Jessica Hsieh
 * CSE 143 Assignment 3
 * 
 * Class AssassinManager allows a client to manage a game of assassin,
 * and keeps track of who is stalking whom and the history of who killed whom..
*/

import java.util.*;

public class AssassinManager {
   private AssassinNode killRing;   // AssassinNode that keeps track of who is stalking whom
   private AssassinNode graveyard;  // AssassinNode that keeps the history of who killed whom
   
   // pre:  if the list is empty, throws an IllegalArgumentException.
   // post: adds the names from the list into the kill ring in the same order 
   //       in which they appear in the list 
   //       (assume nonempty strings, no duplicates, and case doesn't matter).
   public AssassinManager(List<String> names) {
      if (names.size() == 0) {
         throw new IllegalArgumentException();
      }
      for (int i = 0; i < names.size(); i++) {
         String name = names.get(i);
         if (killRing == null) {
            killRing = new AssassinNode(name);
         } else {
            AssassinNode current = killRing;
            while (current.next != null) {
               current = current.next;
            }
            current.next = new AssassinNode(name);
         }
      }
   }

   // post: prints the names of the people in the kill ring with the form 
   //       “<name> is stalking <name>”.
   public void printKillRing() {
      AssassinNode current = killRing;
      while (current != null) {
         if (current.next == null) {
            System.out.println("    " + current.name + " is stalking " + killRing.name);
         } else {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
         }
         current = current.next;
      } 
   }
   
   // post: prints the names of the people in the graveyard with the form 
   //       “<name> was killed by <name>”.
   public void printGraveyard() {
      AssassinNode current = graveyard;
      while (current != null) {
         System.out.println("    " + current.name + " was killed by " + current.killer);
         current = current.next;
      }
   }
   
   // pre:  takes in a String.
   // post: returns true if given name is in the kill ring, false otherwise (ignoring cases).
   public boolean killRingContains(String name) {
      return checkContains(killRing, name);
   }
   
   // pre:  takes in a String.
   // post: returns true if the given name is in the current graveyard false otherwise (ignoring cases).
   public boolean graveyardContains(String name) {
      return checkContains(graveyard, name);
   }
   
   // pre:  takes in an AssassinNode and a String.
   // post: returns true if the given list contains given name, false otherwise;
   private boolean checkContains(AssassinNode list, String name) {
      AssassinNode current = list;
      while (current != null) {
         if (current.name.equalsIgnoreCase(name)) {
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
   // post: returns true if kill ring has only one person (game is over), false otherwise.
   public boolean gameOver() {
      return killRing.next == null;
   }
   
   // post: returns the name of the winner of the game. If game is not over, return null.
   public String winner() {
      if (!gameOver()) {
         return null;
      } else {
         return killRing.name;
      }
   }
   
   // pre:  takes in a String. If given name is not in current kill ring, 
   //       throws an IllegalArgumentException. If the game is over, throws an 
   //       IllegalStateException (doesn’t matter which it throws if both are true).
   // post: records the killing of the person with the given name, 
   //       transferring the person from the kill ring to the graveyard(ignoring cases). 
   public void kill(String name) {
      if (gameOver()) {
         throw new IllegalStateException();
      } else if (!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      String killer = "";
      String killName = "";
      AssassinNode current = killRing;
      if (killRing.name.equalsIgnoreCase(name)) {
         killName = killRing.name;
         killRing = killRing.next;
         while (current.next != null) {
            current = current.next;
         }
         killer = current.name;
      } else {
         while (!current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
         }
         killer = current.name;
         killName = current.next.name;
         current.next = current.next.next;
      }
      graveyard = new AssassinNode(killName, graveyard);
      graveyard.killer = killer;
   }
}