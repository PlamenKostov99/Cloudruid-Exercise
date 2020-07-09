import java.util.List;
import java.util.Scanner;

public class Inventory {

   private Scanner scanner;

    public Inventory(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Products> addProducts(List<Products> allProducts){

        System.out.println(Constants.PRODUCT_DESCRIPTION);
        System.out.println("If you want to stop add products type - end");

        String[] productToAdd = scanner.nextLine().split(" ");

        while (!productToAdd[0].equals("end")) {

            if (productToAdd.length == 2) {

                String number = productToAdd[0].replace("c", "");
                String name = productToAdd[1];
                Integer price = Integer.parseInt(number);

                Products products = new Products(name, price);

                if (!allProducts.contains(products)) {

                    allProducts.add(products);
                    System.out.println(String.format(Constants.SUCCESFULL_ADDED_PRODUCT, products.name,
                            products.price));
                } else {
                    System.out.println(String.format(Constants.ALREADY_IN_LIST, products.name,
                            products.price));
                }
            } else {
                System.out.println(Constants.WRONG_INPUT);
            }

            productToAdd = scanner.nextLine().split(" ");

            System.out.println();
        }
        return allProducts;
    }
}
