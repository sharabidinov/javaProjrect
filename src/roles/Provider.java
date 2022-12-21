package src.roles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Provider {
    Scanner sc = new Scanner(System.in);
    public String name;
    public String role;

    private static final String filePath = System.getProperty("user.dir") + "/src/data/need_material.json";
    private static JSONArray products;

    public Provider(String name, String role) {
        this.name = name;
        this.role = role;
    }

    static {
        try {
            products = utils.FileUtils.ReadJsonFile(filePath);
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void chooseAction() {
        System.out.println("Please choose the menu number to work with the program, if finished, then enter 5:");
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
            case 2:
                productsSuppliedNumber();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 3:
                mostOrderItem();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 4:
                leastOrderItem();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 5:
                System.exit(0);
        }

    }

    public void deliveryList() {
        for (Object o : products) {
            JSONObject product = (JSONObject) o;
            System.out.println(product.get("product"));
        }
    }

    public void productsSuppliedNumber() {
        System.out.println("Supplied goods: " + products.toArray().length);
    }

    public void mostOrderItem() {
        JSONObject m_ordered_product = new JSONObject();
        int max = 1;

        for (Object o : products) {
            JSONObject product = (JSONObject) o;
            Long product_orders = (Long) product.get("orders");
            if (product_orders > max) {
                max = Math.toIntExact(product_orders);
                m_ordered_product = product;
            }
        }

        System.out.print("Most Order item is: ");
        System.out.print(m_ordered_product.get("product"));
        System.out.println(" with orders number of : " + max);
    }

    public void leastOrderItem() {
        JSONObject l_ordered_product = new JSONObject();
        int least = 1;

        for (Object o : products) {
            JSONObject product = (JSONObject) o;
            Long product_orders = (Long) product.get("orders");
            if (least > product_orders) {
                least = Math.toIntExact(product_orders);
                l_ordered_product = product;
            }
        }

        System.out.print("Least Order item is: ");
        System.out.print(l_ordered_product.get("product"));
        System.out.println(" with orders number of : " + least);
    }
}
