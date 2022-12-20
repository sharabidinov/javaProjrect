package auth;

import org.json.simple.parser.ParseException;
import utils.Account;

import java.io.IOException;

public class SignIn {
    public static void signIn(String name, String password, String role) throws IOException, ParseException {
        if (!Account.isExist(name, role)) {
            System.out.println("Account not found, please provide correct credentials");
            System.exit(0);
        }

        if (!Account.checkPassword(name, password)) {
            System.out.println("Name or Password not correct");
            System.exit(0);
        }

        System.out.println("Welcome, " + name);

    }
}
