package auth;

import org.json.simple.parser.ParseException;
import utils.Account;

import java.io.IOException;

public class SignUp {
    public static void create_account(String name, String password) throws IOException, ParseException {
        Account.CreateAccount(name, password);
    }
}


class Register {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
