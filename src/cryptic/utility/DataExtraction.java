package cryptic.utility;

public class DataExtraction {
	/**
	 * this class includes the methods to extract binary and string data in the
	 * process of encryption and decryption*
	 * 
	 * @author charu
	 */

	DataOperation dataOp = new DataOperation();

	/**
	 * get the String encoded encrypted text
	 * 
	 * @param binaryData
	 * @return
	 */
	public String getEncryptedTextMessage(String binaryData) {
		String encryptedMessage = "";
		for (int numberOfChar = 0; numberOfChar < binaryData.length(); numberOfChar = numberOfChar + 8) {
			char[] charArrayEncryptText = binaryData.toCharArray();
			String strEncrypt = "";
			for (int j = numberOfChar; j < numberOfChar + 8; j++) {
				strEncrypt = strEncrypt + charArrayEncryptText[j];
				if (j == binaryData.length())
					break;
			}

			int decimal = Integer.parseInt(String.valueOf(strEncrypt), 2);
			/* System.out.println("decimal decrypted :" + decimal); */
			String hexString = Integer.toString(decimal, 16);

			/* System.out.println("hex decrypted :" + hexString); */
			String encryptedMessageText = dataOp.convertHexToString(hexString);
			/* System.out.println(encryptedMessageText); */
			encryptedMessage = encryptedMessage + encryptedMessageText;
		}

		return encryptedMessage;
	}

	/**
	 * get the binary encoded message from encrypted text
	 * 
	 * @param encryptedStr
	 * @return
	 */
	public String getBinaryEncryptedMessage(String encryptedStr) {

		String hexDataEncryptedMessage = dataOp.convertToHex(encryptedStr);
		String binaryEncryptedText = "";
		String encryptTextStr = "";
		for (int numberChar = 0; numberChar < hexDataEncryptedMessage.length(); numberChar = numberChar + 2) {
			char[] charArray = hexDataEncryptedMessage.toCharArray();
			String strTextHex = "";
			for (int j = numberChar; j < numberChar + 1; j++) {
				strTextHex = "" + charArray[j] + charArray[j + 1] + "";
				/* System.out.println(strKeyHex); */
				if (j == hexDataEncryptedMessage.length())
					break;
			}
			binaryEncryptedText = dataOp.convertHexToBinary(strTextHex);
			encryptTextStr = encryptTextStr + binaryEncryptedText;
		}
		return encryptTextStr;
	}

}
