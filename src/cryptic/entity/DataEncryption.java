package cryptic.entity;

import cryptic.utility.DataExtraction;
import cryptic.utility.DataOperation;

public class DataEncryption {
	/**
	 * This class has method for encrypting the plain text
	 * the string input from user is first converted to hexadecimal 
	 * then it is converted to binary to perform the bit wise operation
	 * cipher key is generated randomly for each byte and is computed likewise
	 * xor operation is achieved by equating the bit stream in an array*
	 * @author charu
	 */

	DataOperation dataOp = new DataOperation();
	DataExtraction dataEx = new DataExtraction();
	protected static String key = "";
	protected static String encryptedText ="";

	/**
	 * encrypts the data
	 * 
	 * @param data
	 * @return
	 */
	public String encryptData(String data) {

		String hexInput = dataOp.convertToHex(data);

		String xorString = "";
		String xorstringKey = "";
		for (int numberChar = 0; numberChar < hexInput.length(); numberChar = numberChar + 2) {
			char[] charArray = hexInput.toCharArray();
			String strKeyBinary = "";
			String strKeyHex = "";
			String strEncrypt = "";
			for (int j = numberChar; j < numberChar + 1; j++) {
				strKeyHex = "" + charArray[j] + charArray[j + 1] + "";
				if (j == hexInput.length())
					break;
			}
			String strPlaintextBinary = dataOp.convertHexToBinary(strKeyHex);
			strKeyBinary = dataOp.generatePassKey();
			strEncrypt = dataOp.xorOperation(strKeyBinary, strPlaintextBinary);
			
			xorString = xorString + strEncrypt;
			xorstringKey = xorstringKey + strKeyBinary;
			key = xorstringKey;
			encryptedText = xorString;
		}
		String stringEncodedtext = dataEx.getEncryptedTextMessage(xorString);
		return stringEncodedtext;
	}
 
	
}
