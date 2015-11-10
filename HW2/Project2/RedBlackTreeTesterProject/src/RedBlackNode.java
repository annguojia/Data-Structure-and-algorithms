/**
 * 
 * @author ann
 *
 */
public class RedBlackNode {
	
	public static int BLACK=0;
	public static int RED=1;
	
	private java.lang.String data;
	private int color;
	private RedBlackNode parent;
	private RedBlackNode leftChild;
	private RedBlackNode rightChild;
	

/**
 * no precondition and postcondition
 * BigTheta(1)	
 */
	public void RedBlackNode(){
		
		this.color=BLACK;
		this.data=null;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param data
	 * @param color
	 * @param p
	 * @param lc
	 * @param rc
	 */
	public void RedBlackNode(java.lang.String data, int color, RedBlackNode p, RedBlackNode lc, RedBlackNode rc){
		this.data=data;
		this.color=color;
		this.parent=p;
		this.leftChild=lc;
		this.rightChild=rc;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public int getColor(){
		return this.color;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public java.lang.String getData(){
		return this.data;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public RedBlackNode getLc(){
		return this.leftChild;
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public RedBlackNode getRc(){
		return this.rightChild;
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public RedBlackNode getP(){
		return this.parent;
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param color
	 */
	public void setColor(int color){
		this.color=color;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param data
	 */
	public void setData(java.lang.String data){
		this.data=data;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param lc
	 */
	public void setLc(RedBlackNode lc){
		this.leftChild=lc;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param rc
	 */
	public void setRc(RedBlackNode rc){
		this.rightChild=rc;
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param p
	 */
	public void setP(RedBlackNode p){
		this.parent=p;
		
	}
	/*public java.lang.String toString(){
		return Integer.toString(this.data);
		
	}
*/

}
