package cryptic.utility;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class DataOperation {
	/**
	 * This class has the methods for performing operations on the data string,
	 * hexadecimal, binary conversions generating the cipher key for the
	 * encryption*
	 * 
	 * @author charu
	 */

	/**
	 * performs xor operation bitwise
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public String xorOperation(String string1, String string2) {
		String val = "";
		String xorComputedCharStr = "";
		char[] strChar1 = string1.toCharArray();
		char[] strChar2 = string2.toCharArray();
		for (int k = 0; k < 8; k++) {
			if (strChar1[k] == strChar2[k])
				val = "0";
			else
				val = "1";
			xorComputedCharStr = xorComputedCharStr + val;
		}
		return xorComputedCharStr;
	}

	/**
	 * generate 8-digit cipherKey
	 * 
	 * @return
	 */
	public String generatePassKey() {
		Integer randomXORkey = ThreadLocalRandom.current().nextInt(128, 255);
		Integer xorBinaryKey = Integer.parseInt(Integer.toBinaryString(randomXORkey));
		return String.valueOf(xorBinaryKey);
	}

	/**
	 * convert the String to hexadecimal String
	 * 
	 * @param data
	 * @return
	 */
	public String convertToHex(String data) {
		StringBuilder inputData = new StringBuilder();

		char ch[] = data.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			String hexString = Integer.toHexString(ch[i]);
			inputData.append(hexString);
		}

		String resultHex = inputData.toString();
		return resultHex;
	}

	/**
	 * convert hexadecimal to binary by hash map
	 * 
	 * @param hex
	 * @return
	 */
	public String convertHexToBinary(String hex) {
		String binary = "";
		hex = hex.toUpperCase();
		HashMap<Character, String> hashMap = new HashMap<Character, String>();
		hashMap.put('0', "0000");
		hashMap.put('1', "0001");
		hashMap.put('2', "0010");
		hashMap.put('3', "0011");
		hashMap.put('4', "0100");
		hashMap.put('5', "0101");
		hashMap.put('6', "0110");
		hashMap.put('7', "0111");
		hashMap.put('8', "1000");
		hashMap.put('9', "1001");
		hashMap.put('A', "1010");
		hashMap.put('B', "1011");
		hashMap.put('C', "1100");
		hashMap.put('D', "1101");
		hashMap.put('E', "1110");
		hashMap.put('F', "1111");

		int i;
		char ch;
		for (i = 0; i < hex.length(); i++) {
			ch = hex.charAt(i);
			if (hashMap.containsKey(ch)) {

				binary += hashMap.get(ch);
			} else {
				binary = "Invalid Hexadecimal String entered";
				return binary;

			}
		}
		return binary;
	}

	/**
	 * convert hexadecimal to Character String
	 * 
	 * @param hexData
	 * @return
	 */
	public String convertHexToString(String hexData) {

		String resultStr = new String();
		char[] charArrayHex = hexData.toCharArray();
		for (int numberChar = 0; numberChar < charArrayHex.length; numberChar = numberChar + 2) {
			String st = "" + charArrayHex[numberChar] + "" + charArrayHex[numberChar + 1];
			char ch = (char) Integer.parseInt(st, 16);
			resultStr = resultStr + ch;
			if (numberChar == charArrayHex.length)
				break;
		}
		return resultStr;

	}

}
