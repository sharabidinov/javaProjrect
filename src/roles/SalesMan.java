package roles;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesMan {
    Scanner sc = new Scanner(System.in);

    public String name;
    public String role;
    private static final String file = System.getProperty("user.dir") + "/src/data/sale.txt";
    private static final String file2 = System.getProperty("user.dir") + "/src/data/solt.txt";
    private static final String file3 = System.getProperty("user.dir") + "/src/data/products_for_order.txt";
    private static final String file4 = System.getProperty("user.dir") + "/src/data/ordered_products.txt";

    public SalesMan(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void chooseAction() throws IOException {
        System.out.println("Please choose the menu number to work with the program, if finished, then enter 6:");
        System.out.println("1: Show the entire list of products for sale");
        System.out.println("2: Search for a product");
        System.out.println("3: Show a sales report");
        System.out.println("4: Order for a missing item");
        System.out.println("5: Delete an order");
        System.out.println("6: Exit");

        switch (sc.nextInt()) {
            case 1:
                showProducts();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 2:
                searchProduct();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 3:
                salesReport();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 4:
                orderMissProd();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 5:
                deleteOrder();
                System.out.println("*".repeat(50));
                chooseAction();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    public void showProducts() {
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

    public void searchProduct() throws IOException {
        boolean isAvailable = false;
        System.out.print("Product name: ");
        sc.next();
        String product = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.contains(product)) {
                    isAvailable = true;
                    break;
                }
            }
            if (isAvailable) System.out.println("Product is available");
            else System.out.println("Product is unavailable");
        }
    }

    public void salesReport() {
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderMissProd() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file3));
        for (String line; (line = br.readLine()) != null; ) {
            System.out.println(line);
        }
        System.out.print("Choose product to order: ");
        String order = sc.next();
        try {
            FileWriter fw = new FileWriter(file4, true);
            fw.append(order + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOrder() throws IOException {
        ArrayList<String> products = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file4));
        for (String line; (line = br.readLine()) != null; ) {
            System.out.println(line);
            products.add(line);
        }
        System.out.println(products);
        System.out.print("choose product to delete it: ");
        String order = sc.next();
        products.remove(order);
        try {
            FileWriter fw = new FileWriter(file4);
            for (String i : products) {
                fw.append(i + "\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
