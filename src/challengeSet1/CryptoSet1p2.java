package challengeSet1;
import java.math.BigInteger;

public class CryptoSet1p2 {
	
	// Fixed XOR
	public static void main(String[] args) {
		String hex1 = "1c0111001f010100061a024b53535009181c";
		String hex2 = "686974207468652062756c6c277320657965";
		//res = 746865206b696420646f6e277420706c6179
		byte[] res = xorWithKey(convertStrToHex(hex1),convertStrToHex(hex2));
		System.out.println(hex1);
		System.out.println(hex2);
		String strres = String.format("%16x", new BigInteger(1,res));
		System.out.println(strres);
		
	}
	
	public static byte[] convertStrToHex(String hex) {
		BigInteger value = new BigInteger(hex,16);
		byte[] bits = value.toByteArray();
		return bits;
	}
	
	
    
    public static byte [] xorWithKey(byte[] a, byte [] key) {
    		byte[] res = new byte[a.length];
    		for(int i = 0;i < res.length;i++) {
    			res[i] = (byte)(a[i] ^ key[i]);
    		}
    		return res;
    }
    

}
