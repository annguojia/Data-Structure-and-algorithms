package edu.cmu.jiag2;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Random;
	/**
	 * @author Jia Guo
	 * 
	 * This class MerkleHellmanCrypto is used to do MerkleHellman encryption and decryption 
	 * Datatype:SinglyLinkedList
	 */

	public class MerkleHellmanCrypto {
	
	private BigIntegersSinglyLinkedList BigintListW;
	private BigIntegersSinglyLinkedList BigintListB;
	private BigInteger BigintR;
	private BigInteger BigintQ;
	private int maxSize=80*8;
	/**
	 * void constructor of MerkleHellmanCrypto
	 * used to initialize an object
	 */
	public MerkleHellmanCrypto(){};
	
	/**
	 * Generating of all the parameter needed in MerkleHellman
	 * @param plaintext: the input of String
	 * @precondition a MerkleHellmanCrypto class has been constructed
	 * @postcondition none
	 * 
	 */
		private void keyWQRBGenerator(String plaintext){
		this.maxSize=plaintext.length()*8;
		// Generating W

		BigIntegersSinglyLinkedList w= new BigIntegersSinglyLinkedList();
		//System.out.println("---Now generating the parameter W");
		Random ran=new Random();
		w.addIntAtTail(BigInteger.ONE);
		for(int i=1;i<maxSize;i++){
			//convert char to bytes
			w.addIntAtTail(w.sumIntegersList().add(new BigInteger(ran.nextInt(5)+1+"")));
			//System.out.println("---W"+i+": "+w.SearchByIndex(i).getNumber());
		}
		this.BigintListW=w;
		
		// Generating Q
		//System.out.println("---Now generating the parameter Q");
		this.BigintQ=this.BigintListW.sumIntegersList().add(new BigInteger(ran.nextInt(10)+1+""));
		//System.out.println("---Q:"+this.BigintQ.toString());
		
		// Generating R
		do{ 
			this.BigintR = this.BigintQ.add(new BigInteger(ran.nextInt(10)+1+""));
		}while(this.BigintQ.gcd(BigintR).intValue()!=1);
		//System.out.println("---R:"+this.BigintR.toString());
		
		//Generating B
		BigIntegersSinglyLinkedList temp=new BigIntegersSinglyLinkedList();
		for(int i = 0; i<plaintext.length()*8; i++){
			temp.addIntAtTail(BigintR.multiply(BigintListW.SearchByIndex(i).getNumber()).mod(BigintQ));
			//System.out.println("---B:"+temp.SearchByIndex(i).getNumber());
		}
		this.BigintListB=temp;		
	}
	/**
	 * Call private function to Generating of all the parameter needed in MerkleHellman 
	 * Using them to do encrypting
	 * @param plaintext: the input of String
	 * @return the ciphertext Merkle-Hellman has generated
	 * @precondition a MerkleHellmanCrypto class has been constructed;
	 * 				 a plaintext has been entered
	 * @postcondition none
	 */

	public BigInteger encryption(String plaintext){
		this.keyWQRBGenerator(plaintext);
		BigIntegersSinglyLinkedList A=new BigIntegersSinglyLinkedList();
		for (int i=0; i<this.maxSize;i++)
		{
			if(BitSet.valueOf(plaintext.getBytes()).get(i)==true)
				A.addIntAtTail(BigInteger.ONE.multiply(this.BigintListB.SearchByIndex(i).getNumber()));
			else 
				A.addIntAtTail(BigInteger.ZERO);
			//System.out.println(A);
	}
		return A.sumIntegersList();
		
		}
	/**
	 * Decryption the cipertext
	 * Bigtheta(n)
	 * @param ciphertext: put the ciphertext as the input of decryption function
	 * @precondition a MerkleHellmanCrypto class has been constructed
	 * 				 the key generation process and encrption process has been finished
	 * 				 the memeber parameter's value is stored
	 * @postcondition none
	 */
	public String decryption(BigInteger ciphertext){
		
		BigInteger temp=(ciphertext.multiply(this.BigintR.modInverse(this.BigintQ)).mod(this.BigintQ));
		BitSet reverse=new BitSet();
		for(int i=this.maxSize-1;i>=0;i--){
			if(temp.subtract(this.BigintListW.SearchByIndex(i).getNumber()).compareTo(BigInteger.ZERO)>=0){
				temp=temp.subtract(this.BigintListW.SearchByIndex(i).getNumber());
				//System.out.println(temp);
				reverse.set(i,true);
			}
			else reverse.set(i, false);	
		}
		byte[] decodeByteArray=reverse.toByteArray();
		return new String(decodeByteArray);
	}		

}
