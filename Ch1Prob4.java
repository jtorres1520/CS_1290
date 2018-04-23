/*Chapter 1: Problem 4.
Problem:  Given a string, write a function to check if it is a permutation of a 
		  palindrome. A palindrome is a word or phrase that is the same forwards and 
		  backwards. A permutation is a rearrangement of letters. The palindrome does 
		  not need to be limited to just dictionary words.
I:	The problem that I must fix is to check if a given string is a permutation of a 
	palindrome. If given the string "taco cat", I know that I must return true.
D:	I must determine if the string is a palindrome, and then determine if its a 
	permutation. 
E:	1. With the string "racecar", I should return true.
	2. I looked at the string and saw that I could say the word the same forwards and
	   backwards.
	3. I will need a for loop of some kind to traverse the string, several if
	   statements, and a count system. My plan is to count up every time a character
	   has an odd ASCII value, and count down if even. If count is less than or equal to
	   '1', it is true.
	4. After using the phrase "tacocat", my count equals one, indicating true.
	5. Refer to code at the bottom.
	6. After some test cases, my code works as intended.
	7. No debugging required.
A:	Test cases already done in step six.
L:	With this problem, I was able to understand how the for each loop works a little 
	bit more.
*/
public class Ch1Prob4{
	public static void main(String[] args){
		String word = "racecar";
		System.out.println(isPermutationPalindrome(word));
	}
	public static boolean isPermutationPalindrome(String s){
		int countOdd = 0;
		int[] ascii = new int[128];
		for(char c : s.toCharArray()){
			int value = (int)(c);
			if(value != -1){
				ascii[value]++;
				if(ascii[value]%2 == 1){
					countOdd++;
				}else{
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
}