package AdventCode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class dayFour {
	
	public static void main(String[] args)throws Exception
    {
    	String password = "bgvyzdsv";
    	
    	for(int i = 0; i < 1000000000; i++){
    		String append = Integer.toString(i);
    		String hashPwd = password + append;
    		
    		String newString = md5(hashPwd);
    		if (newString.startsWith("0000000")){
    			System.out.println(append);
    			break;	
    		}
    		
    		
    		}
    	
       
    }
	
	public static String md5(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    
	    byte byteData[] = md.digest();

	    //convert the byte to hex format method 1
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++) {
	     sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
		
	}
	
}
