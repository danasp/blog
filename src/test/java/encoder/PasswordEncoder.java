package encoder;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * User: Danila Vereshchakov
 * Date: 04.06.2017
 */

public class PasswordEncoder {

    @Test
    public void passwordEncoder() {
        String password = "you_password_here";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        System.out.println(hashedPassword);
    }
}
