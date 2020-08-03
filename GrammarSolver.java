/* Jessica Hsieh
 * CSE 143 Assignment 4
 * 
 * Class GrammarSolver can be used to manipulate and generate random elements of the grammar.
*/

import java.util.*;

public class GrammarSolver {
   private SortedMap<String, String[]> grammarMap;   // SortedMap that stores the nonterminal and its rules
   
   // pre:  takes in a list of Strings, 
   //       and throws IllegalArgumentException if the given grammar is empty,
   //       or there are 2 or more entries in the given grammar for the same nonterminal.
   // post: constructs a GrammarSolver object with nonterminals and its rules in it.
   public GrammarSolver(List<String> grammar) {
      if (grammar.isEmpty()) {
         throw new IllegalArgumentException();
      }
      grammarMap = new TreeMap<>();
      for (String str : grammar) {
         String[] sentence = str.split("::=");
         String symbol = sentence[0];
         String[] rules = sentence[1].split("[|]");
         if (!grammarMap.containsKey(symbol)) {
            grammarMap.put(symbol, rules);
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   // pre:  takes in a String symbol (case sensitive).
   // post: returns true if the given symbol is a nonterminal grammar, false otherwise.
   public boolean grammarContains(String symbol) {
      return grammarMap.containsKey(symbol);
   }
   
   // pre:  takes in a String symbol (case sensitive) and int times. If given times is less than 0 
   //       or grammar does not contain given nonterminal symbol, then throws an IllegalArgumentException.
   // post: uses grammar to randomly generate the given number of occurrences of the given symbol.
   //       Returns this result as an array of Strings.
   public String[] generate(String symbol, int times) {
      if (times < 0 || !grammarContains(symbol)) {
         throw new IllegalArgumentException();
      }
      String[] result = new String[times];
      for (int i = 0; i < times; i++) {
         result[i] = generate(symbol);
      }
      return result;   
   }
   
   // pre:  takes in a String symbol (case sensitive).
   // post: generates random elements of grammar with given symbol and returns the result as a String
   //       (private pair for the public generate method).
   private String generate(String symbol) {
      if (!grammarContains(symbol)) {
         return symbol;
      } else {
         String result = "";
         String[] rules = grammarMap.get(symbol);
         int random = (int) (Math.random() * rules.length);
         String[] word = rules[random].trim().split("[ \t]+");
         for (String str : word) {
            result += generate(str) + " ";
         }
         return result.trim();
      }    
   }

   // post: returns a String of various nonterminal symbols from the grammar as sorted,
   //       comma-separted list enclosed in square brackets.
   public String getSymbols() {
      return grammarMap.keySet().toString();
   }
}