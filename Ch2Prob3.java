/*Chapter 2: Problem 3.
Problem:  Implement an algorithm to delete a node in the middle (Le., any node but the 
		  first and last node, not necessarily the exact middle) of a singly linked list,
		  given only access to that node.
I:	In this problem, I am to delete a node that is in between the first node and the last
	node.
D:	I will have access to a middle node in the list, and I then must delete it. I must
	make sure that it is in the middle and is not the beginning node, or the last node.
E:	1. With list 1-2-3, I must return 1-3.
	2. First I check to make sure it is a node in the middle. If so, I then delete it.
	3. Since I am only going to use the node that I am at, I will only need an if statement
	   to check if the node I am at is null, or if the next node is null. If not, then i shall
	   delete the next node in the list.
	4. 1-2-3; I check if 2 is null, is not. So i delete it and have 1-3;
	5. Refer to code at the bottom.
	6. The code works as intended with the correct inputs. 
	7. No debugging required.
A:	Done in part six.
L:	With this problem, I learned how to look at certain conditions to tell if I should do the
	action, or not. 
*/
public class Ch2Prob3{
	public static void main(String[] args){
		int[] nums = {1,2,3};
		Node list = null;
		for(int i=0; i<nums.length; i++){
			list=insert(list, nums[i]);
		}
		print(list);
		deleteNode(list.next);
		print(list);
	}
	public static boolean deleteNode(Node n){
		if(n == null || n.next == null){
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
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