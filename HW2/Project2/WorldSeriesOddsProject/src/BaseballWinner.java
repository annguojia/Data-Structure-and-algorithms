
public class BaseballWinner {
	/**
	 * The main function()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int A = 20;
		int B = 23;
		//for recursive 
		long start1 = System.currentTimeMillis();
		System.out.println(" The probility of recursive Calculation is "+recursion(A, B));
		long end1 = System.currentTimeMillis();
		System.out.println(" Recursive programming takes "+ (end1-start1) +  " milliSeconds");
		
		//for normal array
		/*long start2 = System.currentTimeMillis();
		System.out.println(" The probility of ArrayCalculation is "+arrayCalculation(A, B));
		long end2 = System.currentTimeMillis();
		System.out.println("Dynamic programming takes "+ (end2-start2) +  " milliSeconds");*/
	}
 
	/**
	 * Initializing the probility of 0 and 1
	 * Bigtheta=i+j+i*j
	 * @param Awin
	 * @param Bwin
	 * @return
	 */
	private static double arrayCalculation(int Awin, int Bwin){
		double [][] result=new double[Awin+1][Bwin+1];
		
		for (int i=1;i<Awin+1;i++){
			result[i][0]=0;
			
		}
		for(int i=1;i<Bwin+1;i++){
			result[0][i]=1;
		}
		for(int i=1;i<Awin+1;i++){
			
			for(int j=1;j<Bwin+1;j++)
			{
				result[i][j]=0.5*(result[i-1][j]+result[i][j-1]);
			}
		}
		return result[Awin][Bwin];
	}
	
	/**
	 *  BigTheta(1)
	 * @param numToWinA
	 * @param numToWinB
	 * @return
	 */
	private static double recursion(int numToWinA, int numToWinB) {
		double temp = intoRecursion(numToWinA, numToWinB);
		return temp;
	}
	
	/**
	 * BigTheta(power(2,n))
	 * @param numAwin
	 * @param numBwin
	 * @return
	 */
	private static double intoRecursion(int numAwin, int numBwin){
		double result=0;
		
		if (numAwin==0){
			result=1;
			return result;
			}
		else if(numBwin==0){
			result=0;
			return result;
			}
		else 
			return 0.5*(intoRecursion(numAwin-1,numBwin)+intoRecursion(numAwin,numBwin-1));
	}

}
