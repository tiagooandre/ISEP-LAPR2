/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.security.SecureRandom;

/**
 *
 * @author Gon�alo
 */
public class GeneratePassword {
    
    public GeneratePassword(){
        // this is a constructor empty for this class
    }
    //https://www.techiedelight.com/generate-random-alphanumeric-password-java/
    public static String generatePassword()
    {
        // alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        String result="";
        result = sb.toString();
        return result;
    }

    
}
