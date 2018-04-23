/*Chapter 1: Problem 5.
Problem: There are three types of edits that can be performed on strings: insert a 
		 character, remove a character, or replace a character. Given two strings, write 
		 a function to check if they are one edit (or zero edits) away.
I:	I have to tell between two strings, how different they are. And if they are more
	than one edit apart, return false.
D:	I have to define if a string is one replacement away from and edit, if the string
	needs one insertion edit, or if it needs one removal edit.
E:	1. With strings "hello" and "hell", I would say that it needs only one edit to be
	   the same string. 
	2. First I compared the two strings character by character, and then determined how
	   many edits were required, if any, to have the same word.
	3. I will need several if statements to check various things such as lengths, boolean
	   data, and comparisons. I will also need a for loop to traverse the strings and a 
	   while loop to check for inserts.
	4. String "pale", "ple", only requires an insert to have the same string.
	5. Refer to the code at the bottom.
	6. After some test cases, such as a empty string, my code works as intended.
	7. No debugging seems to be required. 
A:	Test cases tested with step six.
L:	In this problem, I learned that it was very useful to do things in separate
	methods.
*/
public class Ch1Prob5{
	public static void main(String[] args){
		String word1 = "";
		String word2 = "";
		System.out.println(oneEdit(word1, word2));
	}
	public static boolean oneEdit(String first, String second){
		if(first.length() == second.length()){
			return oneEditReplace(first, second);
		}else if(first.length()+1 == second.length()){
			return oneEditInsert(first, second);
		}else if(first.length()-1 == second.length()){
			return oneEditInsert(second, first);
		}
		return false;
	}
	public static boolean oneEditReplace(String s1, String s2){
		boolean difference = false;
		for(int i=0; i<s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(difference){
					return false;
				}
				difference = true;
			}
		}
		return true;
	}
	public static boolean oneEditInsert(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		while(index2 < s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
}