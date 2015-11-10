package edu.cmu.jiag2;

import java.math.BigInteger;
/**
 *  BigIntegersSingleNode
 * @author Jia Guo
 * 
 */

public class BigIntegersSingleNode {
	private BigInteger number;
	private int index;
	private BigIntegersSingleNode pointer;
	
	/**
	 *  void constructor for SingleNode Class
	 *  Bigtheta(1)
	 * @precondition   none
	 * @postcondition  none
	 * @param none
	 */			

	public BigIntegersSingleNode(){
		this.number=BigInteger.ZERO;
		this.pointer=null;
		this.index=0;
	}
	
	
	/**
	 * constructor with arguments for SingleNode Class
	 * Bigtheta(1)
	 * @precondition   none
	 * @postcondition  none
	 * @param p:is assigned as a BigIntegersSingleNode Pointer
	 * @param num:is assigned as a BigInteger data
	 * @param ind: is assigned as a int index
	 */			
	public BigIntegersSingleNode(BigIntegersSingleNode p, BigInteger num,int ind){
		this.number=num;
		this.pointer=p;
		this.index= ind;
	}
	
	
	/**
	 * constructor with arguments for SingleNode Class
	 * Bigtheta(1)
	 * @precondition   none
	 * @postcondition  none
	 * @param num:is assigned as a BigInteger data
	 * @param pointer
	 */
	
	public BigIntegersSingleNode(BigInteger num, BigIntegersSingleNode pointer) {
		this.number=num;
		this.pointer=pointer;
	}
	
	/**
	 *set the number in the SingleNode
	 *Bigtheta(1)
	 *@precondition an object has been created using constructor in main 
	 *@postcondition none
	 *@param num: is assigned as a BigInteger data
	 */
	public void setNumber(BigInteger num){
		this.number = num;
	}
	
	
	/**
	 *set the pointer in the SingleNode
	 *Bigtheta(1)
	 *@param BigIntegersSingleNode p is assigned as BigIntegersSingleNode.
	 *@precondition an object has been created using constructor in main 
	 *@postcondition none
	 */
	public void setPointer(BigIntegersSingleNode p){
		this.pointer = p;
	}
	
	
	/**
	 *get the pointer of the SingleNode
	 *Bigtheta(1)
	 *@param none
	 *@return a singleNode pointer
	 *@precondition an object has been created using constructor in main 
	 *@postcondition none
	 */

	public BigIntegersSingleNode getPointer(){
		return this.pointer;
	}
	
	/**
	 *get the number part of the SingleNode
	 *Bigtheta(1)
	 *@precondition an object has been created using constructor in main 
	 *@postcondition none
	 *@return a singleNode's number
	 */
	public BigInteger getNumber(){
		return this.number;
	}
	
	  
	 /**
	  * change the singleNode number's type from BigInteger to String
	  * Bigtheta(1)
	  * precondition an object has been created using constructor in main
	  * @return char to String
	  */
	
    public String toString(){
         return this.number.toString();
    		
    	}
    
	
	

}
