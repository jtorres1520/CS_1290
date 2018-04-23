/*Chapter 1: Problem 3.
Problem: Write a method to replace all spaces in a string with '%20: 
		 You may assume that the string has sufficient space at the 
		 end to hold the additional characters, and that you are 
		 given the "true" length of the string. (Note: if 
		 implementing in Java, please use a character array so that 
		 you can perform this operation in place.)
I:	So the problem that I have been tasked to complete is to replace
	all spaces in a string with '%20', not including empty space after
	the string if any.
D:	I must count the number of spaces in the string, and then add that
	to the string length. I must then add '%20' to every space within
	the string while keeping everything else about the string intact.
E:	1. If my string is: "Hello World", my output must be "Hello%20World"
	2. Every time that I find an empty space, I must count it so long as
	   it is not after the string. Then I must rebuild the string, adding
	   the characters that i need.
	3. I am going to need a for loop to traverse the string and count the
	   spaces. Another for loop to rebuild the string. 
	4. String "Hello World"
	   One space in the string, so output should be "Hello%20World".
	5. Refer to the code at the bottom.
	6. After multiple test cases, the code works fine.
	7. No debugging required.
A:	After multiple test cases, the code works fine. 
L:	I learned that you it may be better to manipulate a string if you
	first change it into a character array.
*/
public class Ch1Prob3{
	public static void main(String[] args){
		String str = "Mr John Smith     ";
		char[] s = str.toCharArray();
		fillSpaces(s,13);
	}
	public static void fillSpaces(char[] s, int size){
		int count = 0;
		int index;
		int i = 0;
		for(i=0; i<size; i++){
			if(s[i] == ' '){
				count++;
			}
		}
		index = size + count*2;
		if(size<s.length)
			s[size] = '\0';
		for(i=size-1; i>=0; i--){
			if(s[i]== ' '){
				s[index-1] = '0';
				s[index-2] = '2';
				s[index-3] = '%';
				index=index-3;
			}else{
				s[index-1]=s[i];
				index--;
			}
		}
		for(i= 0; i<s.length; i++){
			System.out.print(s[i]);
		}
	}
}