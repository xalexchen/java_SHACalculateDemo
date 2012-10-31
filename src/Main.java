import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class Main {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String securt = "akljtawetbawiotawoetnawetnaw";
		
		// generator random string
		Random generator = new Random();
		StringBuffer randomClient = new StringBuffer();
		for (int i =0;i<20;i++)
		{
			randomClient.append(Integer.toString(generator.nextInt(9)));
		}
		System.out.println("random : " + randomClient);
		
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update((securt+randomClient).getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        System.out.println("Hex format : " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Hex format : " + hexString.toString());
	}

}
