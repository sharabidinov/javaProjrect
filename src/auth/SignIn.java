package src.auth;

import org.json.simple.parser.ParseException;
import roles.SalesMan;
import src.roles.DeliveryMan;
import src.roles.Provider;
import src.utils.Account;

import java.io.IOException;
import java.util.Objects;

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
        if (Objects.equals(role, "salesman")) {
            SalesMan salesman = new SalesMan(name, role);
            salesman.chooseAction();
        } else if (Objects.equals(role, "provider")) {
            Provider provider = new Provider(name, role);
            provider.chooseAction();
        } else {
            DeliveryMan delivery = new DeliveryMan(name, role);
            delivery.chooseAction();
        }

    }
}
