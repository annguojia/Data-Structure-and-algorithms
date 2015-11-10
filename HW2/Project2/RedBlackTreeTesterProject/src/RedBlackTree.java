
public class RedBlackTree {
	
	private RedBlackNode root;
	private RedBlackNode nilPointer=new RedBlackNode();
	//public int num;//the number of nodes we have 
	public static final int BLACK=0;
	public static final int RED =1;
	public int recentCompares=0;
	
	/**
	 * BigTheta(1)
	 */
	public RedBlackTree(){
		this.root=this.nilPointer;
		
	}
	/**
	 * BigTheta(1)
	 * @param data
	 */
	public RedBlackTree(String data){
		
		this.root=new RedBlackNode();
		this.root.setColor(BLACK);
		this.root.setP(nilPointer);
		this.root.setLc(nilPointer);
		this.root.setRc(nilPointer);
		this.root.setData(data);
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 * @return
	 */
	public int getSize(){
		return getSize(this.root);
	}
	/**
	 * @precondition a tree should be created first
	 * BigTheta(n)
	 * @param n
	 * @return
	 */
	public int getSize(RedBlackNode n){
		if(n==this.nilPointer)
			return 0;
		else return 1+getSize(n.getLc())+getSize(n.getRc());
		
	}
	/**
	 * @precondition a tree should be created first
	 * BigTheta(n)
	 * @param t
	 */
	public void inOrderTraversal(RedBlackNode t){
		String data=t.getData();
		String clr=(t.getColor()==0)?"Black":"red";
		String dataP=(t.getP()==(this.nilPointer))?"null":t.getP().getData();
		String dataLc=(t.getLc()==(this.nilPointer))?"null":t.getLc().getData();
		String dataRc=(t.getRc()==(this.nilPointer))?"null":t.getRc().getData();
		System.out.println("[data="+data+":Color="+clr+":Parent="+dataP+":LeftChild"+dataLc+":rightChild"+dataRc);
		if(t.getLc()!=this.nilPointer)
		{
			inOrderTraversal(t.getLc());
		}
		if(t.getRc()!=this.nilPointer)
		{
			inOrderTraversal(t.getRc());
		}
	}
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 */
	public void inOrderTraversal(){
		inOrderTraversal(this.root);
	}
	
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(n)
	 * @param t
	 */
	public void reverseOrderTraversal(RedBlackNode t){
		if(t.getLc()!=this.nilPointer){
			reverseOrderTraversal(t.getLc());
		}
		if(t.getRc()!=this.nilPointer){
			reverseOrderTraversal(t.getRc());
		}
		String data=t.getData();
		String clr=(t.getColor()==0)?"Black":"red";
		String dataRc=(t.getRc()==(this.nilPointer))?"null":t.getRc().getData();
		String dataP=(t.getP()==(this.nilPointer))?"null":t.getP().getData();
		String dataLc=(t.getLc()==(this.nilPointer))?"null":t.getLc().getData();
		
		System.out.println("[data="+data+":Color="+clr+":Parent="+dataP+":LeftChild"+dataLc+":rightChild"+dataRc);
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 */
	public void reverseOrderTraversal(){
		reverseOrderTraversal(this.root);	
	}
	
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(logn)
	 * The insert() method places a data item into the tree. 
	 * It executes the following algorithm from CLR:
	 * @param value
	 */
	public void insert(java.lang.String value){
		if(this.contains(value))
			System.out.println("This word"+value+"is already in the dictionary");
		else{
		RedBlackNode z=new RedBlackNode();
		z.setData(value);
		z.setColor(BLACK);
		RedBlackNode x=this.root;
		RedBlackNode y=this.nilPointer;
		//if(x==this.nilPointer)
		while(x!=this.nilPointer){
			y=x;
			if (x.getData().compareTo(z.getData())>0)
				x=x.getLc();
			else 
				x=x.getRc();}
		z.setP(y);
		if(y==this.nilPointer)
			this.root=z;
		else if( z.getData().compareTo(y.getData())<0)
				y.setLc(z);
		else 
				y.setRc(z);
		z.setLc(this.nilPointer);
		z.setRc(this.nilPointer);
		z.setColor(RED);
		RBInsertFixup(z);}
		
			
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 * leftRotate() performs a single left rotation. 
	 * This would normally be a private method. It executes the following algorithm from CLR
	 * @param x
	 */
	public void leftRotate(RedBlackNode x){
		RedBlackNode y=new RedBlackNode();
		y=x.getRc();
		x.setRc(y.getLc());
		y.getLc().setP(x);
		y.setP(x.getP());
		
		if(x.getP()==this.nilPointer)
			this.root=y;
		else{
			if(x==x.getP().getLc())
				x.getP().setLc(y);
			else
				x.getP().setRc(y);
		}
		y.setLc(x);
		x.setP(y);
	}
	
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 * pre: left[x] != nil[T]
	 * pre: root's parent is nill[T]
	 * rightRotate() performs a single right rotation 
	 * This would normally be a private method. It executes the following algorithm from CLR.
	 * @param x
	 */
	public void rightRotate(RedBlackNode x){
		RedBlackNode y=new RedBlackNode();
		y=x.getLc();
		x.setLc(y.getRc());
		y.getRc().setP(x);
		y.setP(x.getP());
		
		if(x.getP()==this.nilPointer)
			this.root=y;
		else{
			if(x==x.getP().getLc())
				x.getP().setLc(y);
			else{
				x.getP().setRc(y);
				
			}
				
		}
		y.setRc(x);
		x.setP(y);
		
	}
	
	/**
	 * @precondition a tree should be created first
	 * worst case:BigTheta(logn) best case:BigTheta(1)
	 * Fixing up the tree so that Red Black Properties are preserved. 
	 * This would normally be a private method.
	 * @param z
	 */
	public void RBInsertFixup(RedBlackNode z){
		
		RedBlackNode y=new RedBlackNode();
		while (z.getP().getColor()==RED){
			//z's father is left chindren of his grandpa
			if(z.getP()==z.getP().getP().getLc()){
				//y is z's uncle
				y=z.getP().getP().getRc();
				if(y.getColor()==RED){
					z.getP().setColor(BLACK);
					y.setColor(RED);
					z.getP().getP().setColor(RED);
					z=z.getP().getP();
				}
				else{
					if (z==z.getP().getRc()){
						z=z.getP();
						leftRotate(z);
					}
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					rightRotate(z.getP().getP());
				}
									
				}
			else{
				y=z.getP().getP().getLc();
				if(y.getColor()==RED){
					z.getP().setColor(BLACK);
					y.setColor(BLACK);
					z.getP().getP().setColor(RED);
					z=z.getP().getP();
				}
				else{
					if(z==z.getP().getLc()){
						z=z.getP();
						rightRotate(z);
					}
					z.getP().setColor(BLACK);
					z.getP().getP().setColor(RED);
					leftRotate(z.getP().getP());
				}
				
				
			}

			}
			this.root.setColor(BLACK);
		}
		

	/**
	 * @precondition a tree should be created first
	 * BigTheta(logn)
	 * The boolean contains() returns true if the String v is in the RedBlackTree and false otherwise.
	 * It counts each comparison it makes in the variable recentCompares.
	 * @param v
	 * @return
	 */
	public boolean contains(java.lang.String v){
		this.recentCompares=0;
		RedBlackNode x=this.root;
		RedBlackNode y=this.nilPointer;
		boolean isContain=false;
		while(x!=this.nilPointer){
			this.recentCompares++;
			if(x.getData().compareTo(v)==0){
				isContain=true;
				break;
			}
			else if(x.getData().compareTo(v)>0)	{
				x=x.getLc();
				isContain=false;
				continue;}
			else if (x.getData().compareTo(v)<0)
				x=x.getRc();
				isContain=false;
				continue;
			}
		return isContain;
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 * number of comparisons made in last call on the contains method.
	 * @return
	 */
	public int getRecentCompares(){
		return this.recentCompares;	
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(logn)
	 * The method closeBy(v) returns a value close to v in the tree. If v is found in the tree it returns v.
	 * @param v
	 * @return
	 */
	public java.lang.String closeBy(java.lang.String value){
		RedBlackNode closeByNode=this.root;
		RedBlackNode pointer=this.root;
		//RedBlackNode y=this.nilPointer;
		while(pointer !=this.nilPointer){
			if(value.compareTo(pointer.getData())>0){
				
				closeByNode=pointer;
				pointer=pointer.getRc();
				
			}
			else if(value.compareTo(pointer.getData())<0){
				closeByNode=pointer;
				pointer=pointer.getLc();
				
			}
			else{
				return value;
			}
		}
		
		return closeByNode.getData();
	}
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(n)
	 * This a recursive routine that is used to compute the height of the red black tree. 
	 * It is called by the height() method.
	 * The height() method passes the root of the tree to this method. 
	 * This method would normally be private
	 * @param t
	 * @return
	 */
	public int height(RedBlackNode t){
		if(t==this.nilPointer){
			return -1;
		}
		else{
			return 1+Math.max(height(t.getLc()), height(t.getRc()));
		}
		
	}
	
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(1)
	 * This method calls the recursive method.
	 * @return
	 */
	public int height(){	
		return height(this.root);
		
	}
	
	
	/**
	 * @precondition a tree should be created first
	 * BigTheta(n)
	 * This method displays the RedBlackTree in level order. 
	 * It first displays the root. Then it displays all children of the root. 
	 * Then it displays all nodes on level 3 and so on. It is not recursive. It uses a queue.
	 * @throws Exception 
	 * 
	 */
	public void levelOrderTraversal() throws Exception{
		Queue Q= new Queue();
		Q.enQueue(this.root);
		while(!Q.isEmpty()){
			RedBlackNode x=(RedBlackNode)Q.deQueue();
			String clr=x.getColor()==0?"Black":"Red";
			String data=x.getData();
			String dataP=(x.getP()==(this.nilPointer))?"null":x.getP().getData();
			String dataLc=(x.getLc()==(this.nilPointer))?"null":x.getLc().getData();
			String dataRc=(x.getRc()==(this.nilPointer))?"null":x.getRc().getData();
			System.out.println("[data= "+data+":Color= "+clr+" :Parent= "+dataP+" :LeftChild "+dataLc+" :rightChild "+dataRc+"]");
			if(x.getLc()!=this.nilPointer)
				Q.enQueue(x.getLc());
			if(x.getRc()!=this.nilPointer)
				Q.enQueue(x.getRc());
		}
		
		
		
	}
	/**
	 * 
	 * Used to test the redblacktree
	 * @param args
	 * @throws Exception
	 */
	public static void main(java.lang.String[] args) throws Exception{
		
		RedBlackTree rbt = new RedBlackTree();

        for(int j = 1; j <= 5; j++) rbt.insert(""+j);

        // after 1..5 are inserted
        System.out.println("RBT in order");
        rbt.inOrderTraversal();
        System.out.println("RBT level order");
        rbt.levelOrderTraversal();

       // is 3 in the tree

        if(rbt.contains(""+3)) System.out.println("Found 3");
        else System.out.println("No 3 found"); 

        // display the height
        System.out.println("The height is " + rbt.height());
	}
	
	
	
	
	
	
	
	
	

}
