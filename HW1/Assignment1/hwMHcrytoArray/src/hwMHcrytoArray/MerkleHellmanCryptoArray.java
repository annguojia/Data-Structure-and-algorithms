package hwMHcrytoArray;
	/**
	 * @author Jia Guo
	 * 
	 * This class MerkleHellmanCryptoArray is used to do MerkleHellman encryption and decryption 
	 * 
	 */
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Random;

public class MerkleHellmanCryptoArray {
	private BigInteger[] BigintW;
	private BigInteger[] BigintB;
	private BigInteger BigintR;
	private BigInteger BigintQ;
	private int maxSize=80*8;
	
	/**
	 * void constructor of MerkleHellmanCrypto
	 * used to initialize a object
	 */
	public void MerkleHellmanCrypto(){	};
	
	
	/**
	 * Generating of all the parameter needed in MerkleHellman
	 * Bigtheta(n)
	 * @precondition a MerkleHellmanCrypto class has been constructed
	 * @postcondition none
	 * @param plaintext: the input of String
	 */
	private void keyWQRBGenerator(String plaintext){
		this.maxSize=plaintext.length()*8;
		// Generating W
		BigInteger[] w = new BigInteger[this.maxSize];
		//System.out.println("---Now generating the parameter W");
		w[0]=BigInteger.ONE;			//initializing W[0];
		Random ran=new Random();		//use ran to generate random numbers
		BigInteger sum=BigInteger.ZERO;
		for(int i=1;i<maxSize;i++){
			sum=sum.add(w[i-1]);
			//randomly generate w[i] based on the sum of w[i-1] to w[0]
			w[i]=BigInteger.ZERO.add(sum).add(new BigInteger(ran.nextInt(5)+1+""));
			//System.out.println("---W["+i+"] is:"+w[i]);
		}
		this.BigintW=w;

		 //Generating  Q
		//System.out.println("---Now generating the parameter Q");
		this.BigintQ=BigInteger.ZERO.add(sum).add(new BigInteger(ran.nextInt(10)+1+""));//randomly generate q based on the sum of w
		//System.out.println("---Q is "+this.BigintQ);
		

		 //Generating  R
		//System.out.println("---Now generating the parameter R");
		do{ 
			this.BigintR = this.BigintQ.add(new BigInteger(ran.nextInt(10)+1+""));
		
		}while(this.BigintQ.gcd(BigintR).intValue()!=1);
		//System.out.println("---R is "+this.BigintR);
		

		 //Generating  B
		//System.out.println("---Now generating the parameter B");
		BigInteger[] temp=new BigInteger[this.maxSize];
		for(int i = 0; i<plaintext.length()*8; i++)
			temp[i]=BigintR.multiply(w[i]).mod(BigintQ);//gerenating b based on the certain replationship in the Merkle-Hellman
		this.BigintB=temp;	
		//System.out.println("---B is "+this.BigintB);
		}
	
	
	/**
	 * Call private function to Generating of all the parameter needed in MerkleHellman 
	 * Using them to do encrypting
	 * Bigtheta(n)
	 * @param plaintext: the input of String
	 * @return the ciphertext Merkle-Hellman has generated
	 * @precondition a MerkleHellmanCrypto class has been constructed;
	 * 				 a plaintext has been entered
	 * @postcondition none
	 */

	public BigInteger encryption(String plaintext){
		this.keyWQRBGenerator(plaintext);
		//System.out.println("---Now encryption started!");
		//using A[i] to store 1 or 0 multiply b[i]
		BigInteger[] A=new BigInteger[this.maxSize];
		BigInteger sum=BigInteger.ZERO;
		for (int i=0; i<this.maxSize;i++)
		{	//using bitset to convert byte to bit
			if(BitSet.valueOf(plaintext.getBytes()).get(i)==true)
				A[i]=BigInteger.ONE.multiply(this.BigintB[i]);
			else 
				A[i]=BigInteger.ZERO;
			sum=sum.add(A[i]);
		}
		return sum;
	}
	/**
	 * Decryption the cipertext
	 * Bigtheta(n)
	 *@precondition a MerkleHellmanCrypto class has been constructed
	 * 				 the key generation process and encrption process has been finished
	 * 				 the memeber parameter's value is stored
	 *@postcondition none
	 *@return String: the plaintext 
	 *@param ciphertext:input the ciphertext 
	 */

	public String decryption(BigInteger ciphertext){
		//using a bigInt to store the decryption computation of MerkleHellman
		BigInteger temp=(ciphertext.multiply(this.BigintR.modInverse(this.BigintQ)).mod(this.BigintQ));
		BitSet reverse=new BitSet();
		for(int i=this.maxSize-1;i>=0;i--){
			//if temp can be subtract, then flag reverse[i]=true
			if(temp.subtract(this.BigintW[i]).compareTo(BigInteger.ZERO)>=0){
				temp=temp.subtract(this.BigintW[i]);
				reverse.set(i,true);
			}
			//if not,flag reverse[i]=false
			else reverse.set(i, false);	
		}
		//converte bit to bytes
		byte[] decodeByteArray=reverse.toByteArray();
		return (new String(decodeByteArray));
	}		

}
