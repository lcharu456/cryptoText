package cryptic.entity;

import cryptic.utility.DataExtraction;
import cryptic.utility.DataOperation;

public class DataDecryption {
	/**
	 * This class has method for decrypting the cipher text generated after
	 * encryption it follows the reverse mechanism to reconstruct the original
	 * message from the cipher text with the help of same key which was used to
	 * encrypt the text message*
	 * 
	 * @author charu
	 */

	DataOperation dataOp = new DataOperation();
	DataExtraction dataEx = new DataExtraction();
	private String plainText = "";

	/**
	 * decrypt the encrypted data
	 * 
	 * @param encryptData
	 * @return
	 */
	public String decryptData(String encryptedData) {

		String binaryEncodedMessage = dataEx.getBinaryEncryptedMessage(encryptedData);

		for (int numberOfChar = 0; numberOfChar < DataEncryption.key.length(); numberOfChar = numberOfChar + 8) {

			char[] charArray = DataEncryption.key.toCharArray();
			char[] charArrayEncryptText = binaryEncodedMessage.toCharArray();

			String strKey = "";
			String strEncrypt = "";
			String strDecrypt = "";
			for (int j = numberOfChar; j < numberOfChar + 8; j++) {
				strKey = strKey + charArray[j];
				strEncrypt = strEncrypt + charArrayEncryptText[j];
				if (j == DataEncryption.key.length())
					break;
			}

			strDecrypt = dataOp.xorOperation(strKey, strEncrypt);
			int decimal = Integer.parseInt(String.valueOf(strDecrypt), 2);
			String hexString = Integer.toString(decimal, 16);
			String reconstructedPlainText = dataOp.convertHexToString(hexString);
			plainText = plainText + reconstructedPlainText;
		}

		return plainText;
	}

}