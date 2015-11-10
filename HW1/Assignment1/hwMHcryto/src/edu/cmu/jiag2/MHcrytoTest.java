package edu.cmu.jiag2;
  
/******************************
 *The test driver for MH crpto
 * ********************************/

import java.math.BigInteger;
import java.util.Scanner;
public class MHcrytoTest {
	public static void main(String[] args) {
	MerkleHellmanCrypto test =new MerkleHellmanCrypto();
	Scanner input = new Scanner(System.in);
	String plaintext="";
	do{
		System.out.println("Enter a string and I will encrypt it as single large integer：");
		plaintext= input.nextLine();
		System.out.println("Clear text:"+plaintext);
		System.out.println("Number of clear text bytes ="+plaintext.getBytes().length);
		if(plaintext.length()>=80)
			System.out.println("Note! The string you enter can not be larger than 640 bits");
		System.out.println(plaintext);
	}while(plaintext.length()>=80);
        BigInteger ciphertext=test.encryption(plaintext);
    	String output=test.decryption(ciphertext);
    	System.out.println("The plaintext:'"+plaintext+"'is encrypted as:"+ciphertext.toString());
    	System.out.println("Result of decryption:"+output);
	
		
	}

	
	

}
