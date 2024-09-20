
/**
        * Rayan Hayle (Rah2236)
        * Programming Assignment 2 - Recursion exercises
        * COMS W3134
        *
        * Note: All methods must be written recursively. No credit will be given for
        * methods written without recursion, even if they produce the correct output.
        */

public class Recursion {
    /**
     * Returns the value of x * y, computed via recursive addition.
     * x is added y times. Both x and y are non-negative.
     * @param x  non-negative integer multiplicand 1
     * @param y  non-negative integer multiplicand 2
     * @return   x * y
     */
    public static int recursiveMultiplication(int x, int y) {
        // TODO 1 CHECKED
        // recursions can't have while/if loops.
        // Recursion is when a method calls itself.
        // using substrings
        // to stop a recursion from a forever loop have a condition and parameters
        // parameters here are int x and int y
        // so 9*3 will be be 9+9+9
        //x is added to itself

        if (y == 0){ // if are base case
            return 0 ;
        } //x isn't changing y is going to zero subtract to get to zero at the end
        // x+ for pop the stack.
        // formula: x+ (x, y-1)
        // input 2,3
        // use popping method until we reach the base case and
        // when y-1 final becomes zero it will go to the if loop

        return x+  recursiveMultiplication (x,y -1);
  }

/******************************************************************************/
    /**
     * Reverses a string via recursion.
     * @param s  the non-null string to reverse
     * @return   a new string with the characters in reverse order
     */
    public static String reverse(String s) {
        // TODO 2 CHECKED
        // use substring method
        //null is a special constant  to point to the absence of a value.

        if (s == null || s.length() <= 1 ){
            return s;
        }
        // subtract last index move it to the front
        // call reverse again and build on it
        // to know the last index: length-1
        //cat length = 3 -1 ----> 2 which is t so keep subtracting
        // have a foundation called first for return before recursion
        // zero is the start of the new string to reverse the string

        return s.substring(s.length()-1) + reverse (s.substring(0,s.length()-1));
/*
Instructor
| 09/25 at 11:02 pm
Grading comment:
you can use s.charAt(s.length() - 1) instead of s.substring(s.length() - 1)
*/
    }
    /******************************************************************************/

    /**
     * Returns the maximum value in the array.
     * Uses a helper method to do the recursion.
     * @param array  the array of integers to traverse
     * @return       the maximum value in the array
     */
    private static int maxHelper(int[] array, int index, int max) { //Linear Search
        // TODO 3 HELPER! CHECKED

    // recursion DOES NOT use while and for loops!
    // call the method by itself to make a recursive method

        // now if the base case is not zero: call the function to find..
        // the  one size less from the end: x-1, comparing to the last element

        if (index >= array.length) { //base case:when you reach the end, and the index is greater than the length
           return max;
        }
        //comparsions if num is greater or equal to max set it as the new max

        if (array[index] >= max){
            max = array[index] ;
        }

        return maxHelper (array, index + 1,max );

    }

    public static int max(int[] array) {
        return maxHelper(array, 0, Integer.MIN_VALUE);

    }
/******************************************************************************/
    /**
     * Returns whether or not a string is a palindrome, a string that is
     * the same both forward and backward.
     * @param s  the string to process
     * @return   a boolean indicating if the string is a palindrome
     */

    public static boolean isPalindrome(String s) {
        // TODO 4   2 WRONGS! OH
        // use substring method
        //null is a special constant  to point to the absence of a value.

        if (s.length()<= 1){ // like if they give only one letter
            return true;
        }
        // compare last to first int

        //String FirstINT = s.substring(0,1) ;
        //move inward index:

        int FirstINT = 0; // repsent index

        int LastINT = (s.length()- 1);

       // if (LastINT != FirstINT]) {
            //return false;
       // }
        if (s.charAt(LastINT) != s.charAt(FirstINT)){
            return false;
        }


            return isPalindrome(s.substring(FirstINT += 1, LastINT)) ;
/*Instructor
| 09/25 at 11:04 pm
Grading comment:
perhaps you meant += 1? https://stackoverflow.com/questions/6958401/the-difference-between-and
*/


    }
/******************************************************************************/

    /**
     * Returns whether or not the integer key is in the array of integers.
     * Uses a helper method to do the recursion.
     * @param key    the value to seek
     * @param array  the array to traverse
     * @return       a boolean indicating if the key is found in the array
     */

    private static boolean memberHelper(int key, int[] array, int index) {
        // TODO 5 HELPER! CHECKED
        //CHECK IF MY KEY IS IN THE LIST

        if (array [index] == key){
            return true;
        }
       // comparison:end of the array: what happens end of array

        if ( array.length -1 == index ){
            return false; // when you did not find the key at the end
        }

       return memberHelper(key,array,index +1);

    }

    public static boolean isMember(int key, int[] array) {
        return memberHelper(key, array, 0);

    }
/******************************************************************************/

    /**
     * Returns a new string where identical chars that are adjacent
     * in the original string are separated from each other by a tilde '~'.
     * @param s  the string to process
     * @return   a new string where identical adjacent characters are separated
     *           by a tilde
     */
    public static String separateIdentical(String s) {
        // TODO 6
        //

        if (s == null || s.length() <= 1 ){ // a and b solved
            return s;
        }
        // substring everything after the (num)

        if (s.charAt(0) != s.charAt(1)){
            // substring returns the whole thing
            // if a != b, return char at 0
            // then get the remaing string
            // call the method to get the string again

            return s.charAt(0) + separateIdentical(s.substring(1 ));

        }
        //return the  first char then add ~ in the middle
        //recall the method and get the remain string starting at 1

        return s.charAt(0)  + "~" + separateIdentical(s.substring(1));

    }


}

