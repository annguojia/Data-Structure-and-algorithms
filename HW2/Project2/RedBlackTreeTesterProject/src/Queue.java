/**
 * used for redblacktree levelsearch
 * @author ann
 *
 */
public class Queue {
	
	private static final int DEFAULT_CAPACITY=10;
	private int front;
	private int rear;
	private int count;//tempory capacity
	private Object [] queue;
	/**
	 * BigTheta(1)
	 */
	public Queue(){
		this.front=0;
		this.rear=0;
		this.count=DEFAULT_CAPACITY;
		queue=new Object[this.count];
	}
	/**
	 * BigTheta(1)
	 * @param capacity is the capacity of array queue
	 */
	public Queue(int capacity){
		this.front=0;
		this.rear=0;
		this.count=capacity;
		this.queue=new Object [this.count];
	
	}
	/**
	 * BigTheta(1)
	 * @return
	 */
	public boolean isEmpty()
	{
		return (front==rear)?true:false;
	}
	
	
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @param  
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean isFull() throws Exception{
		
		int distance= this.rear-this.front;
		
		if(distance==-1||distance==(this.count-1)%this.count){

			return true;		
			
		}	
		else 
			return false;	
		
	}
	
	
	/**
	 * no precondition and postcondition
	 * Bestcase BigTheta(1) when the queue is not full;
	 * Worstcase BigTheta(n)
	 * @param x
	 * @throws Exception 
	 */
	public void enQueue(java.lang.Object x) throws Exception{
		if(isFull()){
			int tempfront=this.front;
			int temprear=this.rear;
			Object [] q=new Object[this.count *2];
			for(int i=0;i<this.count;i++){
				q[i]=this.queue[tempfront];
				tempfront=(tempfront+1)%this.count;
			}
			this.count=this.count*2;
			this.queue=q;
			this.front=0;
		
			System.out.println("Full! But I have already doubled the space");
		}
			this.queue[this.rear]=x;
			this.rear=(this.rear+1)%this.count;

			
		
		
	}
	/**
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 * @throws Exception
	 */
	public java.lang.Object deQueue() throws Exception{
		Object dequeueItem;
		if (this.isEmpty())
		{
			throw new Exception("Queue is Empty.");
		}
		else{
			dequeueItem=this.queue[this.front];
			//this.queue[this.front]=null;
			front=(front+1)%this.count;
		}
		return dequeueItem;
		
	}
	
	/**
	 * 
	 * Pre-condition:this queue has be created&queue not empty
	 * no precondition and postcondition
	 * BigTheta(1)
	 * @return
	 */
	public java.lang.Object getFront(){
		return this.front;
		
	}
	
		
	
	/**
	 * 
	 * @param a
	 * @throws Exception 
	 */
	public static void main(java.lang.String[] a) throws Exception{
		Queue test=new Queue();
		String x="I love you";
		String y="Not at all";
		test.enQueue(x);
		test.enQueue(y);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		System.out.println("exceed length!");
		test.enQueue(x);
		test.enQueue(y);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(y);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		test.enQueue(x);
		
		
	}
	
	

}
