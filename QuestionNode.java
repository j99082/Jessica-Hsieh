/* Jessica Hsieh
 * CSE 143 Assignment 6
 * 
 * Class QuestionNode creates node for binary tree, and can used to construct the tree. 
 * The node's data stores the text of either question or answer.
*/

public class QuestionNode {
   public QuestionNode left;
   public QuestionNode right;
   public String data;

   // pre:  takes in a String, left QuestionNode and right QuestionNode.
   // post: constructs a new QuestionNode.
   public QuestionNode(String data, QuestionNode left, QuestionNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }

   // pre:  takes in a String.
   // post: constructs a new binary tree.
   public QuestionNode(String text) {
      this(text, null, null);
   }
}