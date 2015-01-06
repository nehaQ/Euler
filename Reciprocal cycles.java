// Basically save remainders into a linked list
// and before insertion into this linked list,
// just make sure the new item is not equal to any 
// of the previous ones

class Node
{
	int data;
	Node next;
}

public class hello
{
	public static void main(String[] args)
	{
		int max = 0;
		int den = 0;
		for (int i=100; i<=1000;i++)
		{
			//System.out.println("going for "+i);
			int length = recurLength(i);
			System.out.println(i + " length is "+length);
			if(max < length)
			{
				max = length;
				den = i;
			}
		}
		System.out.println(max +";;"+den);
	}

	static int recurLength(int den)
	{
		int num = 10;
		int loopLength = 0;
		Node head = new Node();
		int listLength = 0;
		while(num%den != 0)
		{
			num %= den;
			num *= 1000;
			Node newLink = new Node();
			listLength++;
			newLink.data = num;
			newLink.next = null;
			Node current = head;
			// go to end making sure it is not equal to
			// any of the passing elements
			if(head == null)
				head = newLink;
			else
			{
				while(current.next != null && current.data !=num)
					current = current.next;
				current.next = newLink; // last added	
				if(current.data == num)
					break;
				loopLength++;
				//System.out.println(current.data);
			}
			
			//System.out.print(num/10+"  ");
		}
		if(loopLength == listLength)
			return 0;
		//printLength(head);
		//System.out.println("...........");
		return loopLength;
	}
	static void printLength(Node start)
	{
		while(start.next != null)
		{
			start = start.next;
		}

		System.out.println();
	}
}