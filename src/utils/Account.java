package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Account {
    private static final String filePath = System.getProperty("user.dir") + "/src/data/passwords.json";
    private static JSONArray accounts;

    static {
        try {
            accounts = FileUtils.ReadJsonFile(filePath);
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean isExist(String name) throws IOException, ParseException {
        for (Object o : accounts) {
            JSONObject account = (JSONObject) o;

            if (account.get("name").equals(name)) {
                return Boolean.TRUE;
            }

        }

        return Boolean.FALSE;
    }

    public static void CreateAccount(String name, String password, String role) throws ParseException, IOException {

        if (isExist(name)) {
            System.out.println("This account already exists please use another name");
            System.exit(0);
        }



        // create new json object to save the account info
        JSONObject accountJsonObject = new JSONObject();

        // assign name and password to the account json object
        accountJsonObject.put("name", name);
        accountJsonObject.put("password", password);
        accountJsonObject.put("role", role);

        // add new account to the existence accounts
        accounts.add(accountJsonObject);

        FileUtils.WriteJsonFile(filePath, accounts);
        System.out.println("Account successfully created!");
    }

    public static Boolean checkPassword(String name, String password) {
        JSONObject account = getAccount(name);

        if (account != null) {
            String account_password = (String) account.get("password");

            if (account_password.equals(password)) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    public static JSONObject getAccount(String name) {
        for (Object o : accounts) {
            JSONObject account = (JSONObject) o;

            if (account.get("name").equals(name)) {
                return account;
            }

        }

        return null;
    }


}
