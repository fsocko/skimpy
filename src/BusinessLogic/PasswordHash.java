//@author Lee

package BusinessLogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * Class for creating a secure password
 */
public class PasswordHash {
	
	public static String getSecurePassword(String password) {
		String passwordHash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			passwordHash = sb.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordHash;
	}

}
