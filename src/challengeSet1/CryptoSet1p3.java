package challengeSet1;

import java.math.BigInteger;
import java.util.HashMap;

public class CryptoSet1p3 {
	
	public static void main(String [] args) {
		String s1 = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
		byte[] bits = convertStrToHex(s1);
		for(int i = 0; i <=127;i++) {
			String keystring = Integer.toHexString(i);
			byte[] hexkey = convertStrToHex(keystring);
			byte[] uncoded = xorCipher(bits,hexkey);
			String plaintext = byteToPlainText(uncoded);
			// displaying ascii value does not display well
			System.out.println("key: "+ i + " : "+ plaintext);
			displayCharFreq(charFreq(plaintext));
		}

	}
	
	public static byte[] convertStrToHex(String hex) {
		BigInteger value = new BigInteger(hex,16);
		byte[] bits = value.toByteArray();
		return bits;
	}
	
	public static byte[] xorCipher(byte[] hex, byte[] key ) {
		byte [] result = new byte[hex.length];
		for(int i =0 ; i < hex.length ; i++) {
			for(int j = 0 ; j < key.length;j++) {
				result[i] = (byte)(hex[i] ^ key[j]);
			}
		}
		return result;
	}
	
	public static String byteToPlainText( byte[] uncoded) {
		String temp = "";
		for(byte bit : uncoded) {
			temp += (char) bit;
		}
		return temp;
	}
	
	public static HashMap<Character,Integer> charFreq(String message){
		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		for(int i = 65; i<= 90;i++) {
			charCount.put((char)i, 0);
		}
		char [] letters = message.toCharArray();
		for(char letter : letters) {
			if(charCount.get(letter) != null) {
				charCount.replace(letter,(charCount.get(letter) + 1) );
			}
		}
		return charCount;
	}
	public static void displayCharFreq(HashMap<Character,Integer> map) {
		System.out.print("{");
		for(char letter : map.keySet()) {
			System.out.print(" "+letter +":" + map.get(letter));
		}
		System.out.print("}\n");
	}
}
