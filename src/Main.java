import auth.SignIn;
import auth.SignUp;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        System.out.println("Welcome to Coca-Cola");

        Scanner input = new Scanner(System.in);

        int auth = authChoice(input);

        if (auth == 1) {
            signUpNewAccount(input);
        } else {
            signInAccount(input);
        }

    }

    private static int authChoice(@NotNull Scanner input) {
        System.out.println("1: Sign up");
        System.out.println("2: Sign in");

        ArrayList<Integer> authChoices = new ArrayList<Integer>();

        authChoices.add(1);
        authChoices.add(2);

        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        if (!authChoices.contains(choice)) {
            System.out.println("Choice must be in " + authChoices);
            System.exit(0);
        }

        return choice;
    }

    private static void signUpNewAccount(@NotNull Scanner input) throws ParseException, IOException {
        System.out.print("Enter your name: ");
        String name = input.next();

        System.out.print("Enter your password: ");
        String password = input.next();

        SignUp.create_account(name, password);
    }

    private static void signInAccount(@NotNull Scanner input) throws IOException, ParseException {
        System.out.print("Enter your name: ");
        String name = input.next();

        System.out.print("Enter your password: ");
        String password = input.next();

        SignIn.signIn(name, password);

    }
}