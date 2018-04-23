/*Chapter 2: Problem 1.
Problem: Write code to remove duplicates from an unsorted linked list.
I:	If any duplicates are found in the list, I must remove them. Essentially creating a
	set.
D:	I must traverse the list and then find if there are any duplicates. If I find any, I
	will then delete form the list.
E:	1. With the list 1->2->4->2->5, I need to change it to 1->2->4->5.
	2. First I traverse the list, remebering each value as I go through it. If I find
	   any duplicates, then I make the previous node equal to the next node of my
	   current node.
	3. So for this problem, I must traverse the list with a list, and then store each
	   value into a set. While traversing, if I find a duplicate, I "delete" it. 
	4. So with list: 1-2-2, I traverse the list, storing each value until I reach the last
	   node, which has a duplicate. So i make my previous node equal to the next node, in
	   this case, null. My output: 1-2.
	5. Refer to the code below.
	6. The code works as intended with multiple test cases.
	7. No debugging required. 
A:	Same as step six.
L:	I was able to learn much more about hash sets with this problem and was able to do
	the problem with it.
*/
import java.util.HashSet;
public class Ch2Prob1{
	public static void main(String[] args){
		int[] nums = {1,2,3,3,4,5};
		Node list = null;
		for(int i=0; i<nums.length; i++){
			list=insert(list, nums[i]);
		}
		print(list);
		deleteDuplicates(list);
		print(list);
	}
	public static void deleteDuplicates(Node n){
		HashSet<Integer> set = new HashSet<>();
		Node previous = null;
		while(n != null){
			if(set.contains(n.data)){
				previous.next = n.next;
			}else{
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
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
}