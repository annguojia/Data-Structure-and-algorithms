package hwlinkednode;

/**
 * This class implements a doubly linked list of characters in Java. 
 * @author jia guo
 * The instance variables head and tail are initially null. 
 * As elements are added head points to the first element on the list and tail points to the last element. 
 * Each node on the list is of type DoubleNode. 
 * Each DoubleNode holds a pointer to the previous node and a pointer to the next node in the list.
 */
	public class DoublyLinkedList{
	
	private DoubleNode head;
	private DoubleNode tail;
	
	/**
	 * void constructor
	 * Bigtheta(1)
	 */
	public DoublyLinkedList(){
		
		this.head = null;
		this.tail = null;
	}
	/**
	 * addCharAtFront(): add a char number at the front of list
	 * Bigtheta(1)
	 * @pre an object has been constructed
	 * @post none
	 * @param c: assigned a char data type
	 */
	public void addCharAtFront(char c){
		//if the DoublyLinkedList is null, 
		//then when add a char, the head and end is the same one
		if(this.isEmpty()){
			this.head = new DoubleNode(null,c,null);
			this.tail = this.head;
		}
		else{
			DoubleNode ohead = this.head;
			this.head = new DoubleNode(null,c,ohead);
			ohead.setPrev(this.head);
			
		}
	}
	
	/**
	 * addCharAtEnd():add a char number at the end of list
	 * BigTheta(1)
	 * @pre an object has been constructed
	 * @post none
	 * @param c :assigned a char data type
	 */
	public void addCharAtEnd(char c){
		if(this.isEmpty())
		{
			this.tail = new DoubleNode(null,c,null);
			this.head = this.tail;	
		}
		else{
			DoubleNode otail =this.tail;
			this.tail = new DoubleNode(otail,c,null);
			otail.setNext(this.tail);
			
		}
		((DoubleNode) this.tail).setC(c);
	}
	/**
	 * countNodes():count the number of nodes in this list
	 * Best case:BigTheta(1) Worst case:BigTheta(n)
	 * @pre an object has been constructed and existing a next pointer must be null
	 * @post none
	 * @return int countnumber of this DoubleListNode
	 *
	 */
	public int countNodes(){
		if(this.head ==null)
			return 0;
		int count = 1;
		DoubleNode st = this.head;
		while(st.getNext() !=null){
			st = st.getNext();
			count++;
		}
		return count;
	}

	/**
	 * deleteChar(): delete a node which's data part equals to char c
	 * Best case:BigTheta(1) worst case:Bigtheta(n)
	 * @pre         an object has been constructed
	 * @post none
	 * @param c: assigned a char data type
	 * @return boolean
	 */
	public boolean deleteChar(char c){
		DoubleNode temp=this.head;
		//
		DoubleNode st=null;
		while(temp!=null){
			if(temp.getC()==c){
				if(temp==this.head&&temp==this.tail)
				{
					this.head=null;
					this.tail=null;
					break;
				}
				if(temp==this.head)
				{
					st=temp.getNext();
					st.setPrev(null);
					this.head=st;
					break;
				}
				if(temp==this.tail)
				{
					st=temp.getPrev();
					st.setNext(null);
					this.tail=st;
					break;
				}
				else{
					st=temp.getPrev();
					st.setNext(temp.getNext());
					temp.getNext().setPrev(st);
					
				}
				return true;
			}
			temp=temp.getNext();	
		}
		
		return false;
		
	}
	
	/**
	 * removeCharAtEnd(): delect a node at tail and return the char data
	 * BigTheta(N)
	 * @return char c
	 * @pre an object has been constructed; existing a next pointer must be null
	 * @post
	 */

	public char removeCharAtEnd(){
		DoubleNode temp = this.head;
		char tempC='\0';
		if(this.isEmpty())/*return tempC*/;
		if(this.head == this.tail) {
			tempC = this.head.getC();
			this.head = null;
			this.tail = null;
			/*return tempC;*/
		}
		while (temp.getNext()!=null){
			if(temp.getNext()==this.tail)
			{
				tempC = this.tail.getC();
				temp.setNext(null);
				this.tail = temp;
				/*return tempC;*/
				
			}
			else temp=temp.getNext();
			
		}
		return tempC;
	}
	
	/**
	 * removeCharAtFront(): delect a node at head and return the char data
	 * Bigtheta(1)
	 * @pre an object has been constructed
	 * 				 existing a next pointer must be null
	 * @post 
	 * @return char c
	 **/
	public char removeCharFromFront(){
		DoubleNode temp = this.head;
		char tempC = this.head.getC();
		if(this.isEmpty())/*return tempC*/;
		if(this.head == this.tail) {
		
			tempC = this.head.getC();
			this.head = null;
			this.tail = null;
			/*return tempC;*/
		}
		if(temp.getNext()!=null){
			temp=temp.getNext();
			temp.setPrev(null);
			this.head = temp;
		}
		return tempC;
	}
	
	/**
	 * reverse(): reverse the whole list make tail to head head to tail 
	 * Bigtheta(N)
	 * @pre 		an object has been constructed
	 * 				existing a tail's next pointer must be null
	 * @post 
	 */
	public void reverse(){
		DoubleNode pre = null;
		DoubleNode temp = this.head;
		DoubleNode next = this.head.getNext();
		if(!this.isEmpty()||(this.head!=this.tail)){
			
			while(next!=null)
				{
				temp.setPrev(next);
				temp.setNext(pre);
				pre=temp;
				temp=next;
				next=next.getNext();
				}
			temp.setNext(pre);
			temp.setPrev(next);
			this.tail=this.head;
			this.head = temp;
			
			}
		}	
	
	/**
	 * toString(): output the whole list's data part in a string 
	 * Bigtheta(N)
	 * @pre an object has been constructed &existing a next pointer must be null
	 * @post none 
	 * @return java.lang.String
	 */
	public java.lang.String toString(){
		String output="";
		DoubleNode temp = this.head;
		if(this.isEmpty()) return output;
		if(this.head == this.tail)return String.valueOf(this.head.getC());
		while(temp!=null)
			{
				output = output + String.valueOf(temp.getC());
				temp = temp.getNext();
			}
			return output;
		}
	
	/**
	 * isEmpty(): test whether this list is empty
	 * Bigtheta(1)
	 * @pre    an object has been constructed & existing a next pointer must be null
	 * @post
	 * @return boolean 
	 */
	public boolean isEmpty(){
	return this.head ==null;	
}
	
	/**
	 * This is a Test Driver to test the feasibility of this Specification
	 * @author jia guo
	 * @param a: this is a string array 
	 */
		public static void main(String a[]) {
			
			DoublyLinkedList list = new DoublyLinkedList();
			list.addCharAtEnd('H');
			list.addCharAtEnd('e');
			list.addCharAtEnd('l');
			list.addCharAtEnd('l');
			list.addCharAtEnd('o');
			System.out.println(list);
			System.out.println("Deleting l");
			list.deleteChar('l');
			System.out.println(list);
			System.out.println("Deleting H");
			list.deleteChar('H');
			System.out.println(list);
			System.out.println("Deleting o");
			list.deleteChar('o');
			System.out.println(list);
			System.out.println("Deleting e");
			list.deleteChar('e');
			System.out.println(list);
			System.out.println("Deleting l");
			list.deleteChar('l');
			System.out.println(list);
			list.addCharAtFront('o');
			list.addCharAtFront('l');
			list.addCharAtFront('l');
			list.addCharAtFront('e');
			list.addCharAtFront('H');
			System.out.println(list);
			
			System.out.println(list.countNodes());
			
			System.out.println("Popping everything");
			while(!list.isEmpty()){
				System.out.println(list.removeCharFromFront());
			}
			
			list.addCharAtFront('o');
			list.addCharAtFront('l');
			list.addCharAtFront('l');
			list.addCharAtFront('e');
			list.addCharAtFront('H');
			
			System.out.println("Popping everything from the end");
			while(!list.isEmpty()){
				System.out.println(list.removeCharAtEnd());
			}
			System.out.println(list.countNodes());
			
			list.addCharAtEnd('o');
			list.addCharAtEnd('l');
			list.addCharAtEnd('l');
			list.addCharAtEnd('e');
			list.addCharAtEnd('H');
		
			list.reverse();
			System.out.println(list);
			
			list.reverse();
			System.out.println(list);

			
		}

}
