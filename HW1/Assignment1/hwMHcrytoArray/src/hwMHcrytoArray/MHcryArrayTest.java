	package hwMHcrytoArray;
	
	import java.math.BigInteger;
	import java.util.Scanner;
	/**
	 * 	@author Jia Guo
	 *  This is a Test Driver of Merkle-Hellman Crypto  
	 * 	Problems：is there any need to compute the BigO Bigtheta Bigomega ?
	 * 
	 */
	public class MHcryArrayTest {
		
	public static void main(String[] args) {
			
		MerkleHellmanCryptoArray test =new MerkleHellmanCryptoArray();
		Scanner inputString = new Scanner(System.in);
		String plaintext="";
		do{
			System.out.println("Welcome! Enter a string and I will encrypt it as single large integer：");
			plaintext= inputString.nextLine();
			System.out.println("Clear text:");
			System.out.println(plaintext);
			System.out.println("---Number of clear text bytes = "+plaintext.getBytes().length);
			if(plaintext.length()>=80)
				System.out.println("---Alert! The length of string is exceeding 80 bytes! Re-enter Please:");
		}while(plaintext.length()>=80);
		/*Call function and do encryption */
        BigInteger ciphertext=test.encryption(plaintext);
        //Print out the ciphertext in the console
        System.out.println("---The ciphertext:"+ciphertext.toString());
        /*Call function and do decryption */
    	String outputString=test.decryption(ciphertext);
    	 //Print out the decryption result in the console
    	System.out.println("---The outputtext:"+outputString);
		}

	}



