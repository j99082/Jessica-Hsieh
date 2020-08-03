/* Jessica Hsieh
 * CSE 143 Assignment 7
 * 
 * Class HuffmanNode implements Comparable interface and constructs nodes to build HuffmanTree.
 * HuffmanNode stores the integer value of the character and frequency of that character.
*/
 
public class HuffmanNode implements Comparable<HuffmanNode> {
   public int data;
   public int frequency;
   public HuffmanNode left;
   public HuffmanNode right;
   
   // pre:  takes in int data, int frequency, HuffmanNode left, and HuffmanNode right.
   // post: constructs new HuffmanNode with given data, given frequency, and 
   //       given left, right HuffmanNodes.
   public HuffmanNode(int data, int frequency, HuffmanNode left, HuffmanNode right) {
      this.data = data;
      this.frequency = frequency;
      this.left = left;
      this.right = right;
   }
   
   // post: constructs a new HuffmanNode with no parameters (default).
   public HuffmanNode() {
      this(-1, 0, null, null);
   }
   
   // pre:  takes in an int;
   // post: constructs a new HuffmanNode with given data.
   public HuffmanNode(int data) {
      this(data, 0, null, null);
   }
   
   // post: uses frequency of the HuffmanNode to determine its ordering relative to other HuffmanNode.
   //       Lower frequencies is considered less than higher frequencies. 
   public int compareTo(HuffmanNode other) {
      return this.frequency - other.frequency;
   }
}