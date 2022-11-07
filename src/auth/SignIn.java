package auth;

import org.json.simple.parser.ParseException;
import utils.Account;

import java.io.IOException;

public class SignIn {
    public static void signIn(String name, String password) throws IOException, ParseException {
        if (!Account.isExist(name)) {
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
