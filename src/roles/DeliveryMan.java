package roles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DeliveryMan {

    Scanner sc = new Scanner(System.in);

    public String name;
    public String role;

    public DeliveryMan(String name, String role) {
        this.name = name;
        this.role = role;
    }

    private static final String file = System.getProperty("user.dir") + "/src/data/solt.txt";
    private static final String file2 = System.getProperty("user.dir") + "/src/data/delivered.txt";

    public void chooseAction() throws IOException {
        System.out.println("Please choose the menu number to work with the program, if finished, then enter 7:");
        System.out.println("1: Show a list of products for delivery");
        System.out.println("2: Show delivered orders");
        System.out.println("3: Show the amount of delivered goods");
        System.out.println("4: Show the number of products ordered");
        System.out.println("5: Show my income");
        System.out.println("6: Exit");

        switch (sc.nextInt()) {
            case 1:
                deliveryList();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 2:
                delivered();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }


    public void deliveryList() {
        System.out.println("The list of products for delivery:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delivered() throws IOException {
        System.out.println("Delivered orders: ");
        BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(file2)));
        for (String line; (line = br.readLine()) != null; ) {
            System.out.println(line);
        }
    }
}
