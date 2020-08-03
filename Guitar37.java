/* Jessica Hsieh
 * CSE 143 Assignment 2
 * 
 * Class Guitar 37 implements Guitar class and models a guitar with 37 different strings. 
*/

public class Guitar37 implements Guitar {
   private GuitarString[] strings;  // Array of GuitarString objects that keeps track of 37 strings
   private int time;                // Int that stores number of times tic has been called
   public static final int LENGTH = 37;    
   public static final String KEYBOARD =
      "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   
   // post: constructs an array of GuitarString objects with given LENGTH,
   //       and initializes the number of times tic has been called.
   public Guitar37() {
      time = 0;  
      strings = new GuitarString[LENGTH];
      for (int i = 0; i < LENGTH; i++) {
         double frequency = 440 * Math.pow(2, (i - 24)/12.0);
         strings[i] = new GuitarString(frequency);
      }
   }

   // pre:  takes in an int.
   // post: plays a specific note on the guitar with given pitch.   
   //       If the value of the given pitch can’t be played by the guitar, it is ignored.
   public void playNote(int pitch) {
      if (pitch >= -24 && pitch <= 12) {
         int index = pitch + 24;
         strings[index].pluck();
      }
   }
   
   // pre:  takes in a char.
   // post: returns true if verify that a particular character has a corresponding string 
   //       for this guitar, false otherwise.
   public boolean hasString(char key) {
      return KEYBOARD.indexOf(key) != -1;
   }
   
   // pre:  given char must pass the hasString method. If not, throws an IllegalArgumentException.
   // post: plays a specific note with the given char.
   public void pluck(char key) {
      if (!hasString(key)) {
         throw new IllegalArgumentException();
      }
      int index = KEYBOARD.indexOf(key);
      strings[index].pluck();
   }
   
   // post: returns the sum of all current sample sizes from the strings of the guitar.
   public double sample() {
      double sample = 0.0;
      for (int i = 0; i < LENGTH; i++) {
         sample += strings[i].sample();
      }
      return sample;
   }
   
   // post: applies Karplus-Strong algorithm to ring buffers of all the guitar strings, 
   //       and updates the number of times tic has been called.
   public void tic() {
      for (int i = 0; i < LENGTH; i++) {
         strings[i].tic();
      }
      time++;
   }
   
   // post: returns the number of times tic has been called. 
   public int time() {
      return time;
   }
}