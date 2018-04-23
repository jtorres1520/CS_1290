/*Chapter 2: Problem 2.
Problem:  Implement an algorithm to find the kth to last element of a singly linked list.
I:	I must make my code go to the kth to last index in my list.
D:	I am going to assume that I must only print the node at the kth to last 
	index is located. If this is the case, then I will use recursion for this problem.
E:	1. So given the list 1-2-3, and k=2, I should print 2.
	2. As I go through the list, I must get to null, which is at the end of the list. Once
	   there, I then must backtrack k times, and print the item at that index in my list.
	3. I will need an index integer to keep track of my index going backwards. I will need
	   a base case seeing if my index is equal to my k. If so, Print the data at that part
	   of my list. 
	4. List: 1-2-3; K = 2; I should get to the end of the list, and start counting
	   backwards. When I get to two, I am at the middle index and print. 
	5. Refer to code at the bottom.
	6. After multiple test cases, I was not sure if k=0 was a valid k position. My code
	   prints nothing, which is correct. However I am not sure if i am suppose to print
	   the last node instead.
	7. I was not able to solve how to change my code to print the last index if k
	   was zero.
A:	Done in part six.
L:	I was able to learn that it is useful to know how to recursively go through a
	linked list. 
*/
public class Ch2Prob2{
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		Node list = null;
		for(int i=0; i<nums.length; i++){
			list=insert(list, nums[i]);
		}
		print(list);
		printKData(list, 3);
		print(list);
	}
	public static int printKData(Node head, int k){
		if(head == null)
			return 0;
		int index = printKData(head.next, k)+1;
		if(index == k)
			System.out.println(k+"th to the last node is "+head.data);
		return index;
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