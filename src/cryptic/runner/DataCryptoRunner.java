package cryptic.runner;

import java.util.Scanner;

import org.junit.Assert;

import cryptic.entity.DataDecryption;
import cryptic.entity.DataEncryption;


public class DataCryptoRunner {
	
	public static void main(String[] args) {
		/**
		 * 
		 * This is the main runner class to execute the cryptographic operation
		 * it takes user input from console and reflects the result in it*
		 * @author charu
		 * 
		 */
		DataEncryption encrypt = new DataEncryption();
		DataDecryption decrypt = new DataDecryption();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello User!"+"\n"+"Enter your message which you want to encrypt: ");
		String plainText = sc.nextLine();
		String encryptedText = encrypt.encryptData(plainText);
		String decryptedText = decrypt.decryptData(encryptedText);
		
		System.out.println("Original Message as plain text  : " +plainText);
		System.out.println("Encrypted Message as cipher text: " +encryptedText);
		System.out.println("The message is decrypted as     : "+decryptedText);
		Assert.assertEquals(plainText, decryptedText);
		
		sc.close();
	}

}
