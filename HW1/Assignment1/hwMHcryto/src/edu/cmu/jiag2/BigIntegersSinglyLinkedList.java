package edu.cmu.jiag2;

import java.math.BigInteger;

	/**
	 * This class BigIntegersSinglyLinkedList
	 * It contains basic operations of SinglyLinkedList
	 * @author jia guo
	 */
public class BigIntegersSinglyLinkedList {
	
	BigIntegersSingleNode head;
	BigIntegersSingleNode tail;
	
	/**
	 * void constructor 
	 * Bigtheta(1)
	 * @param none
	 * @precondition none
	 * @postcondition nessacary to using this constructor to initialize an object
	 *  			  to do encryption decryption and keyGeneration operation 
	 */	
	
	public BigIntegersSinglyLinkedList(){
		this.head = null;
		this.tail = null;
	}

	/**
	 * constructor with arguments
	 * Bigtheta(1)
	 * @precondition
	 * @postcondition nessacary to using this constructor to initialize an object
	 *                to do encryption decryption and keyGeneration operation 
	 * @param h:is assigned as a BigIntegersSingleNode
	 * @param t:is assigned as a BigIntegersSingleNode
	 */
	public BigIntegersSinglyLinkedList(BigIntegersSingleNode h, BigIntegersSingleNode t){
		this.head = h;
		this.tail = t;
	}
	
	/**
	 * isEmpty()
	 * BigTheta(1)
	 * @return boolean: whether this list is empty
	 * @precondition an object has been initialized 
	 * @postcondition 
	 */	
	public boolean isEmpty(){
		return this.head==null;
	}
	
	/**
	 *  addIntAtFront
	 *  Bigtheta(1)
	 * @param BigInteger num
	 * @precondition  an object has been initialized
	 * @postcondition  
	 */		
	public void addIntAtFront(BigInteger num){
		if(this.isEmpty()) this.head.setNumber(num);
		else 
			head=new BigIntegersSingleNode(num,head);
		
	}
	/**
	 *  addIntAtTail
	 *  Best case:Bigtheta(1),Worst case:Bigtheta(n)
	 * @param BigInteger num
	 * @precondition  an object has been initialized
	 * @postcondition  
	 */		
	public void addIntAtTail(BigInteger num){
		BigIntegersSingleNode temp=new BigIntegersSingleNode();
		temp.setNumber(num);
		if(this.isEmpty())
		{
			this.head=temp;
			this.tail=temp;
		}
		else{
			this.tail.setPointer(temp);
			this.tail=temp;
		}
	}
	
	/**
	 * sumIntegersList
	 * Best Bigtheta(1), worst Bigtheta(n)
	 * @param none
	 * @return Sum of ever BigIntergerList node's data
	 * @precondition  an object has been initialized
	 * 				  existing a node which has a null pointer
	 * @postcondition  
	 */			
	public BigInteger sumIntegersList(){
		BigInteger sum=BigInteger.ZERO;
		BigIntegersSingleNode temp=this.head;
		while(temp!=null)
		{
			sum= sum.add(temp.getNumber());
			temp=temp.getPointer();
		}
		return sum;
	}
	/**
	 *  toString
	 *  Bigtheta(n)
	 * @param none
	 * @return Sum of a BigIntergerList's data
	 * @precondition  an object has been initialized
	 * 				  existing a node which has a null pointer
	 * @postcondition  
	 */			
	public String toString(){
	String output="";
	BigIntegersSingleNode temp = this.head;
	if(this.isEmpty()) return output;
	if(this.head == this.tail)return String.valueOf(this.head.getNumber());
	else 
		while(temp!=null)
		{
			output = output + String.valueOf(temp.getNumber());
			temp = temp.getPointer();
		}
	return output;
	}
	/**
	 *  reverse()
	 *  Bigtheta(1)
	 * @param none
	 * @return none
	 * @precondition  an object has been initialized
	 * 				  existing a node which has a null pointer
	 * @postcondition  
	 */			
	public void reverse(){
		BigIntegersSingleNode pre = null;
		BigIntegersSingleNode temp = this.head;
		BigIntegersSingleNode next = this.head.getPointer();
		if(!this.isEmpty()||(this.head!=this.tail)){
			
			while(next!=null)
				{
				temp.setPointer(pre);
				pre=temp;
				temp=next;
				next=next.getPointer();
				}
			temp.setPointer(pre);
			this.tail=this.head;
			this.head = temp;
			
			}
		}		
	/**
	 *  SearchByIndex
	 * @param the index
	 * @return Sum of a BigIntergerList's data
	 * @precondition  an object has been initialized
	 * 				  existing a node which has a null pointer
	 * @postcondition  
	 */			
		public BigIntegersSingleNode SearchByIndex(int index) {
			
		if (this.head == null) return null;
        BigIntegersSingleNode temp = this.head;
        for (int i = 0; i < index; i++) temp = temp.getPointer();        
        return temp;}
    
	
	}

	
	
	
	

