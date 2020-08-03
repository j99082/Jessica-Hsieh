/* Jessica Hsieh
 * CSE 143 Assignment 5
 * 
 * Class AnagramSolver allows clients to find all combinations of words that are 
 * anagrams of the given phrase, and print out given max number of result.
*/

import java.util.*;

public class AnagramSolver {
   private Map<String, LetterInventory> map;  // Map (key: String, value: LetterInventory) that stores how many of each letter a String in the dictionary has
   private List<String> dictionary;           // List of Strings that stores a copy of the dictioanry
   
   // pre:  takes in list of Strings that consists of nonempty collection of nonempty sequences 
   //       of letters, and there are no duplicates.
   // post: constructs an AnagramSolver that uses given list as its dictionary.
   public AnagramSolver(List<String> list) {
      map = new HashMap<String, LetterInventory>();
      dictionary = list;
      for (String s : dictionary) {
         LetterInventory letters = new LetterInventory(s);
         map.put(s, letters);
      }
   }
   
   // pre:  takes in a String and an int. If given max is less than 0,
   //       throws an IllegalArgumentException.
   // post: prints out all combinations of words from the dictionary that are anagrams of 
   //       given s and that include at most max words (unlimited number of words if max is 0).
   public void print(String s, int max) {
      if (max < 0) {
         throw new IllegalArgumentException();
      }
      LetterInventory letters = new LetterInventory(s);
      List<String> prunedDictionary = pruned(letters);
      print(letters, max, new ArrayList<String>(), prunedDictionary);
   }
   
   // pre:  takes in a LetterInventory, an int, and two lists of Strings.
   // post: explores each word in the given pruned dictionary and prints out the words that their
   //       LetterInventories can be subtracted from the given LetterInventory letters
   //       (combinations include at most max words).
   private void print(LetterInventory letters, int max, List<String> list, List<String> prunedDictionary) {
      if (letters.isEmpty()) {
         System.out.println(list);
      } else if (max > list.size() || max == 0) {
         for (String s : prunedDictionary) {
            LetterInventory letters2 = letters.subtract(map.get(s));
            if (letters2 != null) {
               list.add(s);
               print(letters2, max, list, prunedDictionary);
               list.remove(list.size() - 1); 
            }
         }
      }
   }
   
   // pre:  takes in a LetterInventory.
   // post: reduces the dictionary to a smaller dictionary of words that their LetterInventories
   //       can be subtracted from the given LetterInventory letters, 
   //       and returns the result as a list of Strings.
   private List<String> pruned(LetterInventory letters) {
      List<String> result = new ArrayList<>();
      for (String s : dictionary) {
         if (letters.subtract(map.get(s)) != null) {
            result.add(s);
         }
      }
      return result;
   }
}