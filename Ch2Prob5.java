/*Chapter 2: Problem 5.
Problem: You have two numbers represented by a linked list, where each node contains a 
		 single digit. The digits are stored in reverse order, such that the 1 's digit 
		 is at the head of the list. Write a function that adds the two numbers and 
		 returns the sum as a linked list.
I:	I am given two lists, and each node in that list represents a digit in a number
	going backwards. I am to add these two list together and get a result.
D:	I must add the digits separately, and transfer any carry numbers over to the next
	digit.
E:	1. Lists: 0-0-2, and 9-4-1, I should have the number 349, because 200 plus 149 equals
	   349.
	2. I look at the first node, which would be the first digit in the number. I add them
	   and if i go over nine, i have a carry that transfers over to the next node/digit.
	   I continue this process until I have reached the length of the smaller list.
	3. I will use recursion for this problem, and start adding from the beginning. I will
	   have several if statements checking if any of the lists are null. If not, I go to
	   the next node.
	4. list: 0-0-2 and 9-4-1, the first digit is nine, no carry over. The second digit
	   is four and zero, so it would be four, no carry over. And finally the last digit is
	   one and two, so three. The final answer is 349.
	5. Refer to code at the bottom.
	6. The code works as intended and prints the right result.
	7. No debugging required.
A:	Part of step six.
L:	With this problem, I had to learn how to implement the ? and colon system in java.
*/
public class Ch2Prob5{
	public static void main(String[] args){
		int[] nums = {0,0,2};
		int[] nums2 = {9,4,1};
		Node list = null;
		Node list2 = null;
		for(int i=0; i<nums.length; i++){
			list=insert(list, nums[i]);
			list2 = insert(list2, nums2[i]);
		}
		print(list);
		print(list2);
		Node result = addLists(list, list2, 0);
		printBackwards(result);
	}
	public static Node addLists(Node l1, Node l2, int carry){
		if(l1 == null && l2 == null && carry == 0){
			return null;
		}
		Node result = new Node(0);
		int value = carry;
		if(l1 != null){
			value += l1.data;
		}
		if(l2 != null){
			value += l2.data;
		}
		result.data = value % 10;
		if(l1 != null || l2 != null){
			Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
	public static Node insert(Node head, int data) {
        Node p = new Node(data);

        if(head == null)
            head = p;
        else if(head.next == null)
            head.next = p;
        else {
            Node start = head;

            while(start.next != null)
                start = start.next;

            start.next = p;
        }

        return head;
    }
	public static void print(Node head) {
        Node start = head;

        while(start != null) {
            System.out.print(start.data+" ");
            start = start.next;
        }
		System.out.println();
    }
	public static void  printBackwards(Node head){
		if(head == null){
			return;
		}
		printBackwards(head.next);
		System.out.print(head.data);
	}
}