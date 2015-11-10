package hwlinkednode;

	/**
	 * Build DoubleNode type which has a previous and next pointer and stores a char data
	 * @author jia guo 
	 */
public class DoubleNode{
	private char ch;
	private DoubleNode p;
	private DoubleNode q;
	
	/**
	 * void constructor
	 * Bigtheta(1)
	 */
	public DoubleNode(){
		this.ch='\0';
		this.p=null;
		this.q=null;	
	}
	
	/**
	 * constructor with arguments
	 * BigTheta(1)
	 * @param pre-is assigned as previous pointer
	 * @param cha-is assigned as the data part
	 * @param next-is assigned as the next pointer
	 */
	public DoubleNode(DoubleNode pre,char cha, DoubleNode next){
		this.ch=cha;
		this.p=pre;
		this.q=next;	
	}
	
	/**
	 *get the data from the DoubleNode 
	 *Bigtheta(1)
	 * @return DoubleNode's data
	 */
	public char getC(){return this.ch;}
	
	
	/**
	 * get the pointer from the DoubleNode
	 * Bigtheta(1)
	 * @return DoubleLinkedNode(next)
	 */
	public DoubleNode getNext(){return this.q;}
	
	
	/**
	 *get the pointer from the DoubleNode
	 *BigTheta(1)
	 *@return DoubleLinkedNode(previous)	
	 */
	public DoubleNode getPrev(){return this.p;}
	
	/**
	 *set the next pointer from the DoubleNode
	 *Bigtheta(1)
	 *@param DoubleLinkedNode next
	 */
	public void setNext(DoubleNode next){this.q=next;}
	
	/**
	 * set the previous pointer from the DoubleNode
	 * BigTheta(1)
	 *@param DoubleLinkedNode prev
	 */
	public void setPrev(DoubleNode prev){this.p=prev;}
	
	/**
	 * change Node's data type from char to string 
	 * BigTheta(1)
	 * @return java.lang.String
	 */
	public java.lang.String toString(){return Character.toString(this.ch);}
	
	/**
	 * set the number from the DoubleNode
	 * BigTheta(1)
	 *@param char C
	 */
	public void setC(char c) {
		// TODO Auto-generated method stub
		
	}
	public static void main(java.lang.String[] args){}

	
	
}
