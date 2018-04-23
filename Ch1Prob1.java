/*Chapter 1: Problem 1.
Problem:
	Is Unique: Implement an algorithm to determine if a string has all unique characters. 
	What if you cannot use additional data structures? 
I:	So the problem here is to check if our given string is made up of all unique 
	characters. In other words, the string can not have two of the same characters in it.
D:	The goal is to tell if a string has any duplicate characters. If it does, then return
	false for it is not a string with unique characters, otherwise return true.
E:	1. If I was given the string "abc", I should return true, for this has all unique 
	   characters. If I was given the string "abca", i should return false. 
	2. First thing I do, is look at the first character in the string, and then compare it
	   to the next character if it exists. If they are the same then I would return false.
	   This would continue on to the next character, until the entire string has been
	   checked. Once the entire string is checked and has not yet returned false, i would
	   then return true.
	3. So some patterns that I have found in my process is two for loops to traverse the
	   String, and an if statement that does the actual comparison. If I have
	   found a duplicate, I would return false, otherwise do nothing. If I traverse the
	   String and have not found a duplicate character, I will return true.
	4. String: "abc"
	   i= "a" j= "b"; not the same, keep going.
	   i= "a" j= "c"; not the same, keep going.
	   i= "b" j= "c"; not the same, keep going.
	   End of traversal, return true.
	5. Refer to code at the bottom.
	6. After some interesting test cases, such as checking for empty strings, I have found
	   That my solution works. However, when I put the string s="Hh"; for example, I have
	   an output of true. While this is technically correct from a code perspective, it 
	   would need clarification as to whether or not this is the intended output. Otherwise,
	   my solution seems correct.
	7. If the test case s="Hh" is not correct, then to fix this problem I shall assume that
	   we are using ASCII numbers. With this in mind, I must make also check if the ASCII 
	   number for the character has a difference of 32. This way I can distinguish that "h"
	   and "H" are the same character and should return false. However I must make sure that
	   I only check for this for the alphabet characters.
A:	After looking at some of the outcomes that I could come across, my code should work for
	all cases with proper strings.
L:	Luckily I was able to figure this one out, but my code works in O(n^2) time. However I
	did learn that they're many cases that I must look out for and possibly fix if needed.
*/
public class Ch1Prob1{
	public static void main(String[] args){
		String s = "abb";
		System.out.println("The string "+s+" returned "+uniqueString(s));
		s="hello";
		System.out.println("The string "+s+" returned "+uniqueString(s));
		s="ab";
		System.out.println("The string "+s+" returned "+uniqueString(s));
		s="Hh";
		System.out.println("The string "+s+" returned "+uniqueString(s));
	}
	public static boolean uniqueString(String s){
		for(int i=0; i<s.length(); i++){
			for(int j=i+1; j<s.length(); j++){
				if(s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
}