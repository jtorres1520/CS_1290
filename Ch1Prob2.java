/*Chapter 1: Problem 2.
Problem:
	Given two strings, write a method to decide if one is a permutation of the other.
I:	So to start, a permutation is when two strings have the same length and the same
	characters. For example: "act" and "cat" are permutations.
D:	If the strings are permutations of each other, then I will return true. Otherwise
	I will return false.
E:	1. If I was given the strings "taco" and "cato", I am to return true for these
	   two strings are permutations of each other. If given two strings such as "sit"
	   and "bit", I would have to return false for these are not permutations of each
	   other.
	2. For a computer to understand what I did, I first check if my two strings are of
	   the same length, if not then return false, for they are not permutations of
	   each other. Next I would then assume that we will be using ASCII numbers to 
	   represent the characters in the string. I will then make an integer array the 
	   size of the ASCII table, which is 128. I will then have a for loop that will
	   increase the index number inside my integer array at the index of the character
	   value in ASCII. Once I have done the first string, I will do the same for the 
	   second string but now instead decrease the value of the index location. At the 
	   very end, if all my values are '0', then the two strings are permutations. 
	3. So I am going to need an if statement to check if they are the same length,an 
	   integer array the size of the ASCII table(128), two for loops for the the two
	   strings, and another if statement to check if the index's are all equal to zero.
	4. String "act" and "cat":
	   After the first for loop, my array should have increased the values at indexes:
	   97, 99, and 116 are all indexes that now equal '1'.
	   After the second for loop, my array should have decreased the values at these 
	   same indexes and then check if the value stored is equal to zero:
	   index 99 is decreased, and the value inside is '0'
	   index 97 is decreased, and the value inside is '0'
	   index 116 is decreased, and the value inside is '0'
	   Since all values are zero, I now return true, for the strings are permutations.
	5. Refer to code down below.
	6. After multiple test cases, the code works. However I will need clarification when
	   it comes to capital letters. For if I had strings "cat" and "Cat", are they still
	   permutations of each other.
	7. There were no obvious test cases where debugging was needed. 
A:	So I know that if I should receive true if the two words were the same length and had
	the same letters. Otherwise I would receive false.
L:	I had learned the another use of the .charAt action for java, and its great use when
	using ASCII values.
*/
public class Ch1Prob2{
	public static void main(String[] args){
		String s1 = "act";
		String s2 = "cat";
		System.out.println(s1+" and "+s2+" return "+isPermutation(s1, s2));
	}
	public static boolean isPermutation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		int[] ascii = new int[128];
		for(int i=0; i<s1.length(); i++){
			ascii[s1.charAt(i)] += 1;
		}
		for(int i=0; i<s2.length(); i++){
			ascii[s2.charAt(i)] -= 1;
			if(ascii[s2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
}