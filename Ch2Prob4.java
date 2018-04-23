/*Chapter 2: Problem 4.
Problem:  Write code to partition a linked list around a value x, such that all nodes 
		  less than x come before all nodes greater than or equal to x. If x is contained
		  within the list, the values of x only need to be after the elements less than 
		  x. The partition element x can appear anywhere in the "right partition"; it 
		  does not need to appear between the left and right partitions.
I:	I am to split and change my list based on a value that is within my list. I will give
	a value, look for it in my list, and then partition based on that value.
D:	I must find my number, and then partition based off of that number.
E:	1. So with list 3-5-8-5-10-2-1; and my partition equal to 5, I should get an list of
	   1-2-3-5-8-5-10.
	2. The first thing that I must do is traverse the list, and as I am traversing it,
	   move the nodes to their appropriate spots. 
	3. I will need a while loop to traverse the list, and if statement to determine what
	   the data is compared to the partition number.
	4. 
	5. Refer to code below.
	6. The code seems to work as intended, it puts all the nodes in order.
	7. No debugging required.
A:	Part of step six.
L:	In this problem, I learned that there are many different solutions that can be
	used to solve the problem itself.
*/
public class Ch2Prob4{
	public static void main(String[] args){
		int[] nums = {3,5,8,5,10,2,1};
		Node list = null;
		for(int i=0; i<nums.length; i++){
			list=insert(list, nums[i]);
		}
		print(list);
		list = partition(list, 5);
		print(list);
	}
	public static Node partition(Node n, int x){
		Node head = n;
		Node tail = n;
		while(n != null){
			Node next = n.next;
			if(n.data < x){
				n.next = head;
				head = n;
			}else{
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		return head;
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