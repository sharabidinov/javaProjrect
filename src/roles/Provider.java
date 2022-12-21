package roles;

import java.util.Scanner;

public class Provider {
    Scanner sc = new Scanner(System.in);
    public String name;
    public String role;

    public Provider(String name, String role) {
        this.name = name;
        this.role = role;
    }


    public void chooseAction() {
        System.out.println("Please choose the menu number to work with the program, if finished, then enter 7:");
        System.out.println("1: Show list of products for delivery");
        System.out.println("2: Show the amount of the delivered products");
        System.out.println("3: Show the product with the largest number of orders for delivery");
        System.out.println("4: Show the product with the smallest number of orders for delivery");
        System.out.println("5: Exit");

        switch (sc.nextInt()) {
            case 1:
                deliveryList();
                System.out.println("*".repeat(50));
                chooseAction();
                break;

            case 5:
                System.exit(0);
        }

    }

    public void deliveryList() {
    }
}
