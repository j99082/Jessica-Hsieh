/* Jessica Hsieh
 * CSE 143 Assignment 1
 * 
 * Class LetterInventory can be used to keep track of an inventory 
 * of letters of the alphabet.
*/

import java.util.*;

public class LetterInventory {
   private int[] elementData; // Array that stores int count for each alphabet
   private int size;          // Int that stores the sum for all of the counts in this inventory
   public static final int DEFAULT_CAPACITY = 26;

   // pre:  takes in a String.
   // post: initializes an ArrayIntList with given DEFAULT_CAPACITY and 
   //       counts in this inventory, and updates each alphabet count in the list
   //       (ignore cases).
   public LetterInventory(String data) {
      elementData = new int[DEFAULT_CAPACITY];
      size = 0;
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         char letter = data.charAt(i);
         if (letter >= 'a' && letter <= 'z') {
            elementData[letter - 'a']++;
            size++;
         }
      }
   }
   
   // post: returns the current size for this list.
   public int size() {
      return size;
   }
   
   // post: returns true if this inventory is empty (total count is 0), otherwise false.  
   public boolean isEmpty() {
      return (size == 0);
   }

   // pre:  given char letter must be alphabetic (ignore cases) 
   //       and throws an IllegalArgumentException if not met.
   // post: returns a value of given letter in the list.
   public int get(char letter) {
      letter = checkLetter(letter);
      return elementData[letter - 'a'];   
   }
   
   // pre:  given letter must be alphabetic (ignore cases).
   //       If not, throws an IllegalArgumentException.
   // post: returns given alphabetic character with lowercase.
   private char checkLetter(char letter) {
      letter = Character.toLowerCase(letter);
      if (letter < 'a' || letter > 'z') {
         throw new IllegalArgumentException();
      }
      return letter;
   }

   // post: returns a bracketed String of all the alphabets in this list.
   //       If inventory is empty, returns [].
   public String toString() {
      String output = "[";
      if (!isEmpty()) {
         for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            for (int j = 0; j < elementData[i]; j++) {
               output += (char) ('a' + i);
            }
         }  
      }
      output += "]";
      return output;
   }
   
   // pre:  given letter (ignore cases) must be alphabetic
   //       and given value must be nonnegative
   //       (throws an IllegalArgumentException if either requirement fails).
   // post: sets the count for the given letter to the given value.
   public void set(char letter, int value) {
      if (value < 0) {
         throw new IllegalArgumentException();
      }
      letter = checkLetter(letter);
      size = size - elementData[letter - 'a'] + value;
      elementData[letter - 'a'] = value;
   }
   
   // pre:  takes in another LetterInventory class.
   // post: constructs and returns a new LetterInventory object 
   //       that sums up this LetterInventory and given LetterInventory,
   //       and adds the counts for each letter together.
   public LetterInventory add(LetterInventory other) {
      LetterInventory addLetter = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         addLetter.elementData[i] = this.elementData[i] + other.elementData[i];
      }
      addLetter.size = this.size + other.size;
      return addLetter;
   }
   
   // pre:  takes in another LetterInventory class.
   // post: constructs and returns a new LetterInventory object 
   //       that subtract given LetterInventory from this LetterInventory
   //       (including the counts). Returns null if result count is negative.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory subtractLetter = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         subtractLetter.elementData[i] = this.elementData[i] - other.elementData[i];
         if (subtractLetter.elementData[i] < 0) {
            return null;
         }
      }
      subtractLetter.size = this.size - other.size;
      return subtractLetter;
   }
   
   


   
   
   
   
   
}