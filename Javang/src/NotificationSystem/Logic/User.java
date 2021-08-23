package NotificationSystem.Logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Vanessa Watson
 * @version 11.5.2020
 *
 */

public class User {
    /**
     * @param email verifying email address is in correct format
     * @return
     */
    public static boolean verifyEmail(String email) {
        boolean At = false;
        boolean dotAfterAt = false;
        boolean input = false;
        int atInt = -1;
        int charInt = 0;
        int dotAfterAtInt = -1;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                if (At) {
                    return false;
                }
                At = true;
                atInt = charInt;

                if (charInt == 0 || charInt == email.length() - 1) {
                    return false;
                }
            }

            if (c == '.') {
                if (charInt == 0 || charInt == email.length() - 1) {
                    return false;
                }

                if (email.charAt(charInt + 1) == '@') {
                    return false;
                }

                if (email.charAt(charInt + 1) == '.' || email.charAt(charInt - 1) == '.') {
                    return false;
                }

                if (At) {
                    if (dotAfterAt) {
                        return false;
                    }
                    dotAfterAt = true;
                    dotAfterAtInt = charInt;
                }
            }

            charInt += 1;
        }

        if ((At && dotAfterAt) && dotAfterAtInt - atInt > 1) {
            if (email.length() <= 50) {
                input = true;
            }
        }

        if (email.contains("@")) {
            return input;
        }
        return false;
    }

    /**
     * @param password create password
     * @param password2 confirm password
     * @return
     * makes sure they match when in account creation
     */
    public static boolean registerPassword(String password, String password2) {
        if (password.equals(password2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String hashPassword(String password, String salt){
        String hashedPW = null;

        password += salt;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i ++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPW = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return hashedPW;
    }

    public static byte[] salt = new byte[16];

    public static String generateSalt(){
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return null;
    }
}