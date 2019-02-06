package challengeSet1;

import java.math.BigInteger;
import java.util.Base64;


public class CrytoSet1p1 {
	
	//convert hex to base64
	public static void main(String [] args) {
		String str = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		System.out.println(str);
		String strb64 = hexToBase64(str);
		System.out.println(strb64);
		String decodestr = base64ToHex(strb64);
		System.out.println(decodestr);
		
	}
	
	public static String hexToBase64(String strHex) {
		BigInteger value = new BigInteger(strHex,16);
		byte[] bits = value.toByteArray();
		return Base64.getEncoder().encodeToString(bits);
	}
	
	public static String base64ToHex(String strb64) {
		byte [] bits = Base64.getDecoder().decode(strb64);
		String hex = String.format("%040x", new BigInteger(1,bits));
		return hex;
	}
	

}
