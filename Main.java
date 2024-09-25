// Main.java			
// Pig Latin Converter
// This is the student starting file for Lab02bPigLatin.

import java.util.Scanner;

public class Main
{
	public static void main (String[] args)
	{
      		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine();
        		 	
		String piggie = PigLatin.convertSentence(str);
		System.out.println();
		System.out.println("Converted word: " + piggie);
	}
}

///// This can be put all in one file or make a separate class in BlueJ
class PigLatin
{
	/*
	 * Precondition:  s is a String containing a single word.
	 * Postcondition: returns a word converted into Pig Latin according to the appropriate rule.
 	 * 
	 */
    // Check for vowel (returns true or false)
    public static boolean isVowel(String s) 
    {
        char first = s.toLowerCase().charAt(0);
        boolean vowel = first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u';
        return vowel;
    }
    // Rule 1 - For converting vowel starts
    public static String startsVowel(String s) {
        return s + "way";
    }
    // Rule 2 - For converting words that starts with one consonant
    public static String startsConsonant(String s) {
        return s.substring(1) + s.charAt(0) + "ay";
    }
    // Rule 3 - For converting words that starts with two consonant
    public static String startsTwoConsonant(String s) {
        return s.substring(2) + s.substring(0, 2) + "ay";
    }
    // Convert a word to pig latin using rules 1, 2, 3
	public static String convertWord(String s) {
        if (isVowel(s.substring(0, 1))) {
            // Apply Rule 1 if isVowel true
            return startsVowel(s);
        } else if (!isVowel(s.substring(1, 2))) {
            // Apply Rule 3 if isVowel is false on second char
            return startsTwoConsonant(s);
        } else {
            // Apply Rule 2 if isVowel is true on second char
            return startsConsonant(s);
        }
    }
    public static String convertSentence(String s) {
        // Make a list of the words
        String[] words = s.split(" ");
        // Go through each word in the list and apply convertWord
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(convertWord(word)).append(" ");
        }
        // Return result without the trailing space
        return result.toString().trim();
    }
}
